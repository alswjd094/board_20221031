package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.dto.CommentDTO;
import com.its.board.dto.PageDTO;
import com.its.board.service.BoardService;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private CommentService commentService;


//    @GetMapping("/board/save") //@RequestMapping X
        @GetMapping("/save")
        public String boardSaveForm () {
            return "boardSave"; //=>views/boardSave.jsp (X)
//          return "boardPages/boardSave";//=>views/boardPages/boardSave.jsp
        }

        @PostMapping("/save")
        public String boardSave (@ModelAttribute BoardDTO boardDTO) throws IOException {
            boardService.boardSave(boardDTO);
                return "redirect:/board/";
        }

        @GetMapping("/")
        public String boardForm (Model model){
            List<BoardDTO> boardDTO = boardService.boardForm();
            model.addAttribute("findAll", boardDTO);
            return "boardList";
        }

        @GetMapping("/paging")
        public String paging(Model model,
                             @RequestParam(value = "page",required = false, defaultValue = "1") int page){
        //value: 받으려는 파라미터 이름, required: 파라미터가 필수인가 아닌가, defaultValue: 필수는 아니지만 오지 않았을 경우 기본값, 1페이지
//            System.out.println("page = " + page);
            //해당 페이지에서 보여줄 글 목록
            List<BoardDTO> pagingList = boardService.pagingList(page);
            //하단 페이지 번호 표현을 위한 데이터
            PageDTO pageDTO = boardService.pagingParam(page);
            model.addAttribute("findAll",pagingList);
            model.addAttribute("paging", pageDTO);
            return "boardPaging";
        }

        @GetMapping
        public String findById (@RequestParam("id") Long id, Model model,
                                @RequestParam(value = "page",required = false, defaultValue = "1") int page){
            boardService.updateHits(id);
            BoardDTO findByIdResult = boardService.findById(id);
            model.addAttribute("page",page);
            model.addAttribute("findById", findByIdResult);
            System.out.println("조회: findByIdResult = " + findByIdResult);
            //commentService 불러오기
            List<CommentDTO> commentDTOList = commentService.findAllComment(id);
            model.addAttribute("commentList",commentDTOList);
            return "boardDetail";
        }

        @GetMapping("/update")
        public String updateForm(Model model,@RequestParam("id") Long id){
            BoardDTO updateForm = boardService.findById(id);
            model.addAttribute("findById",updateForm);
            return "boardUpdate";
        }
        @PostMapping("/update")
        public String update(@ModelAttribute BoardDTO boardDTO,Model model) {
             boardService.update(boardDTO);
                //수정 처리 후 상세페이지 출력
                //redirect로 상세페이지 요청->조회수 올라감
//                return "redirect:/board?id="+boardDTO.getId();
                //db에서 가져와서 boardDetail 출력
                BoardDTO dto = boardService.findById(boardDTO.getId());
                model.addAttribute("findById",dto);
                return"boardDetail";
        }
    @GetMapping("/deleteCheck")
    public String deleteForm (@RequestParam("id") Long id, Model model){
        BoardDTO deleteForm = boardService.findById(id);
        model.addAttribute("findById",deleteForm);
        return "deleteCheck";
    }

    @GetMapping ("/delete")
    public String delete (@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }
    @GetMapping("/search")
    public String search(@RequestParam("type") String type, @RequestParam("q") String q, Model model){
            List<BoardDTO> searchList = boardService.search(type,q);
            model.addAttribute("findAll",searchList);
            return"boardList";
    }

    }

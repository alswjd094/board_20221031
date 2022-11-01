package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/save")
    public String boardSaveForm(){
        return "boardSave";
    }

    @PostMapping("/board/save")
    public String boardSave(@ModelAttribute BoardDTO boardDTO){
        boolean boardSaveResult = boardService.boardSave(boardDTO);
        if(boardSaveResult){
            return "redirect:/board/";
        } else {
            return "saveFalse";
        }
    }

    @GetMapping("/board/")
    public String boardForm(Model model){
        List<BoardDTO> boardDTO = boardService.boardForm();
        model.addAttribute("findAll",boardDTO);
        return "boardList";
    }

    @GetMapping("/board")
    public String findById(@RequestParam("id") Long id, Model model){
        BoardDTO findByIdResult = boardService.findById(id);
        model.addAttribute("findById",findByIdResult);
        return "boardDetail";
    }


    @GetMapping("/board/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }
}

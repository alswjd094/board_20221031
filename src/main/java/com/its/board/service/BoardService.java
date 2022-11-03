package com.its.board.service;

import com.its.board.commons.PagingConst;
import com.its.board.dto.BoardDTO;
import com.its.board.dto.PageDTO;
import com.its.board.repository.BoardRepository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    /*
1. boardDTO 객체에 담긴 파일을 꺼냄
2. 파일의 원본 이름을 가져오기(originalFileName)
3. 서버 관리용 이름 만듦(storedFileName)
4. originalFileName, storedFileName을 DTO 객체에 담음
5. 파일 실제 저장 위치 지정
6. 파일 저장 처리
7. repository로 dto 객체 전달
 */
    public void boardSave(BoardDTO boardDTO) throws IOException {
        // if = 파일이 있으면
        if(!boardDTO.getBoardFile().isEmpty()){
        System.out.println("파일있음");
        MultipartFile boardFile = boardDTO.getBoardFile();//1.
        String originalFilename = boardFile.getOriginalFilename(); //2.
        System.out.println("originalFilename = " + originalFilename); //soutv
        System.out.println(System.currentTimeMillis());
        String storedFileName = System.currentTimeMillis() + "-" + originalFilename;//3
        System.out.println("storedFileName = " + storedFileName); //soutv
        boardDTO.setOriginalFileName(originalFilename);
        boardDTO.setStoredFileName(storedFileName); //4.
        String savePath="C:\\spring_img\\" + storedFileName; //5. 내가 이 파일을 이 경로에 저 이름으로 저장하겠다
        boardFile.transferTo(new File(savePath)); //6.
            boardDTO.setFileAttached(1);
        BoardDTO savedBoard = boardRepository.boardSave(boardDTO); //7. 게시글 저장, id 값 추가된 객체 가져옴
        boardRepository.saveFileName(savedBoard);
        } else{
            System.out.println("파일없음");
            boardDTO.setFileAttached(0);
            boardRepository.boardSave(boardDTO);
        }

    }
    public List<BoardDTO> boardForm() {
        return boardRepository.boardForm();
    }

    public void updateHits(Long id){
        boardRepository.updateHits(id);
    }
    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public List<BoardDTO> pagingList(int page) {
        /*
        page = 1페이지 -> (0, )
        page = 2페이지 -> (3, )
        page = 3페이지 -> (6, )
         */
        int pagingStart = (page-1) * PagingConst.PAGE_LIMIT;
                                    //클래스이름.상수이름;
        //두 개이상의 데이터를 매퍼에 한번에 보낼때(담는 값의 타입이 같아야 함)
        Map<String, Integer> pagingParams = new HashMap<>();
        //값 담기
        pagingParams.put("start",pagingStart);
        pagingParams.put("limit", PagingConst.PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page) {
        //전체 글 개수 조회
        int boardCount = boardRepository.boardCount();
        //전체 페이지 개수 계산
        int maxPage = (int) (Math.ceil((double) boardCount / PagingConst.PAGE_LIMIT));
        //시작 페이지 값 계산(1, 4, 7, 10, ---)
        int startPage = (((int)(Math.ceil((double) page / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;
        //끝 페이지 값 계산(3, 6, 9, 12---)
        int endPage = startPage + PagingConst.BLOCK_LIMIT - 1;
        if(endPage >maxPage){
            endPage = maxPage;
            //end페이지 값이 max값보다 크다면 end페이지값을 max값으로 덮어쓴다.
        }
        //dto로 담아 가야함
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }
}

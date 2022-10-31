package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "boardList";
    }
}

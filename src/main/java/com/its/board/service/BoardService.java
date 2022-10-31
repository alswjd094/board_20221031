package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public boolean boardSave(BoardDTO boardDTO) {
        int boardSaveResult = boardRepository.boardSave(boardDTO);
        if(boardSaveResult > 0){
            return true;
        }else{
            return false;
        }
    }
}

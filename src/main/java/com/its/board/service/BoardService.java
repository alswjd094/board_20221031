package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private SqlSessionTemplate sql;
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
    public List<BoardDTO> boardForm() {
        return boardRepository.boardForm();
    }

    public BoardDTO findById(Long id) {
        sql.update("Board.findByHits",id);
        return boardRepository.findById(id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }


}

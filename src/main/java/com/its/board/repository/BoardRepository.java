package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public int boardSave(BoardDTO boardDTO) {
        return sql.insert("Board.boardSave",boardDTO);
    }

    public List<BoardDTO> boardForm() {
        return sql.selectList("Board.boardForm");
    }

    public BoardDTO findById(Long id) {
        BoardDTO result = null;

        return sql.selectOne("Board.findById",id);
    }

    public void delete(Long id) {
        sql.delete("Board.delete",id);
    }


}

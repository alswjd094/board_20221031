package com.its.board.service;

import com.its.board.dto.CommentDTO;
import com.its.board.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
   private CommentRepository commentRepository;
    public void commentSave(CommentDTO commentDTO) {
       commentRepository.commentSave(commentDTO);

    }

    public List<CommentDTO> findAllComment(Long boardId) {
        return commentRepository.findAllComment(boardId);
    }
}

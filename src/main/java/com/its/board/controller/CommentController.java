package com.its.board.controller;

import com.its.board.dto.CommentDTO;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;


    @PostMapping("/comment/save")
    public @ResponseBody List<CommentDTO> commentSave(@ModelAttribute CommentDTO commentDTO){
        //댓글을 쓰고나면 디비에서 정보를 가져온다음에 댓글이 포함된 상태로 디비 보여줌
        commentService.commentSave(commentDTO);
        List<CommentDTO> commentDTOList = commentService.findAllComment(commentDTO.getBoardId());
        return commentDTOList;
    }
}

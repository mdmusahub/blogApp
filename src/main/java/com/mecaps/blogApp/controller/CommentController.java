package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;
import com.mecaps.blogApp.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping("/create")
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO requestDTO){
        return commentService.createComment(requestDTO);
    }
}


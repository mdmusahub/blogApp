package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;
import com.mecaps.blogApp.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/getAllAuthorComment/{authorId}")
    public List<CommentResponseDTO> getAllCommentByAuthorId(@PathVariable Long authorId){
        List<CommentResponseDTO> allCommentByAuthor = commentService.getAllCommentByAuthor(authorId);
        return allCommentByAuthor;
    }

    @PatchMapping("/update/{commentId}")
    public CommentResponseDTO updateComment(@PathVariable Long commentId,
                                            @RequestBody CommentRequestDTO requestDTO){
        return commentService.commentUpdate(commentId, requestDTO);
    }

    @GetMapping("/getAll")
    public List<CommentResponseDTO> getAll(){
        return commentService.getAllComment();
    }


    @DeleteMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId);
    }



/*

Status code
Header
Body Reponse (User, Post, Comment)
* */

}


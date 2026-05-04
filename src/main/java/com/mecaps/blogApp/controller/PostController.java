package com.mecaps.blogApp.controller;


import com.mecaps.blogApp.entity.Post;
import com.mecaps.blogApp.requestDTO.PostRequestDTO;
import com.mecaps.blogApp.responseDTO.PostResponseDTO;
import com.mecaps.blogApp.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {


    private PostService postService;

    private PostController(PostService postService){
        this.postService = postService;
    }



    @GetMapping("/getAuthorById/{authorId}")
    public List<PostResponseDTO> getPostByAuthorId(@PathVariable Long authorId){
        return postService.findPostByAuthorId(authorId);
    }


    @GetMapping("/getAll")
    public List<PostResponseDTO> getAllPost(){
        return postService.getAllPost();
    }


    @PostMapping("/create")
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO requestDTO){

        PostResponseDTO post = postService.createPost(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }



    @PutMapping("/update/{id}")
    public PostResponseDTO updatePostById(@PathVariable Long id, @RequestBody PostRequestDTO requestDTO){
        return postService.updatePost(id, requestDTO);
    }


    @DeleteMapping("delete/{id}")
    public String deletePostById(@PathVariable Long id){
        return postService.deletePostById(id);
    }
}

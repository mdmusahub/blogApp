package com.mecaps.blogApp.serviceImpl;

import com.mecaps.blogApp.entity.Post;
import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.PostRepository;
import com.mecaps.blogApp.repository.UsersRepository;
import com.mecaps.blogApp.requestDTO.PostRequestDTO;
import com.mecaps.blogApp.responseDTO.PostResponseDTO;
import com.mecaps.blogApp.service.PostService;

public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UsersRepository usersRepository;

    public PostServiceImpl(PostRepository postRepository, UsersRepository usersRepository){
        this.postRepository= postRepository;
        this.usersRepository= usersRepository;
    }


    @Override
    public PostResponseDTO createPost(PostRequestDTO requestDTO) {
        Users user = usersRepository.findById(requestDTO.getAuthorId()).orElseThrow(
                () -> new RuntimeException("User id not found  : " + requestDTO.getAuthorId())
        );
        Post post = new Post();
        post.setContent(requestDTO.getContent());
        post.setAuthor(user);
        Post savePost = postRepository.save(post);
        return new PostResponseDTO(savePost);
    }
}

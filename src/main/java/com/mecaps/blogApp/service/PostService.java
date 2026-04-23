package com.mecaps.blogApp.service;

import com.mecaps.blogApp.requestDTO.PostRequestDTO;
import com.mecaps.blogApp.responseDTO.PostResponseDTO;

public interface PostService {

    PostResponseDTO createPost(PostRequestDTO requestDTO);

}

package com.mecaps.blogApp.service;

import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;

public interface CommentService {


    CommentResponseDTO createComment(CommentRequestDTO requestDTO);
}

package com.mecaps.blogApp.service;

import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;
import java.util.List;

public interface CommentService {

    CommentResponseDTO createComment(CommentRequestDTO requestDTO);

    List<CommentResponseDTO> getAllCommentByAuthor(Long authorId);

    CommentResponseDTO commentUpdate(Long commentId, CommentRequestDTO requestDTO);

    List<CommentResponseDTO> getAllComment();

    String deleteComment(Long commentId);

}

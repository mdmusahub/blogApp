package com.mecaps.blogApp.requestDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {

    private String commentString;
    private Long postId;
    private Long authorId;
}

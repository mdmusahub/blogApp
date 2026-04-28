package com.mecaps.blogApp.requestDTO;


import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class CommentRequestDTO {

    private String commentString;
    private Long postId;
    private Long authorId;
}

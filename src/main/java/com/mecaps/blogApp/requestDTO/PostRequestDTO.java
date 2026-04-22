package com.mecaps.blogApp.requestDTO;

import com.mecaps.blogApp.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {

    private String content;
    private Long authorId;
}

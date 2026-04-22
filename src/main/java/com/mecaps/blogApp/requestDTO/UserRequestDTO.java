package com.mecaps.blogApp.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {
    private String userName;
    private String password;
    private String email;

}

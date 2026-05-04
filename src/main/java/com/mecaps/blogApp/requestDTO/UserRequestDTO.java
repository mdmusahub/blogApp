package com.mecaps.blogApp.requestDTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {

    @NotBlank(message = "User Name is Required!")
    @Size(min = 3, max = 10, message = "User name must be between 3 and 10 characters!")
    private String userName;
    private String password;
    @Email
    private String email;

}


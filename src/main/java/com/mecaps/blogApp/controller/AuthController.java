package com.mecaps.blogApp.controller;


import com.mecaps.blogApp.requestDTO.LoginRequestDTO;
import com.mecaps.blogApp.service.AuthService;
import com.mecaps.blogApp.serviceImpl.AuthServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }




    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody LoginRequestDTO requestDTO){

        if (requestDTO == null){
            throw new RuntimeException("Body is empty .... please send data ");
        }

        return authService.loginUser(requestDTO);
    }
}

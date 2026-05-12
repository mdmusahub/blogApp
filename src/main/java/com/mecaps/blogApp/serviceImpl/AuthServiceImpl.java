package com.mecaps.blogApp.serviceImpl;


import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.exception.ResourcesNotFoundException;
import com.mecaps.blogApp.repository.UsersRepository;
import com.mecaps.blogApp.requestDTO.LoginRequestDTO;
import com.mecaps.blogApp.security.JwtService;
import com.mecaps.blogApp.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {


    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UsersRepository usersRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {

        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    @Override
    public Map<String, String> loginUser(LoginRequestDTO requestDTO) {

        Users users = usersRepository.findByEmail(requestDTO.getEmail()).orElseThrow(
                () -> new ResourcesNotFoundException("User not found with this email id :" +
                        " " + requestDTO.getEmail()));

        if (!passwordEncoder.matches(requestDTO.getPassword(), users.getPassword())){
            throw new ResourcesNotFoundException("Invalid Password ");
        }

        Map<String , String> response = new HashMap<>();

        String accessToken = jwtService.accessToken(users.getEmail(), users.getRole());
        String refreshToken = jwtService.refreshToken(users.getEmail(), users.getRole());


        response.put("accessToken" , accessToken);
        response.put("refreshToken", refreshToken);
        response.put("role", users.getRole());
        response.put("userName", users.getUserName());

        return response;



    }
}

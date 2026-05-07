package com.mecaps.blogApp.security;

import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.exception.ResourcesNotFoundException;
import com.mecaps.blogApp.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UsersRepository usersRepository;


    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Users users = usersRepository.findByUserName(userName).orElseThrow(
                () -> new ResourcesNotFoundException("User Name is not found  : " + userName));


       return User
                .withUsername(users.getUserName())
                .password(users.getPassword())
                .roles(users.getRole())
                .build();
    }
}

package com.mecaps.blogApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class BlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

}


//package com.mecaps.blogApp.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//
//        httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(
//                        auth -> auth
//                                .requestMatchers("/users/getAll", "/users/create").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .userDetailsService(userDetailsService)
//                .httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
//
//    }
//
//}








//package com.mecaps.blogApp.security;
//
//import com.mecaps.blogApp.entity.Users;
//import com.mecaps.blogApp.exception.ResourcesNotFoundException;
//import com.mecaps.blogApp.repository.UsersRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UsersRepository usersRepository;
//
//    public CustomUserDetailsService(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users users = usersRepository.findByUserName(username).orElseThrow(
//                () -> new ResourcesNotFoundException("User Name is not valid : " + username));
//
//        return User
//                .withUsername(users.getUserName())
//                .password(users.getPassword())
//                .roles(users.getRole())
//                .build();
//    }
//}

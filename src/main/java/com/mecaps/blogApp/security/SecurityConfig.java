package com.mecaps.blogApp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/users/getAll", "/users/create",
                                                "/actuator/health",
                                                "/actuator/env",
                                                "/actuator/mapping",
                                                "/actuator/info",
                                                "/actuator/beans",
                                                "/actuator/metrics",
                                                "/actuator/loggers",
                                                "/actuator/threaddump",
                                                "/auth/login").permitAll()

                                .anyRequest().authenticated()

                )
//                .httpBasic(Customizer.withDefaults());
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }


}






/*
REQUEST FLOW BOTH CASES(PUBLIC / PROTECTED)

if API is Public.

1. Client Request
2. Tomcat receives request
3. SecurityFilterChain intercepts
4. permitAll()
5. DispatcherServlet
6. Controller


if API is Protected.

1. Client Request
2. Tomcat receives request
3. SecurityFilterChain intercepts
4. Authorization check
5. BasicAuthenticationFilter runs
6. loadUserByUsername()
7. DB query executes
8. Password check
9. SecurityContext created
10. DispatcherServlet called
11. Controller executes
12. Response returned

 */



    /*

    TASK

    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String author;
        private String category;
        private Double price;
        private Boolean available;
        private LocalDate publishedDate;
    }
    APIs
    1. Add Book
    2. Get All Book
    3. Update Book
    4. Delete Book By id
    5. Get Book By id

    6. Issue Book
    Logic ->  If the book is Available then issue otherwise throw error

    7. Return Book
    Search APIs
    8. Category wise
    9. Author wise

    Validation:
        @NotBlank
        @NotNull
        @Positive

    Exception Handling
    Custom Exceptions:
        BookNotFoundException
        BookAlreadyIssuedException
     */
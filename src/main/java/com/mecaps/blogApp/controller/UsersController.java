package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.requestDTO.UserRequestDTO;
import com.mecaps.blogApp.responseDTO.UsersResponseDTO;
import com.mecaps.blogApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {


    private UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
       UsersResponseDTO usersResponseDTO =  userService.getById(id);

       return ResponseEntity.ok(usersResponseDTO);
    }


    @GetMapping("/getAll")
    public List<UsersResponseDTO> getAllUsers(){
        return userService.getAll();
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUsers(@RequestBody UserRequestDTO requestDTO){
        UsersResponseDTO users = userService.createUsers(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }


    @PatchMapping("/update/{id}")
    public UsersResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO requestDTO){
        return userService.updateUsers(id,requestDTO);
    }


    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
       return userService.deleteUser(userId);

//        return ResponseEntity.noContent().build();
    }






}

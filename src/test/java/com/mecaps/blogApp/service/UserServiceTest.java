package com.mecaps.blogApp.service;


import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.UsersRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UsersRepository usersRepository;

    @Disabled
    @Test
    public void normalTest(){
//       assertEquals(2,0+1);
        assertNotEquals(2, 1 + 1);
    }




    @ParameterizedTest
    @CsvSource({
            "5,6,11",
            "1,1,2",
            "5,6,12"
    })
    public void parameterizedTest(int a, int b, int expected){
        assertEquals(expected, a+b);
    }

    @Test
    public void checkUserEmailIsExistOrNot() {
        Optional<Users> byEmail = usersRepository.findByEmail("Atif@gmail.com");
        assertEquals("Atif@gmail.com", byEmail.get().getEmail());
    }




}

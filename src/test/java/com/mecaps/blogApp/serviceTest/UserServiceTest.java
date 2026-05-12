package com.mecaps.blogApp.serviceTest;

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
    public void testMethod(){
        assertEquals(4,2+2);
        assertNotNull(4, String.valueOf(2+2));

    }


    @Test
    public void test(){
        assertEquals(4,2+2);
        assertNotNull(4, String.valueOf(2+2));
        assertTrue(5 >  3);

    }

    @Test
    public void testFindByEmailMethod(){
        Optional<Users> byEmail = usersRepository.findByEmail("Atif@gmail.com");
        assertEquals("Atif@gmail.com", byEmail.get().getEmail());

    }
//    @ParameterizedTest
//    @CsvSource({
//            "Atif@gmail.com",
//            "Atif123@gmail.com"
//    })
//    public void testFindByEmailMethod(String email){
//        Optional<Users> byEmail = usersRepository.findByEmail(email);
//        assertEquals(email,  byEmail.get().getEmail());
//    }

    @ParameterizedTest
    @CsvSource({
            "2,2,4",
            "5,6,2",
            "2,8,10",
            "6,6,12"
    })
    public void paraMeterTesting(int a, int b, int excepted){

        assertEquals(excepted, a+b);
    }



}

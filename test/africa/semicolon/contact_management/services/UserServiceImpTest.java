package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImpTest {
    UserService userService;
    @BeforeEach
    void setUp(){
        userService = new UserServiceImp();
    }
    @Test
    void registerTest(){
//        UserService userService = new UserServiceImp();
        RegisterRequest request = new RegisterRequest();
        request.setAddress("22 sabo");
        request.setEmail("amosk@gamil.com");
        request.setFullName("Oneh Amos");
        request.setPhoneNumber("09099009900");
        userService.register(request);

        assertEquals(1, userService.getNumberOfUsers());

    }

    @Test
    void duplicateUserEmailThrowsExceptionTest(){
        RegisterRequest request = new RegisterRequest();
        request.setAddress("22 sabo");
        request.setEmail("amosk@gamil.com");
        request.setFullName("Oneh Monday");
        request.setPhoneNumber("09099009900");
        userService.register(request);
        assertThrows(UserExistsException.class, ()-> userService.register(request));
        assertEquals(1, userService.getNumberOfUsers());
    }
}
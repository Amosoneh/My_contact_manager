package africa.semicolon.contact_management.data.repositories;

import africa.semicolon.contact_management.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImpTest {
    @Test
    void saveUserTest(){
        UserRepository userRepository = new UserRepositoryImp();
        User user = new User();
        user.setName("Oneh Amos");
        user.setPhoneNumber("090990099");
        user.setAddress("22, sabo");
        user.setEmail("amos@gmail.com");

        userRepository.save(user);
        assertEquals(1, userRepository.count());
        assertEquals("Oneh Amos", user.getName());
    }

    @Test
    void deleteUserTest(){
        UserRepository userRepository = new UserRepositoryImp();
        User user = new User();
        User user1 = new User();
        user.setName("Oneh Amos");
        user.setPhoneNumber("090990099");
        user.setAddress("22, sabo");
        user.setEmail("amos@gmail.com");

        user1.setName("One Amo");
        user1.setPhoneNumber("90990099");
        user1.setAddress("2, sabo");
        user1.setEmail("mos@gmail.com");

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.delete(1);
        assertEquals(1, userRepository.count());
    }

    @Test
    void addContactToUserContactListTest(){
        UserRepository userRepository = new UserRepositoryImp();
        User user = new User();
        User user1 = new User();
        user.setName("Oneh Amos");
        user.setPhoneNumber("090990099");
        user.setAddress("22, sabo");
        user.setEmail("amos@gmail.com");

        userRepository.save(user);

    }

}
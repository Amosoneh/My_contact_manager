package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.data.repositories.ContactRepository;
import africa.semicolon.contact_management.data.repositories.ContactRepositoryImp;
import africa.semicolon.contact_management.data.repositories.UserRepository;
import africa.semicolon.contact_management.data.repositories.UserRepositoryImp;
import africa.semicolon.contact_management.dtos.requests.AddContactRequest;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImpTest {
    private UserService userService;
    private ContactService contactService;
    private ContactRepository contactRepository;
    @BeforeEach
    void setUp(){
        UserRepository userRepository = new UserRepositoryImp();
        contactService = new ContactServiceImp();
        contactRepository = new ContactRepositoryImp();
        userService = new UserServiceImp(userRepository, contactService);
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

        assertEquals(1, userService.size());

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
        assertEquals(1, userService.size());
    }

    @Test
    void addContactTest(){
        RegisterRequest request = new RegisterRequest();
        request.setAddress("22 sabo");
        request.setEmail("amosk@gamil.com");
        request.setFullName("Oneh Monday");
        request.setPhoneNumber("09099009900");
        userService.register(request);

        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Amos");
        addContactRequest.setUserEmail(request.getEmail());
        addContactRequest.setAddress("22 sabo");
        addContactRequest.setLastName("Oneh");
        addContactRequest.setEmail("diego@gmail.com");
        addContactRequest.setPhone("909900990");
        userService.addContact(addContactRequest);

        assertEquals(1, userService.findContactsBelongingTo("amosk@gamil.com").size());
    }
    @Test
    void addNewContactToRepo(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Amos");
        addContactRequest.setAddress("22 sabo");
        addContactRequest.setLastName("Oneh");
        addContactRequest.setEmail("diego@gmail.com");
        addContactRequest.setPhone("909900990");
        Contact contact = new Contact();
        contact.setFirstName(addContactRequest.getFirstName());
        contact.setEmail(addContactRequest.getEmail());
        contact.setLastName(addContactRequest.getLastName());
        contact.setPhoneNumber(addContactRequest.getPhone());
        var savedContact = contactService.addNewContact(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactService.size());
    }
}
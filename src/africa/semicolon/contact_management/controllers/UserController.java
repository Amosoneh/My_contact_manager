package africa.semicolon.contact_management.controllers;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.dtos.requests.AddContactRequest;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.AddContactResponse;
import africa.semicolon.contact_management.dtos.response.RegisterResponse;
import africa.semicolon.contact_management.services.UserService;
import africa.semicolon.contact_management.services.UserServiceImp;

import java.util.List;

public class UserController {
    private UserService userService = new UserServiceImp();
    public RegisterResponse registerUser(RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

    public AddContactResponse addContact(AddContactRequest addContactRequest){
        return userService.addContact(addContactRequest);
    }

    public List<Contact> FindContactBelongingTp(String email){
        return userService.findContactsBelongingTo(email);
    }


}

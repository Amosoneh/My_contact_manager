package africa.semicolon.contact_management.controllers;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.dtos.requests.AddContactRequest;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.AddContactResponse;
import africa.semicolon.contact_management.dtos.response.AllContactResponse;
import africa.semicolon.contact_management.dtos.response.RegisterResponse;
import africa.semicolon.contact_management.exceptions.UserExistsException;
import africa.semicolon.contact_management.services.UserService;
import africa.semicolon.contact_management.services.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    private UserService userService = new UserServiceImp();
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        try {
            RegisterResponse serviceResponse = userService.register(registerRequest);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        }
        catch (UserExistsException error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest addContactRequest){
        return userService.addContact(addContactRequest);
    }

    @GetMapping("/user/{email}")
    public List<AllContactResponse> FindContactBelongingTp(@PathVariable String email){
        return userService.findContactsBelongingTo(email);
    }


}

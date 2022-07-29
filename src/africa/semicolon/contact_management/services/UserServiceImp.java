package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.data.models.User;
import africa.semicolon.contact_management.data.repositories.ContactRepository;
import africa.semicolon.contact_management.data.repositories.ContactRepositoryImp;
import africa.semicolon.contact_management.data.repositories.UserRepository;
import africa.semicolon.contact_management.data.repositories.UserRepositoryImp;
import africa.semicolon.contact_management.dtos.requests.AddContactRequest;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.AddContactResponse;
import africa.semicolon.contact_management.dtos.response.RegisterResponse;
import africa.semicolon.contact_management.exceptions.UserExistsException;
import africa.semicolon.contact_management.utils.Mapper;

import java.util.List;

public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final ContactService contactService;

    public UserServiceImp(UserRepository userRepository, ContactService contactService){
        this.userRepository = userRepository;
        this.contactService = contactService;
    }
     public UserServiceImp(){
        this.userRepository = new UserRepositoryImp();
        ContactRepository c = new ContactRepositoryImp();
        this.contactService = new ContactServiceImp();
     }
    @Override
    public RegisterResponse register(RegisterRequest request) {
        isExist(request.getEmail());
        User user = new User();
        Mapper.map(request, user);
        userRepository.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setMessage("Registration Successful");
        return response;
    }

    private void isExist(String email) {
        User savedUser = userRepository.findByEmail(email);
        if (savedUser != null) throw new UserExistsException(email + "Already exist");
    }

    @Override
    public AddContactResponse addContact(AddContactRequest request) {
        // create a new contact
        // save it to repository
        // find user by email
        // add contact to user contact list
        // save user
        Contact contact = new Contact();
        Mapper.map(request, contact);

        Contact savedContact = contactService.addNewContact(contact);

        User user = userRepository.findByEmail(request.getUserEmail());

        user.getContacts().add(savedContact);

        userRepository.save(user);


        return null;
    }

    @Override
    public int size() {
        return userRepository.count();
    }

    @Override
    public List<Contact> findContactsBelongingTo(String userEmail) {
        User user  = userRepository.findByEmail(userEmail);
        return user.getContacts();
    }
}

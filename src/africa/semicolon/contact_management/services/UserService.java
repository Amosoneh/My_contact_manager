package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.dtos.requests.AddContactRequest;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.AddContactResponse;
import africa.semicolon.contact_management.dtos.response.RegisterResponse;

import java.util.List;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    AddContactResponse addContact(AddContactRequest request);

    int size();

    public List<Contact> findContactsBelongingTo(String userEmail);
}

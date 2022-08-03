package africa.semicolon.contact_management.utils;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.data.models.User;
import africa.semicolon.contact_management.dtos.requests.AddContactRequest;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.AllContactResponse;


public class Mapper {
    public static void map(RegisterRequest request, User user){
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        user.setPassword(request.getPassword());
    }

    public static void map(AddContactRequest request, Contact contact){
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhoneNumber(request.getPhone());
        contact.setFirstName(request.getFirstName());
    }

    public static void map(Contact contact, AllContactResponse singleResponse) {
        singleResponse.setId(contact.getId()+ "");
        singleResponse.setFirstName(contact.getFirstName());
        singleResponse.setLastName(contact.getLastName());
    }
}

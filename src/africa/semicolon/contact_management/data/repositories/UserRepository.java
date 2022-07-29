package africa.semicolon.contact_management.data.repositories;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.data.models.User;

public interface UserRepository {
    User save(User user);
    void delete(User user);
    void delete(int id);

    int count();

    User findByEmail(String email);
//    Contact addContact(Contact contact);
//    void deleteContact(Contact contact);
//    void deleteContact(int id);
//    Contact findContactBy(int id);
}

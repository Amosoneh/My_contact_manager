package africa.semicolon.contact_management.data.repositories;

import africa.semicolon.contact_management.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);
    void delete(Contact contact);
    void delete(int id);
    Contact findBy(int id);
//    List<Contact> findByFirstName(String firstName);
//    List<Contact> findByLastName(String lastName);
    List<Contact> findAll();
    int count();
}

package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.data.models.Contact;

public interface ContactService {
    Contact addNewContact(Contact contact);
    int size();
}

package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.data.repositories.ContactRepository;
import africa.semicolon.contact_management.data.repositories.ContactRepositoryImp;

public class ContactServiceImp implements ContactService{
    ContactRepository contactRepository = new ContactRepositoryImp();
    @Override
    public Contact addNewContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public int size(){
        return contactRepository.count();
    }

}

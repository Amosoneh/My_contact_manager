package africa.semicolon.contact_management.data.repositories;

import africa.semicolon.contact_management.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImp implements ContactRepository{
    private int counter;
    private List<Contact> contacts = new ArrayList<>();
    UserRepository user;
    @Override
    public Contact save(Contact contact) {
        for (var myContact: contacts){
            if (myContact.getId()== contact.getId()){
                return myContact;
            }
        }
        contact.setId(counter);
        contacts.add(contact);
        counter++;
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.removeIf(myContact -> myContact == contact);
//        for (Contact contact1: contacts){
//            if (contact1.equals(contact)){
//                contacts.remove(contact1);
//                break;
//            }
//        }

    }

    @Override
    public void delete(int id) {
        contacts.removeIf(contact -> contact.getId() == id);
//        Contact foundContact = findBy(id);
//        contacts.remove(foundContact);

    }

    @Override
    public Contact findBy(int id) {
        for (var contact: contacts){
            if (contact.getId() == id){
                return contact;
            }
        }

        return null;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public int count() {
        return contacts.size();
    }


}

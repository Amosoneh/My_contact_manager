package africa.semicolon.contact_management.data.repositories;

import africa.semicolon.contact_management.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImpTest {

    @Test
    void saveContact_countIncreaseBy1Test(){
        ContactRepository contactRepository = new ContactRepositoryImp();
        Contact contact = new Contact();
        contact.setLastName("Oneh");
        contact.setFirstName("Amos");
        contact.setEmail("amos@gmail.com");
        contact.setPhoneNumber("090998899");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }

    @Test
    void saveContact_findByIdTest(){
        ContactRepository contactRepository = new ContactRepositoryImp();
        Contact contact = new Contact();
        contact.setLastName("Oneh");
        contact.setFirstName("Amos");
        contact.setEmail("amos@gmail.com");
        contact.setPhoneNumber("090998899");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
        Contact savedContact = contactRepository.findBy(1);
        assertEquals("Amos", savedContact.getFirstName());
    }

    @Test
    void saveContact_deleteTest(){
        ContactRepository contactRepository = new ContactRepositoryImp();
        Contact contact = new Contact();
        contact.setLastName("Oneh");
        contact.setFirstName("Amos");
        contact.setEmail("amos@gmail.com");
        contact.setPhoneNumber("090998899");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
        contactRepository.delete(contact);
        assertEquals(0, contactRepository.count());
    }

    @Test
    void saveContact_deleteByIdTest(){
        ContactRepository contactRepository = new ContactRepositoryImp();
        Contact contact = new Contact();
        contact.setLastName("Oneh");
        contact.setFirstName("Amos");
        contact.setEmail("amos@gmail.com");
        contact.setPhoneNumber("090998899");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
        contactRepository.delete(1);
        assertEquals(0, contactRepository.count());
    }

    @Test
    void saveContact_updateTest(){
        ContactRepository contactRepository = new ContactRepositoryImp();
        Contact contact = new Contact();
        Contact contact2 = new Contact();
        contact.setLastName("Oneh");
        contact.setFirstName("Amos");
        contact.setEmail("amos@gmail.com");
        contact.setPhoneNumber("090998899");

        contact2.setFirstName("Monday");
        contact2.setLastName("Diego");
        contact2.setPhoneNumber("0909090");
        contact2.setEmail("diego@gmail.com");
        contactRepository.save(contact);
        contactRepository.save(contact2);

        Contact savedContact = contactRepository.findBy(1);
        assertEquals("Amos", savedContact.getFirstName());

        contact.setFirstName("Sam");
        contact.setLastName("go");
        contact.setPhoneNumber("909090");
        contact.setEmail("sam@gmail.com");

        contactRepository.save(contact);
        Contact updatedContact = contactRepository.findBy(1);
        assertEquals("Sam", updatedContact.getFirstName());


        assertEquals(2, contactRepository.count());
        System.out.println(contactRepository.findAll());
    }
}
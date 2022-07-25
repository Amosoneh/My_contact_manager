package africa.semicolon.contact_management.data.repositories;

import africa.semicolon.contact_management.data.models.Contact;
import africa.semicolon.contact_management.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImp implements UserRepository{
    private List<User> userLists = new ArrayList<>();
    private int counter;

    @Override
    public User save(User user) {
        for (User myUser: userLists){
            if (myUser.getId() == user.getId()){
                return user;
            }
        }
        counter++;
        user.setId(counter);
        userLists.add(user);
        return user;
    }

    @Override
    public void delete(User user) {
        for (User myUser: userLists){
            if (myUser == user){
                userLists.remove(myUser);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        userLists.removeIf(user -> user.getId() == id);
    }

    @Override
    public int count() {
        return userLists.size();
    }

    @Override
    public User findByEmail(String email) {
        for (User user: userLists){
            if (user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }

//    @Override
//    public Contact addContact(Contact contact) {
//        User user = new User();
//       for (Contact contact1: user.getContacts()){
//           if (contact1.getId()== contact.getId()){
//               return contact1;
//           }
//       }
//       counter++;
//       contact.setId(counter);
//       user.getContacts().add(contact);
//       return contact;
//
//    }
//
//    @Override
//    public void deleteContact(Contact contact) {
//
//    }
//
//    @Override
//    public void deleteContact(int id) {
//
//    }
//
//    @Override
//    public Contact findContactBy(int id) {
//        return null;
//    }
}

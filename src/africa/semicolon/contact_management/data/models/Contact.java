package africa.semicolon.contact_management.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private  String email;

    @Override
    public String toString() {
        return "Contact:" +
                "\nId: " + id +
                "\nFirstName: " + firstName +
                "\nLastName: " + lastName +
                "\nPhoneNumber: " + phoneNumber +
                "\nEmail: " + email ;


    }
}

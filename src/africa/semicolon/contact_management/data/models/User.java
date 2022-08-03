package africa.semicolon.contact_management.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Contact> contacts = new ArrayList<>();


}

package africa.semicolon.contact_management.dtos.requests;

import lombok.Data;

@Data
public class AddContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String userEmail;

}

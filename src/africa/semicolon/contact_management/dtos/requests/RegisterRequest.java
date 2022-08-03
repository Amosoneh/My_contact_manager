package africa.semicolon.contact_management.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String password;
    private String email;

}

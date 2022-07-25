package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    int getNumberOfUsers();
}

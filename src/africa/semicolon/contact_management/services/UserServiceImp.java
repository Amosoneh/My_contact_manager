package africa.semicolon.contact_management.services;

import africa.semicolon.contact_management.data.models.User;
import africa.semicolon.contact_management.data.repositories.UserRepository;
import africa.semicolon.contact_management.data.repositories.UserRepositoryImp;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;
import africa.semicolon.contact_management.dtos.response.RegisterResponse;
import africa.semicolon.contact_management.exceptions.UserExistsException;

public class UserServiceImp implements UserService{
    private UserRepository userRepository = new UserRepositoryImp();
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User savedUser = userRepository.findByEmail(request.getEmail());
        if (savedUser != null) throw new UserExistsException(request.getEmail() + "Already exist");
        User user = new User();
        user.setName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        userRepository.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setMessage("Registration Successful");
        return response;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }
}

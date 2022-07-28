package africa.semicolon.contact_management.utils;

import africa.semicolon.contact_management.data.models.User;
import africa.semicolon.contact_management.dtos.requests.RegisterRequest;


public class Mapper {
    public static void map(RegisterRequest request, User user){
        user.setName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
    }
}

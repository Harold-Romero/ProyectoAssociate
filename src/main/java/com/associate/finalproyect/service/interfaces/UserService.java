package com.associate.finalproyect.service.interfaces;

import com.associate.finalproyect.dto.UserRequest;
import com.associate.finalproyect.entity.User;

import java.util.List;

public interface UserService {

    User createUser (UserRequest request);
    User updateUser (UserRequest request);
    User getUserByIdentification(String identification);
    List<User> getAllUsers();
    String deleteUser(String identification);
}

package com.associate.finalproyect.service.interfaces;

import com.associate.finalproyect.dto.UserRequest;
import com.associate.finalproyect.entity.User;

import java.util.List;

/**
 * Development by Harol Romero
 * This interface is the methods firm for the users service.
 */
public interface UserService {

    User createUser (UserRequest request);
    User updateUser (UserRequest request);
    User getUserByIdentification(String identification);
    List<User> getAllUsers();
    String deleteUser(String identification);
}

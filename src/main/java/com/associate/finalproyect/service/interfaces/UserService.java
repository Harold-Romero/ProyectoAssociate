package com.associate.finalproyect.service.interfaces;

import com.associate.finalproyect.dto.UserRequest;
import com.associate.finalproyect.entity.User;

public interface UserService {

    User createUser (UserRequest request);
}

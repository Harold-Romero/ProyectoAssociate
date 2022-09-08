package com.associate.finalproyect.service;

import com.associate.finalproyect.dto.UserRequest;
import com.associate.finalproyect.entity.User;
import com.associate.finalproyect.repository.UserRepository;
import com.associate.finalproyect.service.interfaces.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(UserRequest request) {

        Optional<User> userIdentification = repository.findByIdentificationNumber(request.getIdentificationNumber());
        Optional<User> userEmail = repository.findByEmail(request.getEmail());

        if (userIdentification.isEmpty() && )

        User user = new User();
        user.setIdentificationType(request.getIdentificationType());
        user.setIdentificationNumber(request.getIdentificationNumber());
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        return repository.save(user);
    }

    @Override
    public User updateUser(UserRequest request) {
        return null;
    }

    @Override
    public User getUserByIdentification(String identification) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(String identification) {

    }
}

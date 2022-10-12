package com.associate.finalproyect.service;

import com.associate.finalproyect.dto.UserRequest;
import com.associate.finalproyect.entity.User;
import com.associate.finalproyect.exception.listexceptions.ConflictException;
import com.associate.finalproyect.exception.listexceptions.FieldInvalidException;
import com.associate.finalproyect.exception.listexceptions.NotFoundException;
import com.associate.finalproyect.repository.UserRepository;
import com.associate.finalproyect.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final String USERCONFLICT = "El número de identificación o el email ingresado ya pertenecen a otro usuario";
    private final String USERNOTFOUND = "El número de identificación no se encuentra registrado en base de datos";
    private final String FIELDINVALID = "Debe contener un tipo de documento para la creación de usuarios";
    private final String USERDELETED = "Usuario eliminado con éxito";

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(UserRequest request) {

        Optional<User> userIdentification = repository.findByIdentificationNumber(request.getIdentificationNumber());
        Optional<User> userEmail = repository.findByEmail(request.getEmail());

        if ((userIdentification.isEmpty() || !userIdentification.get().isStatus()) && userEmail.isEmpty() ||
                (userIdentification.isEmpty() || !userIdentification.get().isStatus()) && !userEmail.get().isStatus()){
            User user = new User();
            if (request.getIdentificationType() == null){
                throw new FieldInvalidException(FIELDINVALID);
            }
            user.setIdentificationType(request.getIdentificationType());
            user.setIdentificationNumber(request.getIdentificationNumber());
            user.setName(request.getName());
            user.setLastname(request.getLastname());
            user.setAddress(request.getAddress());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setEmail(request.getEmail());
            user.setStatus(true);
            return repository.save(user);
        } else {
            throw new ConflictException(USERCONFLICT);
        }
    }

    @Override
    public User updateUser(UserRequest request) {
        Optional<User> userDb = repository.findByIdentificationNumber(request.getIdentificationNumber());
        Optional<User> userDbEmail = repository.findByEmail(request.getEmail());

        if (userDb.isPresent() && userDb.get().isStatus()){
            if (userDbEmail.isEmpty() || Objects.equals(userDb.get().getId(), userDbEmail.get().getId())){
                User userUpdate = userDb.get();
                userUpdate.setIdentificationType(userDb.get().getIdentificationType());
                userUpdate.setIdentificationNumber(userDb.get().getIdentificationNumber());
                userUpdate.setName(request.getName());
                userUpdate.setLastname(request.getLastname());
                userUpdate.setPhoneNumber(request.getPhoneNumber());
                userUpdate.setEmail(request.getEmail());
                userUpdate.setAddress(request.getAddress());
                userUpdate.setStatus(true);

                return repository.save(userUpdate);
            }else {
                throw new ConflictException(USERCONFLICT);
            }
        }else {
            throw new NotFoundException(USERNOTFOUND);
        }
    }

    @Override
    public User getUserByIdentification(String identification) {
        Optional<User> userDb = repository.findByIdentificationNumber(identification);

        if (userDb.isPresent()){
            return userDb.get();
        }else {
            throw new NotFoundException(USERNOTFOUND);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public String deleteUser(String identification) {
        Optional<User> userDb = repository.findByIdentificationNumber(identification);

        if (userDb.isPresent() && userDb.get().isStatus()){
            User userDelete = userDb.get();
            userDelete.setStatus(false);
            repository.save(userDelete);
            return USERDELETED;
        }else {
            throw new NotFoundException(USERNOTFOUND);
        }
    }
}
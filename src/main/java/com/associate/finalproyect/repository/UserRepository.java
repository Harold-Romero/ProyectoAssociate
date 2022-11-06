package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Development by Harol Romero
 * This class implements the interface that, through the functions, executes SQL statements for users registers.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdentificationNumber(String identification);
    Optional<User> findByEmail(String email);
}

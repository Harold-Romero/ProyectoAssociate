package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

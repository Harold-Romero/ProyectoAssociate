package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Development by Harol Romero
 * This class implements the interface that, through the functions, executes SQL statements for identification type registers.
 */
public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {
}

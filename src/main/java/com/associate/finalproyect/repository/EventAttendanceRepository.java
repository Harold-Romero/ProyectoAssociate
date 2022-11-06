package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.EventAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Development by Harol Romero
 * This class implements the interface that, through the functions, executes SQL statements for assistance register.
 */
public interface EventAttendanceRepository extends JpaRepository<EventAttendance, Long> {
    Optional<List<EventAttendance>> findByEvent_Id(Long id);
}

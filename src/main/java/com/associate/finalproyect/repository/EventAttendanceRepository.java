package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.EventAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventAttendanceRepository extends JpaRepository<EventAttendance, Long> {
    Optional<List<EventAttendance>> findByEvent_Id(Long id);
}

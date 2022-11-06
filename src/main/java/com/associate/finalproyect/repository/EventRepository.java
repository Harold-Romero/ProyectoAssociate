package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Development by Harol Romero
 * This class implements the interface that, through the functions, executes SQL statements for events registers.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}

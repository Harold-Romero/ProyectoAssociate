package com.associate.finalproyect.repository;

import com.associate.finalproyect.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

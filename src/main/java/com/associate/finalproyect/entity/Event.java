package com.associate.finalproyect.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Development by Harol Romero
 * This class implements the model that persist in database for the event table
 */
@Entity
@Table(name = "tbl_event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long id;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_description")
    private String eventDescription;
}

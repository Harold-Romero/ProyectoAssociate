package com.associate.finalproyect.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_event_attendance")
@Data
public class EventAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "attendee")
    private User user;
    @Column(name = "comment_event")
    private String commentEvent;
    private byte qualification;
}

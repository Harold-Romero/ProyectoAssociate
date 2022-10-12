package com.associate.finalproyect.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "identification_type")
    private IdentificationType identificationType;
    @Column(name = "identification_number")
    private String identificationNumber;
    private String name;
    private String lastname;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private boolean status;
}

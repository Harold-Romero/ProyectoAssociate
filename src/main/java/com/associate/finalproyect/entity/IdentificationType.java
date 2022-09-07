package com.associate.finalproyect.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "identification_type")
@Data
public class IdentificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identification_type")
    private Long id;
    @Column(name = "name_idty")
    private String nameIdTy;
}

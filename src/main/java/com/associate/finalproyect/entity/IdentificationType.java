package com.associate.finalproyect.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Development by Harol Romero
 * This class implements the model that persist in database for the identification type table
 */
@Entity
@Table(name = "tbl_identification_type")
@Data
public class IdentificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identification_type")
    private Long id;
    @Column(name = "name_idty")
    private String nameIdTy;
}

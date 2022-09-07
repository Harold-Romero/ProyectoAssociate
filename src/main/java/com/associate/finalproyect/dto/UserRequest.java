package com.associate.finalproyect.dto;

import com.associate.finalproyect.entity.IdentificationType;
import com.sun.istack.NotNull;

public class UserRequest {

    @NotNull
    
    private IdentificationType identificationType;
    private String identificationNumber;
    private String name;
    private String lastname;
    private String address;
    private String phoneNumber;
    private String email;
}

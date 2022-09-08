package com.associate.finalproyect.dto;

import com.associate.finalproyect.entity.IdentificationType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
public class UserRequest {

    private IdentificationType identificationType;
    @NotEmpty(message = "user.entity.nuId.empty")
    @Size(min = 6, max = 30, message = "user.entity.nuId.length")
    @Pattern(regexp = "[0-9]+", message = "user.entity.nuId.pattern")
    private String identificationNumber;
    @NotEmpty(message = "user.entity.firstname.empty")
    @Size(min = 3, max = 20, message = "user.entity.firstname.length")
    @Pattern(regexp = "[a-zA-Z0-9À-ÿ\\s]+", message = "user.entity.firstname.pattern")
    private String name;
    @NotEmpty(message = "user.entity.lastname.empty")
    @Size(min = 3, max = 20, message = "user.entity.lastname.length")
    @Pattern(regexp = "[a-zA-Z0-9À-ÿ\\s]+", message = "user.entity.lastname.pattern")
    private String lastname;
    @NotEmpty(message = "user.entity.address.empty")
    @Size(min = 3, max = 20, message = "user.entity.address.length")
    private String address;
    @NotEmpty(message = "user.entity.telephone.empty")
    @Size(min = 7, max = 15, message = "user.entity.telephone.length")
    @Pattern(regexp = "[0-9]+", message = "user.entity.telephone.pattern")
    private String phoneNumber;
    @NotEmpty(message = "user.entity.email.empty")
    @Size(min = 6, max = 50, message = "user.entity.email.length")
    @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "user.entity.email.pattern")
    private String email;
}
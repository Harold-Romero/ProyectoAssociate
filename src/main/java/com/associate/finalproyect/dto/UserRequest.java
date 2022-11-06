package com.associate.finalproyect.dto;

import com.associate.finalproyect.entity.IdentificationType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Development by Harol Romero
 * This class implements the model for receiving data from users and restricts the data that is received
 */
@Data
public class UserRequest {

    private IdentificationType identificationType;
    @NotEmpty(message = "El numero de identificacion del usuario no puede estar vacio")
    @Size(min = 6, max = 30, message = "El numero de identificacion del usuario debe contener entre 6 y 30 caracteres")
    @Pattern(regexp = "[0-9]+", message = "El numero de identificacion del usuario no puede contener caracteres especiales")
    private String identificationNumber;
    @NotEmpty(message = "El nombre del usuario no puede estar vacio")
    @Size(min = 3, max = 20, message = "El nombre del usuario debe contener entre 6 y 20 caractere")
    @Pattern(regexp = "[a-zA-Z0-9À-ÿ\\s]+", message = "El nombre del usuario no puede contener caracteres especiales")
    private String name;
    @NotEmpty(message = "El apellido del usuario no puede estar vacío")
    @Size(min = 3, max = 20, message = "El apellido del usuario debe contener entre 3 y 20 caracteres")
    @Pattern(regexp = "[a-zA-Z0-9À-ÿ\\s]+", message = "El apellido del usuario no puede contener caracteres especiales")
    private String lastname;
    @NotEmpty(message = "La dirección del usuario no puede estar vacía")
    @Size(min = 3, max = 20, message = "La dirección del usuario debe contener entre 6 y 50 caracteres")
    private String address;
    @NotEmpty(message = "El numero de telefono del usuario no puede estar vacio")
    @Size(min = 7, max = 15, message = "El numero de telefono del usuario debe contener entre 7 y 15 caracteres")
    @Pattern(regexp = "[0-9]+", message = "El numero de telefono del usuario solo puede contener numeros")
    private String phoneNumber;
    @NotEmpty(message = "El correo electronico del usuario no puede estar vacio")
    @Size(min = 6, max = 50, message = "El correo electronico del usuario debe contener entre 6 y 50 caracteres")
    @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "El correo no contiene la estructura correcta. Ejemplo (ejemplo@email.com)")
    private String email;
}
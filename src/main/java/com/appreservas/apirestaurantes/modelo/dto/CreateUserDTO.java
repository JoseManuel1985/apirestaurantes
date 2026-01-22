package com.appreservas.apirestaurantes.modelo.dto;

import jakarta.validation.constraints.*;

/**
 * DTO (Data Transfer Object) para crear nuevos usuarios
 * No incluye el ID ya que será generado automáticamente por la base de datos
 */
public class CreateUserDTO {

    /** Nombre del usuario - obligatorio, entre 2 y 50 caracteres */
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    /** Apellido del usuario */
    @NotNull
    private String lastname;

    /** Teléfono del usuario - debe seguir formato internacional */
    @NotNull
    @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Formato de teléfono inválido")
    private String telephone;

    /** Email del usuario - debe ser válido y único */
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    private String email;

    /**
     * Constructor completo para crear un CreateUserDTO
     */
    public CreateUserDTO(String name, String lastname, String telephone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
    }

    /**
     * Constructor vacío requerido para deserialización JSON
     */
    public CreateUserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}




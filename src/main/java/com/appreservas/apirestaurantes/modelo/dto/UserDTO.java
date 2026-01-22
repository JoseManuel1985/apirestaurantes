package com.appreservas.apirestaurantes.modelo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

/**
 * DTO (Data Transfer Object) para representar usuarios en las respuestas de la API
 * Incluye validaciones para garantizar la integridad de los datos
 */
@Valid
public class UserDTO {

    /** Identificador único del usuario */
    @NotNull
    private Integer id;

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

    /** Lista de IDs de reservas asociadas al usuario */
    private List<Integer> bookings;

    /**
     * Constructor completo para crear un UserDTO con todos los campos
     */
    public UserDTO(Integer id, String name, String lastname, String telephone, String email, List<Integer> bookings) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
        this.bookings = bookings;
    }

    /**
     * Constructor vacío requerido para deserialización JSON
     */
    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Integer> getBookings() {
        return bookings;
    }

    public void setBookings(List<Integer> bookings) {
        this.bookings = bookings;
    }
}



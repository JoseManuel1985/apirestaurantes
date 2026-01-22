package com.appreservas.apirestaurantes.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entidad JPA que representa un usuario en la base de datos
 * Mapea la tabla "users" con sus relaciones
 */
@Entity
@Table(name = "users")
public class UserEntity {

    /** ID autogenerado del usuario (clave primaria) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nombre del usuario - máximo 50 caracteres */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /** Apellido del usuario - máximo 50 caracteres */
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    /** Teléfono de contacto - máximo 15 caracteres */
    @Column(name = "telephone", nullable = false, length = 15)
    private String telephone;

    /** Email único del usuario - máximo 150 caracteres */
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    /**
     * Relación uno a muchos con las reservas del usuario
     * Se carga de forma lazy y se propagan todas las operaciones
     * Se ignora en la serialización JSON para evitar referencias circulares
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookingEntity> bookings;

    /**
     * Constructor vacío requerido por JPA
     */
    public UserEntity() {
    }

    /**
     * Constructor para crear un usuario con sus datos básicos
     */
    public UserEntity(String name, String lastname, String telephone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
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

    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}

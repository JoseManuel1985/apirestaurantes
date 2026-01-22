package com.appreservas.apirestaurantes.modelo.entity;

import com.appreservas.apirestaurantes.modelo.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad JPA que representa una reserva en la base de datos
 * Mapea la tabla "bookings" y sus relaciones con usuarios y restaurantes
 */
@Entity
@Table(name = "bookings")
public class BookingEntity {

    /** ID autogenerado de la reserva (clave primaria) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Relación muchos a uno con el restaurante donde se realiza la reserva */
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    /** Relación muchos a uno con el usuario que realiza la reserva */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    /** Número de personas para la reserva */
    @Column(name = "num_people", nullable = false)
    private int numPeople;

    /** Número de sillas de niño solicitadas (opcional) */
    @Column(name = "num_child_chair", nullable = true)
    private int numChildChair;

    /** Fecha de la reserva */
    @Column(name = "booking_date", nullable = false)
    private LocalDate date;

    /** Hora de la reserva en formato texto */
    @Column(name = "booking_time", nullable = false)
    private String time;

    /** Estado de la reserva (CONFIRMADA o CANCELADA) */
    @Enumerated(EnumType.STRING)
    private BookingStatus status;


    /**
     * Constructor vacío requerido por JPA
     */
    public BookingEntity() {}

    /**
     * Constructor completo para crear una reserva con todos sus datos
     */
    public BookingEntity(RestaurantEntity restaurant, UserEntity user, int numPeople, int numChildChair, LocalDate date, String time, BookingStatus status) {
        this.restaurant = restaurant;
        this.user = user;
        this.numPeople = numPeople;
        this.numChildChair = numChildChair;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public int getNumChildChair() {
        return numChildChair;
    }

    public void setNumChildChair(int numChildChair) {
        this.numChildChair = numChildChair;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}

package com.appreservas.apirestaurantes.modelo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO (Data Transfer Object) para crear nuevas reservas
 * No incluye el ID ni el estado, ya que serán generados automáticamente
 */
public class CreateBookingDTO {

    /** ID del restaurante donde se realiza la reserva */
    @NotNull
    private Integer restaurantId;

    /** ID del usuario que realiza la reserva */
    @NotNull
    private Integer userId;

    /** Número de personas - entre 1 y 20 */
    @Min(1)
    @Max(20)
    private int numPeople;

    /** Número de sillas de niño - entre 0 y 10 */
    @Min(0)
    @Max(10)
    private int numChildChair;

    /** Fecha de la reserva en formato ISO (yyyy-MM-dd) */
    @NotBlank
    private String date;

    /** Hora de la reserva en formato 24h (HH:mm) */
    @NotBlank
    private String time;

    /**
     * Constructor vacío requerido para deserialización JSON
     */
    public CreateBookingDTO() {}

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

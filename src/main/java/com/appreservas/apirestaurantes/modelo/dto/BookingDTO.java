package com.appreservas.apirestaurantes.modelo.dto;

import com.appreservas.apirestaurantes.modelo.BookingStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para representar reservas en las respuestas de la API
 * Incluye validaciones para garantizar que los datos de la reserva sean correctos
 */
@Valid
public class BookingDTO {

    /** Identificador único de la reserva */
    private Integer id;

    /** ID del restaurante donde se realiza la reserva */
    @NotNull private Integer restaurantId;

    /** ID del usuario que realiza la reserva */
    @NotNull private Integer userId;

    /** Número de personas para la reserva - entre 1 y 20 */
    @Min(value = 1, message = "Mínimo 1 persona")
    @Max(value = 20, message = "Máximo 20 personas")
    private int numPeople;

    /** Número de sillas de niño necesarias - entre 0 y 10 */
    @Min(value = 0, message = "No puede ser negativo")
    @Max(value = 10, message = "Máximo 10 sillas de niño")
    private int numChildChair;

    /** Fecha de la reserva - debe ser futura */
    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message =  "La fecha debe ser hoy o futura")
    private LocalDate date;

    /** Hora de la reserva en formato HH:mm */
    @NotBlank(message = "La hora es obligatoria")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido (HH:mm)")
    private String time;

    /** Estado de la reserva (PENDING, CONFIRMED, CANCELLED) */
    private BookingStatus status;

    /**
     * Constructor completo para crear un BookingDTO con todos los campos
     */
    public BookingDTO(Integer id, Integer restaurantId, Integer userId, int numPeople, int numChildChair, LocalDate date, String time, BookingStatus status) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.numPeople = numPeople;
        this.numChildChair = numChildChair;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    /**
     * Constructor vacío requerido para deserialización JSON
     */
    public BookingDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

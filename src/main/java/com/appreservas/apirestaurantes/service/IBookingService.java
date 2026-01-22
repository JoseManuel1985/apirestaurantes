package com.appreservas.apirestaurantes.service;

import com.appreservas.apirestaurantes.modelo.dto.BookingDTO;
import com.appreservas.apirestaurantes.modelo.dto.CreateBookingDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de reservas
 * Define las operaciones de negocio disponibles para reservas
 */
public interface IBookingService {
    /** Obtiene todas las reservas */
    List<BookingDTO> findAll();

    /** Busca reservas por nombre de restaurante */
    List<BookingDTO> findByRestaurantName(String name);

    /** Busca reservas por email de usuario */
    List<BookingDTO> findByUserEmail(String email);

    /** Busca reservas por ID de usuario */
    List<BookingDTO> findByUserid(Integer id);

    /** Crea una nueva reserva */
    BookingDTO createBooking(CreateBookingDTO dto);
}

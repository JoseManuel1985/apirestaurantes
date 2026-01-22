package com.appreservas.apirestaurantes.controller;

import com.appreservas.apirestaurantes.modelo.dto.BookingDTO;
import com.appreservas.apirestaurantes.modelo.dto.CreateBookingDTO;
import com.appreservas.apirestaurantes.service.IBookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de reservas
 * Expone endpoints para operaciones CRUD de reservas
 * Ruta base: /bookings
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final IBookingService bookingService;

    /**
     * Constructor con inyección de dependencias
     *
     * @param bookingService servicio de reservas
     */
    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * GET /bookings
     * Obtiene todas las reservas del sistema
     *
     * @return lista de todas las reservas
     */
    @GetMapping
    public List<BookingDTO> findAllBookings() {
        return bookingService.findAll();
    }

    /**
     * GET /bookings/restaurant/{name}
     * Busca todas las reservas de un restaurante específico
     *
     * @param name nombre del restaurante
     * @return lista de reservas del restaurante
     */
    @GetMapping("/restaurant/{name}")
    public List<BookingDTO> findByRestaurantName(@PathVariable String name) {
        return bookingService.findByRestaurantName(name);
    }

    /**
     * GET /bookings/user/id/{id}
     * Busca todas las reservas de un usuario por su ID
     *
     * @param id identificador del usuario
     * @return lista de reservas del usuario
     */
    @GetMapping("/user/id/{id}")
    public List<BookingDTO> findByUserId(@PathVariable Integer id) {
        return bookingService.findByUserid(id);
    }

    /**
     * GET /bookings/user/email/{email}
     * Busca todas las reservas de un usuario por su email
     *
     * @param email email del usuario
     * @return lista de reservas del usuario
     */
    @GetMapping("/user/email/{email}")
    public List<BookingDTO> findByUserEmail(@PathVariable String email) {
        return bookingService.findByUserEmail(email);
    }

    /**
     * POST /bookings
     * Crea una nueva reserva
     * Los datos se validan automáticamente según las anotaciones del DTO
     *
     * @param bookingDTO datos de la reserva a crear
     * @return reserva creada con su ID generado
     */
    @PostMapping
    public BookingDTO createBooking(@RequestBody @Valid CreateBookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }
}

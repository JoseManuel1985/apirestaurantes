package com.appreservas.apirestaurantes.modelo.dao;

import com.appreservas.apirestaurantes.modelo.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interfaz DAO (Data Access Object) para la gestión de reservas en la base de datos
 * Extiende CrudRepository de Spring Data JPA para operaciones CRUD automáticas
 */
public interface IBookingEntityDao extends CrudRepository<BookingEntity, Integer> {

    /**
     * Busca todas las reservas de un restaurante por su nombre
     *
     * @param name nombre del restaurante
     * @return lista de reservas del restaurante
     */
    List<BookingEntity> findByRestaurant_Name(String name);

    /**
     * Busca todas las reservas de un usuario por su ID
     *
     * @param id identificador del usuario
     * @return lista de reservas del usuario
     */
    List<BookingEntity> findByUserId(Integer id);

    /**
     * Busca todas las reservas de un usuario por su email
     *
     * @param email correo electrónico del usuario
     * @return lista de reservas del usuario
     */
    List<BookingEntity> findByUserEmail(String email);

}

package com.appreservas.apirestaurantes.service;

import com.appreservas.apirestaurantes.modelo.dto.RestaurantDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de restaurantes
 * Define las operaciones de negocio disponibles para restaurantes
 */
public interface IRestaurantService {
    /** Obtiene todos los restaurantes */
    List<RestaurantDTO> findAllRestaurants();

    /** Busca restaurantes por texto en nombre, categoría o descripción */
    List<RestaurantDTO> findByNameOrCategoryOrDescriptionContaining(String search);

}

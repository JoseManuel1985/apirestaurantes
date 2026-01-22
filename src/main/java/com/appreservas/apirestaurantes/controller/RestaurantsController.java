package com.appreservas.apirestaurantes.controller;


import com.appreservas.apirestaurantes.modelo.dto.RestaurantDTO;
import com.appreservas.apirestaurantes.service.IRestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para la gestión de restaurantes
 * Expone endpoints para consultar información de restaurantes
 * Ruta base: /restaurants
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {

    private final IRestaurantService restaurantService;

    /**
     * Constructor con inyección de dependencias
     *
     * @param restaurantService servicio de restaurantes
     */
    public RestaurantsController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * GET /restaurants
     * Obtiene todos los restaurantes disponibles
     *
     * @return lista de todos los restaurantes
     */
    @GetMapping
    public List<RestaurantDTO> findAllRestaurants(){
        return restaurantService.findAllRestaurants();
    }

    /**
     * GET /restaurants/{value}
     * Busca restaurantes por texto en nombre, categoría o descripción
     * La búsqueda no es sensible a mayúsculas/minúsculas
     *
     * @param search texto a buscar
     * @return lista de restaurantes que coinciden con la búsqueda
     */
    @GetMapping("/{value}")
    public List<RestaurantDTO> findByName(@PathVariable(value = "value") String search){
        return restaurantService.findByNameOrCategoryOrDescriptionContaining(search);
    }


}

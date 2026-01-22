package com.appreservas.apirestaurantes.service;

import com.appreservas.apirestaurantes.modelo.dao.IRestaurantEntityDao;
import com.appreservas.apirestaurantes.modelo.dto.RestaurantDTO;
import com.appreservas.apirestaurantes.modelo.entity.RestaurantEntity;
import com.appreservas.apirestaurantes.modelo.mapper.RestaurantMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de gestión de restaurantes
 * Contiene la lógica de negocio para operaciones relacionadas con restaurantes
 */
@Service
public class RestaurantServiceImpl implements IRestaurantService{

    private final IRestaurantEntityDao restaurantEntityDao;

    /**
     * Constructor con inyección de dependencias
     *
     * @param restaurantEntityDao DAO para operaciones de restaurantes
     */
    public RestaurantServiceImpl(IRestaurantEntityDao restaurantEntityDao) {
        this.restaurantEntityDao = restaurantEntityDao;
    }

    /**
     * Obtiene todos los restaurantes del sistema
     *
     * @return lista de restaurantes en formato DTO
     */
    @Override
    public List<RestaurantDTO> findAllRestaurants() {
        return RestaurantMapper.toDTOList((List<RestaurantEntity>) restaurantEntityDao.findAll());
    }

    /**
     * Busca restaurantes por texto en nombre, categoría o descripción
     * La búsqueda no es sensible a mayúsculas/minúsculas
     *
     * @param search texto a buscar
     * @return lista de restaurantes que coinciden con la búsqueda
     */
    @Override
    public List<RestaurantDTO> findByNameOrCategoryOrDescriptionContaining(String search) {
        return RestaurantMapper.toDTOList(restaurantEntityDao.findByNameOrCategoryOrDescriptionContaining(search));
    }


}

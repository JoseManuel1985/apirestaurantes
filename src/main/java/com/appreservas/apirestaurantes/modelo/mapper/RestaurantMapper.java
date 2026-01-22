package com.appreservas.apirestaurantes.modelo.mapper;

import com.appreservas.apirestaurantes.modelo.dto.RestaurantDTO;
import com.appreservas.apirestaurantes.modelo.entity.RestaurantEntity;

import java.util.List;

/**
 * Clase Mapper para convertir entre entidades RestaurantEntity y DTOs de restaurante
 * Facilita la transformación de datos entre las capas de persistencia y presentación
 */
public class RestaurantMapper {

    /**
     * Convierte una entidad RestaurantEntity a un DTO RestaurantDTO
     *
     * @param entity entidad de restaurante a convertir
     * @return DTO del restaurante con todos sus datos
     */
    public static RestaurantDTO toDTO(RestaurantEntity entity) {
        return new RestaurantDTO(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getDescription(),
                entity.getMaxCapacity(),
                entity.getTimeTable(),
                entity.getImage()
        );
    }

    /**
     * Convierte una lista de entidades RestaurantEntity a una lista de DTOs RestaurantDTO
     *
     * @param entities lista de entidades de restaurante
     * @return lista de DTOs de restaurante
     */
    public static List<RestaurantDTO> toDTOList(List<RestaurantEntity> entities) {
        return entities.stream()
                .map(RestaurantMapper::toDTO)
                .toList();
    }
}

package com.appreservas.apirestaurantes.modelo.mapper;

import com.appreservas.apirestaurantes.modelo.dto.BookingDTO;
import com.appreservas.apirestaurantes.modelo.entity.BookingEntity;
import com.appreservas.apirestaurantes.modelo.entity.RestaurantEntity;
import com.appreservas.apirestaurantes.modelo.entity.UserEntity;

import java.util.List;

/**
 * Clase Mapper para convertir entre entidades BookingEntity y DTOs de reserva
 * Facilita la transformación de datos entre las capas de persistencia y presentación
 */
public class BookingMapper {

    /**
     * Convierte una entidad BookingEntity a un DTO BookingDTO
     * Extrae los IDs del restaurante y usuario de sus relaciones
     *
     * @param entity entidad de reserva a convertir
     * @return DTO de la reserva con todos sus datos
     */
    public static BookingDTO toDTO(BookingEntity entity) {
        return new BookingDTO(
                entity.getId(),
                entity.getRestaurant().getId(),
                entity.getUser().getId(),
                entity.getNumPeople(),
                entity.getNumChildChair(),
                entity.getDate(),
                entity.getTime(),
                entity.getStatus()
        );
    }

    /**
     * Convierte un BookingDTO a una entidad BookingEntity
     * Requiere las entidades de restaurante y usuario ya cargadas
     *
     * @param dto DTO con los datos de la reserva
     * @param restaurant entidad del restaurante asociado
     * @param user entidad del usuario que realiza la reserva
     * @return entidad de reserva lista para persistir
     */
    public static BookingEntity toEntity(
            BookingDTO dto,
            RestaurantEntity restaurant,
            UserEntity user
    ) {
        return new BookingEntity(
                restaurant,
                user,
                dto.getNumPeople(),
                dto.getNumChildChair(),
                dto.getDate(),
                dto.getTime(),
                dto.getStatus()
        );
    }

    /**
     * Convierte una lista de entidades BookingEntity a una lista de DTOs BookingDTO
     *
     * @param entities lista de entidades de reserva
     * @return lista de DTOs de reserva
     */
    public static List<BookingDTO> toDTOList(List<BookingEntity> entities) {
        return entities.stream()
                .map(BookingMapper::toDTO)
                .toList();
    }




}

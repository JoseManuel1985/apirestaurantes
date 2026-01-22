package com.appreservas.apirestaurantes.modelo.mapper;

import com.appreservas.apirestaurantes.modelo.dto.CreateUserDTO;
import com.appreservas.apirestaurantes.modelo.dto.UserDTO;
import com.appreservas.apirestaurantes.modelo.entity.BookingEntity;
import com.appreservas.apirestaurantes.modelo.entity.UserEntity;

import java.util.List;

/**
 * Clase Mapper para convertir entre entidades UserEntity y DTOs de usuario
 * Facilita la transformación de datos entre las capas de persistencia y presentación
 */
public class UserMapper {

    /**
     * Convierte una entidad UserEntity a un DTO UserDTO
     * Extrae los IDs de las reservas asociadas al usuario
     *
     * @param entity entidad de usuario a convertir
     * @return DTO del usuario con sus datos y lista de IDs de reservas
     */
    public static UserDTO toDTO(UserEntity entity) {
        List<Integer> bookingIds = entity.getBookings() == null
                ? List.of()
                : entity.getBookings()
                .stream()
                .map(BookingEntity::getId)
                .toList();

        return new UserDTO(
                entity.getId(),
                entity.getName(),
                entity.getLastname(),
                entity.getTelephone(),
                entity.getEmail(),
                bookingIds
        );
    }

    /**
     * Convierte un CreateUserDTO a una entidad UserEntity
     * Usado para crear nuevos usuarios desde los datos de entrada
     *
     * @param dto DTO con los datos para crear el usuario
     * @return entidad de usuario lista para persistir
     */
    public static UserEntity toEntity(CreateUserDTO dto) {
        return new UserEntity(
                dto.getName(),
                dto.getLastname(),
                dto.getTelephone(),
                dto.getEmail()
        );
    }

    /**
     * Convierte una lista de entidades UserEntity a una lista de DTOs UserDTO
     *
     * @param entities lista de entidades de usuario
     * @return lista de DTOs de usuario
     */
    public static List<UserDTO> toDTOList(List<UserEntity> entities) {
        return entities.stream()
                .map(UserMapper::toDTO)
                .toList();
    }



}

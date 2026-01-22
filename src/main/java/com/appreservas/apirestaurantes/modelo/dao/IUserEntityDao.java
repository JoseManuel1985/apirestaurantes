package com.appreservas.apirestaurantes.modelo.dao;

import com.appreservas.apirestaurantes.modelo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interfaz DAO (Data Access Object) para la gestión de usuarios en la base de datos
 * Extiende CrudRepository de Spring Data JPA para operaciones CRUD automáticas
 */
public interface IUserEntityDao extends CrudRepository<UserEntity, Integer> {
    /**
     * Busca un usuario por su dirección de correo electrónico
     *
     * @param email dirección de correo electrónico del usuario
     * @return Optional conteniendo el usuario si existe, vacío si no
     */
    Optional<UserEntity> findByEmail(String email);
}

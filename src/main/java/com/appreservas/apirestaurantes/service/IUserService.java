package com.appreservas.apirestaurantes.service;

import com.appreservas.apirestaurantes.modelo.dto.CreateUserDTO;
import com.appreservas.apirestaurantes.modelo.dto.UserDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de usuarios
 * Define las operaciones de negocio disponibles para usuarios
 */
public interface IUserService {
    /** Obtiene todos los usuarios registrados */
    List<UserDTO> findAll();

    /** Busca un usuario por su email */
    UserDTO findByEmail(String email);

    /** Busca un usuario por su ID */
    UserDTO findById(Integer id);

    /** Crea un nuevo usuario */
    UserDTO createUser(CreateUserDTO dto);
}

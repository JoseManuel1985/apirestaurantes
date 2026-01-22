package com.appreservas.apirestaurantes.controller;

import com.appreservas.apirestaurantes.modelo.dto.CreateUserDTO;
import com.appreservas.apirestaurantes.modelo.dto.UserDTO;
import com.appreservas.apirestaurantes.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de usuarios
 * Expone endpoints para operaciones CRUD de usuarios
 * Ruta base: /users
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    /**
     * Constructor con inyección de dependencias
     *
     * @param userService servicio de usuarios
     */
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * GET /users
     * Obtiene todos los usuarios registrados
     *
     * @return lista de todos los usuarios
     */
    @GetMapping
    public List<UserDTO> findAllUsers(){
       return userService.findAll();
    }

    /**
     * GET /users/{email}
     * Busca un usuario por su email
     *
     * @param email email del usuario a buscar
     * @return usuario encontrado
     */
    @GetMapping("/{email}")
    public UserDTO findByEmail(@PathVariable(value = "email") String email){
        return userService.findByEmail(email);
    }

    /**
     * POST /users
     * Crea un nuevo usuario
     * Los datos se validan automáticamente según las anotaciones del DTO
     *
     * @param createUserDTO datos del usuario a crear
     * @return usuario creado con su ID generado
     */
    @PostMapping
    public UserDTO saveUser(@RequestBody @Valid CreateUserDTO createUserDTO){
        return userService.createUser(createUserDTO);
    }
}
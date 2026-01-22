package com.appreservas.apirestaurantes.service;

import com.appreservas.apirestaurantes.modelo.dao.IBookingEntityDao;
import com.appreservas.apirestaurantes.modelo.dao.IUserEntityDao;
import com.appreservas.apirestaurantes.modelo.dto.CreateUserDTO;
import com.appreservas.apirestaurantes.modelo.dto.UserDTO;
import com.appreservas.apirestaurantes.modelo.entity.UserEntity;
import com.appreservas.apirestaurantes.modelo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de usuarios
 * Contiene la lógica de negocio para operaciones relacionadas con usuarios
 */
@Service
public class UserServiceImpl implements IUserService{

    private final IUserEntityDao userEntityDao;
    private final IBookingEntityDao bookingEntityDao;

    /**
     * Constructor con inyección de dependencias
     *
     * @param userEntityDao DAO para operaciones de usuarios
     * @param bookingEntityDao DAO para operaciones de reservas
     */
    public UserServiceImpl(IUserEntityDao userEntityDao, IBookingEntityDao bookingEntityDao) {
        this.userEntityDao = userEntityDao;
        this.bookingEntityDao = bookingEntityDao;
    }

    /**
     * Obtiene todos los usuarios del sistema
     *
     * @return lista de usuarios en formato DTO
     */
    @Override
    public List<UserDTO> findAll() {
        return UserMapper.toDTOList((List<UserEntity>) userEntityDao.findAll());
    }

    /**
     * Busca un usuario por su email
     *
     * @param email email del usuario a buscar
     * @return DTO del usuario encontrado
     * @throws RuntimeException si no se encuentra el usuario
     */
    @Override
    public UserDTO findByEmail(String email) {
        return userEntityDao.findByEmail(email)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Busca un usuario por su ID
     *
     * @param id identificador del usuario
     * @return DTO del usuario encontrado
     * @throws RuntimeException si no se encuentra el usuario
     */
    @Override
    public UserDTO findById(Integer id) {
        return UserMapper.toDTO(userEntityDao.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    /**
     * Crea un nuevo usuario en el sistema
     * Si el email ya existe, devuelve el usuario existente en lugar de crear uno duplicado
     *
     * @param dto datos del usuario a crear
     * @return DTO del usuario creado o existente
     */
    @Override
    public UserDTO createUser(CreateUserDTO dto) {

        // 1️⃣ Evitar duplicados por email
        Optional<UserEntity> existing = userEntityDao.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            return UserMapper.toDTO(existing.get());
        }

        // 2️⃣ Crear usuario limpio
        UserEntity user = new UserEntity(
                dto.getName(),
                dto.getLastname(),
                dto.getTelephone(),
                dto.getEmail()
        );

        return UserMapper.toDTO(userEntityDao.save(user));
    }


}

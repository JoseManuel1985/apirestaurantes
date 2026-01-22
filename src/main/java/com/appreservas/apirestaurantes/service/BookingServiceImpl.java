package com.appreservas.apirestaurantes.service;

import com.appreservas.apirestaurantes.modelo.BookingStatus;
import com.appreservas.apirestaurantes.modelo.dao.IBookingEntityDao;
import com.appreservas.apirestaurantes.modelo.dao.IRestaurantEntityDao;
import com.appreservas.apirestaurantes.modelo.dao.IUserEntityDao;
import com.appreservas.apirestaurantes.modelo.dto.BookingDTO;
import com.appreservas.apirestaurantes.modelo.dto.CreateBookingDTO;
import com.appreservas.apirestaurantes.modelo.entity.BookingEntity;
import com.appreservas.apirestaurantes.modelo.entity.RestaurantEntity;
import com.appreservas.apirestaurantes.modelo.entity.UserEntity;
import com.appreservas.apirestaurantes.modelo.mapper.BookingMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Implementación del servicio de gestión de reservas
 * Contiene la lógica de negocio para operaciones relacionadas con reservas
 */
@Service
public class BookingServiceImpl implements IBookingService{

    private final IBookingEntityDao bookingEntityDao;
    private final IRestaurantEntityDao restaurantEntityDao;
    private final IUserEntityDao userEntityDao;


    /**
     * Constructor con inyección de dependencias
     *
     * @param bookingEntityDao DAO para operaciones de reservas
     * @param restaurantEntityDao DAO para operaciones de restaurantes
     * @param userEntityDao DAO para operaciones de usuarios
     */
    public BookingServiceImpl(IBookingEntityDao bookingEntityDao, IRestaurantEntityDao restaurantEntityDao, IUserEntityDao userEntityDao) {
        this.bookingEntityDao = bookingEntityDao;
        this.restaurantEntityDao = restaurantEntityDao;
        this.userEntityDao = userEntityDao;
    }

    /**
     * Obtiene todas las reservas del sistema
     *
     * @return lista de reservas en formato DTO
     */
    @Override
    public List<BookingDTO> findAll() {
        return BookingMapper.toDTOList((List<BookingEntity>) bookingEntityDao.findAll());
    }

    /**
     * Busca todas las reservas de un restaurante por su nombre
     *
     * @param name nombre del restaurante
     * @return lista de reservas del restaurante
     */
    @Override
    public List<BookingDTO> findByRestaurantName(String name) {
        return BookingMapper.toDTOList(bookingEntityDao.findByRestaurant_Name(name));
    }

    /**
     * Busca todas las reservas de un usuario por su email
     *
     * @param email email del usuario
     * @return lista de reservas del usuario
     */
    @Override
    public List<BookingDTO> findByUserEmail(String email) {
        return BookingMapper.toDTOList(bookingEntityDao.findByUserEmail(email));
    }

    /**
     * Busca todas las reservas de un usuario por su ID
     *
     * @param id identificador del usuario
     * @return lista de reservas del usuario
     */
    @Override
    public List<BookingDTO> findByUserid(Integer id) {
        return BookingMapper.toDTOList(bookingEntityDao.findByUserId(id));
    }

    /**
     * Crea una nueva reserva en el sistema
     * Valida la existencia del restaurante y usuario antes de crear la reserva
     * La reserva se crea con estado CONFIRMADA por defecto
     *
     * @param dto datos de la reserva a crear
     * @return DTO de la reserva creada
     * @throws RuntimeException si el restaurante o usuario no existen
     */
    @Override
    public BookingDTO createBooking(CreateBookingDTO dto) {

        RestaurantEntity restaurant = restaurantEntityDao.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        UserEntity user = userEntityDao.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        BookingEntity booking = new BookingEntity(
                restaurant,
                user,
                dto.getNumPeople(),
                dto.getNumChildChair(),
                LocalDate.parse(dto.getDate()),
                dto.getTime(),
                BookingStatus.CONFIRMADA
        );

        return BookingMapper.toDTO(bookingEntityDao.save(booking));
    }


}

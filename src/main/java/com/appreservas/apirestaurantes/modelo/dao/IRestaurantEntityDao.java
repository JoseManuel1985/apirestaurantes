package com.appreservas.apirestaurantes.modelo.dao;

import com.appreservas.apirestaurantes.modelo.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interfaz DAO (Data Access Object) para la gestión de restaurantes en la base de datos
 * Extiende CrudRepository de Spring Data JPA para operaciones CRUD automáticas
 */
public interface IRestaurantEntityDao extends CrudRepository<RestaurantEntity, Integer> {

    /**
     * Busca restaurantes que contengan el texto especificado en su nombre, categoría o descripción
     * La búsqueda no es sensible a mayúsculas/minúsculas
     *
     * @param text texto a buscar en nombre, categoría o descripción
     * @return lista de restaurantes que coinciden con la búsqueda
     */
    @Query("""
    SELECT r
    FROM RestaurantEntity r
    WHERE
        LOWER(r.name) LIKE LOWER(CONCAT('%', :text, '%'))
        OR LOWER(r.category) LIKE LOWER(CONCAT('%', :text, '%'))
        OR LOWER(r.description) LIKE LOWER(CONCAT('%', :text, '%'))
""")
    List<RestaurantEntity> findByNameOrCategoryOrDescriptionContaining(@Param("text") String text);


}

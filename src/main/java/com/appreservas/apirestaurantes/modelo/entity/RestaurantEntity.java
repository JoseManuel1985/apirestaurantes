package com.appreservas.apirestaurantes.modelo.entity;

import jakarta.persistence.*;

/**
 * Entidad JPA que representa un restaurante en la base de datos
 * Mapea la tabla "restaurantes" con todos sus atributos
 */
@Entity
@Table(name = "restaurantes")
public class RestaurantEntity {

    /** ID autogenerado del restaurante (clave primaria) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nombre del restaurante */
    @Column(name = "name")
    private String name;

    /** Categoría del restaurante (ej: Italiana, Mexicana, Japonesa) */
    @Column(name="category")
    private String category;

    /** Descripción del restaurante */
    @Column(name="description")
    private String description;

    /** Capacidad máxima del restaurante */
    @Column(name="max_capacity")
    private int maxCapacity;

    /** Horario de apertura del restaurante */
    @Column(name="timetable")
    private String timeTable;

    /** URL de la imagen del restaurante */
    @Column(name="image")
    private String image;

    /**
     * Constructor vacío requerido por JPA
     */
    public RestaurantEntity() {
    }

    /**
     * Constructor completo para crear un restaurante con todos sus datos
     */
    public RestaurantEntity(Integer id, String name, String category, String description, int maxCapacity, String timeTable, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.timeTable = timeTable;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

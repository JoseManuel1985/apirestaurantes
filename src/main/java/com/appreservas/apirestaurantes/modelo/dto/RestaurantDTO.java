package com.appreservas.apirestaurantes.modelo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

/**
 * DTO (Data Transfer Object) para representar restaurantes en las respuestas de la API
 * Incluye validaciones para garantizar la integridad de los datos del restaurante
 */
@Valid
public class RestaurantDTO {

    /** Identificador único del restaurante */
    @NotNull
    private Integer id;

    /** Nombre del restaurante - obligatorio, entre 2 y 100 caracteres */
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    /** Categoría del restaurante (ej: Italiana, Mexicana, Japonesa) */
    @NotBlank(message = "La categoría es obligatoria")
    private String category;

    /** Descripción del restaurante - máximo 500 caracteres */
    @Size(max = 500, message = "Descripción máxima de 500 caracteres")
    private String description;

    /** Capacidad máxima del restaurante - entre 1 y 500 personas */
    @Min(value = 1, message = "Capacidad mínima de 1 persona")
    @Max(value = 500, message = "Capacidad máxima de 500 personas")
    private int maxCapacity;

    /** Horario de apertura del restaurante */
    @NotBlank(message = "Horario obligatorio")
    private String timeTable;

    /** URL de la imagen del restaurante */
    @URL(message = "Formato de URL inválido para la imagen")
    private String image;

    /**
     * Constructor vacío requerido para deserialización JSON
     */
    public RestaurantDTO() {}

    /**
     * Constructor completo para crear un RestaurantDTO con todos los campos
     */
    public RestaurantDTO(Integer id, String name, String category,
                         String description, int maxCapacity,
                         String timeTable, String image) {
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

package com.appreservas.apirestaurantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación API REST de Restaurantes
 *
 * Esta aplicación proporciona una API REST para gestionar reservas de restaurantes,
 * incluyendo usuarios, restaurantes y reservas.
 *
 * Utiliza Spring Boot con las siguientes tecnologías:
 * - Spring Data JPA para persistencia de datos
 * - Spring Security para seguridad (configurada para permitir todas las peticiones)
 * - Spring Validation para validación de datos
 * - MySQL como base de datos
 *
 * @author Proyecto Intermodular
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class ApirestaurantesApplication {

	/**
	 * Método principal que arranca la aplicación Spring Boot
	 *
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApirestaurantesApplication.class, args);
	}

}

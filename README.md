# API REST de Gestión de Restaurantes y Reservas

## 📋 Descripción

Esta es una API REST desarrollada con Spring Boot para gestionar un sistema de reservas de restaurantes. Permite administrar usuarios, restaurantes y reservas de forma eficiente mediante endpoints RESTful.

## 🚀 Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 4.0.1**
- **Spring Data JPA** - Persistencia de datos
- **Spring Security** - Seguridad (configurada para permitir todas las peticiones)
- **Spring Validation** - Validación de datos
- **MySQL 8** - Base de datos
- **Maven** - Gestión de dependencias

## 📁 Estructura del Proyecto

```
apirestaurantes/
├── src/
│   ├── main/
│   │   ├── java/com/appreservas/apirestaurantes/
│   │   │   ├── config/              # Configuraciones de Spring
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/          # Controladores REST
│   │   │   │   ├── BookingController.java
│   │   │   │   ├── RestaurantsController.java
│   │   │   │   └── UserController.java
│   │   │   ├── modelo/
│   │   │   │   ├── dao/             # Interfaces DAO (Repositorios)
│   │   │   │   │   ├── IBookingEntityDao.java
│   │   │   │   │   ├── IRestaurantEntityDao.java
│   │   │   │   │   └── IUserEntityDao.java
│   │   │   │   ├── dto/             # Data Transfer Objects
│   │   │   │   │   ├── BookingDTO.java
│   │   │   │   │   ├── CreateBookingDTO.java
│   │   │   │   │   ├── CreateUserDTO.java
│   │   │   │   │   ├── RestaurantDTO.java
│   │   │   │   │   └── UserDTO.java
│   │   │   │   ├── entity/          # Entidades JPA
│   │   │   │   │   ├── BookingEntity.java
│   │   │   │   │   ├── RestaurantEntity.java
│   │   │   │   │   └── UserEntity.java
│   │   │   │   ├── mapper/          # Conversores Entity-DTO
│   │   │   │   │   ├── BookingMapper.java
│   │   │   │   │   ├── RestaurantMapper.java
│   │   │   │   │   └── UserMapper.java
│   │   │   │   └── BookingStatus.java  # Enum de estados
│   │   │   ├── service/             # Lógica de negocio
│   │   │   │   ├── IBookingService.java
│   │   │   │   ├── BookingServiceImpl.java
│   │   │   │   ├── IRestaurantService.java
│   │   │   │   ├── RestaurantServiceImpl.java
│   │   │   │   ├── IUserService.java
│   │   │   │   └── UserServiceImpl.java
│   │   │   └── ApirestaurantesApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/images/       # Imágenes de restaurantes
│   └── test/
└── pom.xml
```

## 🔧 Configuración e Instalación

### Requisitos Previos

- Java 21 o superior
- MySQL 8.x
- Maven 3.6+
- Un IDE (IntelliJ IDEA, Eclipse, VS Code)

### Paso 1: Clonar el repositorio

```bash
git clone <url-del-repositorio>
cd apirestaurantes
```

### Paso 2: Configurar la Base de Datos

1. Crear la base de datos en MySQL:

```sql
CREATE DATABASE appreservas;
```

2. Configurar las credenciales en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/appreservas
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### Paso 3: Compilar y Ejecutar

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 📊 Modelo de Datos

### Entidades Principales

1. **UserEntity** - Representa a los usuarios del sistema
   - `id`: Integer (PK, Auto-generado)
   - `name`: String (50 caracteres)
   - `lastname`: String (50 caracteres)
   - `telephone`: String (15 caracteres)
   - `email`: String (150 caracteres, único)
   - `bookings`: Relación One-to-Many con BookingEntity

2. **RestaurantEntity** - Representa los restaurantes
   - `id`: Integer (PK, Auto-generado)
   - `name`: String
   - `category`: String (Italiana, Mexicana, Japonesa, etc.)
   - `description`: String
   - `maxCapacity`: Integer
   - `timeTable`: String (horario)
   - `image`: String (URL de la imagen)

3. **BookingEntity** - Representa las reservas
   - `id`: Integer (PK, Auto-generado)
   - `restaurant`: Relación Many-to-One con RestaurantEntity
   - `user`: Relación Many-to-One con UserEntity
   - `numPeople`: Integer (1-20)
   - `numChildChair`: Integer (0-10)
   - `date`: LocalDate
   - `time`: String (formato HH:mm)
   - `status`: BookingStatus (CONFIRMADA, CANCELADA)

## 🔌 API Endpoints

### 👤 Usuarios (`/users`)

#### Obtener todos los usuarios
```http
GET /users
```

**Respuesta exitosa (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Juan",
    "lastname": "Pérez",
    "telephone": "+34600123456",
    "email": "juan@example.com",
    "bookings": [1, 2, 3]
  }
]
```

#### Obtener usuario por email
```http
GET /users/{email}
```

**Ejemplo:**
```http
GET /users/juan@example.com
```

**Respuesta exitosa (200 OK):**
```json
{
  "id": 1,
  "name": "Juan",
  "lastname": "Pérez",
  "telephone": "+34600123456",
  "email": "juan@example.com",
  "bookings": [1, 2]
}
```

#### Crear un nuevo usuario
```http
POST /users
Content-Type: application/json
```

**Cuerpo de la petición:**
```json
{
  "name": "María",
  "lastname": "García",
  "telephone": "+34600987654",
  "email": "maria@example.com"
}
```

**Validaciones:**
- `name`: obligatorio, 2-50 caracteres
- `lastname`: obligatorio
- `telephone`: obligatorio, formato internacional (+?[0-9]{9,15})
- `email`: obligatorio, formato válido de email

**Respuesta exitosa (200 OK):**
```json
{
  "id": 2,
  "name": "María",
  "lastname": "García",
  "telephone": "+34600987654",
  "email": "maria@example.com",
  "bookings": []
}
```

---

### 🍽️ Restaurantes (`/restaurants`)

#### Obtener todos los restaurantes
```http
GET /restaurants
```

**Respuesta exitosa (200 OK):**
```json
[
  {
    "id": 1,
    "name": "La Brasa",
    "category": "Española",
    "description": "Restaurante especializado en carnes a la brasa",
    "maxCapacity": 50,
    "timeTable": "12:00-16:00, 20:00-00:00",
    "image": "/images/thumb_la_brasa.png"
  }
]
```

#### Buscar restaurantes por texto
```http
GET /restaurants/{search}
```

Busca en nombre, categoría y descripción (no sensible a mayúsculas).

**Ejemplo:**
```http
GET /restaurants/italiana
```

**Respuesta exitosa (200 OK):**
```json
[
  {
    "id": 5,
    "name": "Tratoria Roma",
    "category": "Italiana",
    "description": "Auténtica cocina italiana",
    "maxCapacity": 40,
    "timeTable": "13:00-16:00, 20:00-23:00",
    "image": "/images/thumb_tratoria_roma.png"
  }
]
```

---

### 📅 Reservas (`/bookings`)

#### Obtener todas las reservas
```http
GET /bookings
```

**Respuesta exitosa (200 OK):**
```json
[
  {
    "id": 1,
    "restaurantId": 1,
    "userId": 1,
    "numPeople": 4,
    "numChildChair": 1,
    "date": "2026-02-15",
    "time": "20:30",
    "status": "CONFIRMADA"
  }
]
```

#### Obtener reservas por nombre de restaurante
```http
GET /bookings/restaurant/{name}
```

**Ejemplo:**
```http
GET /bookings/restaurant/La%20Brasa
```

#### Obtener reservas por ID de usuario
```http
GET /bookings/user/id/{id}
```

**Ejemplo:**
```http
GET /bookings/user/id/1
```

#### Obtener reservas por email de usuario
```http
GET /bookings/user/email/{email}
```

**Ejemplo:**
```http
GET /bookings/user/email/juan@example.com
```

#### Crear una nueva reserva
```http
POST /bookings
Content-Type: application/json
```

**Cuerpo de la petición:**
```json
{
  "restaurantId": 1,
  "userId": 1,
  "numPeople": 4,
  "numChildChair": 1,
  "date": "2026-02-15",
  "time": "20:30"
}
```

**Validaciones:**
- `restaurantId`: obligatorio, debe existir
- `userId`: obligatorio, debe existir
- `numPeople`: obligatorio, entre 1 y 20
- `numChildChair`: obligatorio, entre 0 y 10
- `date`: obligatorio, formato yyyy-MM-dd
- `time`: obligatorio, formato HH:mm

**Respuesta exitosa (200 OK):**
```json
{
  "id": 10,
  "restaurantId": 1,
  "userId": 1,
  "numPeople": 4,
  "numChildChair": 1,
  "date": "2026-02-15",
  "time": "20:30",
  "status": "CONFIRMADA"
}
```

## 🧪 Ejemplos de Uso con cURL

### Crear un usuario
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Pedro",
    "lastname": "López",
    "telephone": "+34611222333",
    "email": "pedro@example.com"
  }'
```

### Obtener todos los restaurantes
```bash
curl http://localhost:8080/restaurants
```

### Buscar restaurantes
```bash
curl http://localhost:8080/restaurants/italiana
```

### Crear una reserva
```bash
curl -X POST http://localhost:8080/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "restaurantId": 1,
    "userId": 1,
    "numPeople": 2,
    "numChildChair": 0,
    "date": "2026-03-20",
    "time": "21:00"
  }'
```

### Obtener reservas de un usuario
```bash
curl http://localhost:8080/bookings/user/email/pedro@example.com
```

## 🔐 Seguridad

Actualmente, la aplicación tiene Spring Security configurado para **permitir todas las peticiones** sin autenticación. Esto es útil para desarrollo, pero en producción se recomienda implementar:

- Autenticación JWT
- Control de acceso basado en roles
- Protección HTTPS
- Rate limiting

## ⚠️ Manejo de Errores

La API devuelve los siguientes códigos de estado HTTP:

- **200 OK** - Petición exitosa
- **400 Bad Request** - Datos de entrada inválidos
- **404 Not Found** - Recurso no encontrado
- **500 Internal Server Error** - Error del servidor

## 📝 Notas Adicionales

### Estados de Reserva

Las reservas pueden tener dos estados:
- `CONFIRMADA`: Reserva activa
- `CANCELADA`: Reserva cancelada

### Validación de Datos

Todos los endpoints POST validan automáticamente los datos de entrada usando Bean Validation (Jakarta Validation). Los errores de validación se devuelven con código 400 y un mensaje descriptivo.

### Prevención de Duplicados

El sistema previene la creación de usuarios duplicados por email. Si se intenta crear un usuario con un email existente, se devuelve el usuario existente.

## 🛠️ Desarrollo

### Compilar el proyecto
```bash
mvn clean compile
```

### Ejecutar tests
```bash
mvn test
```

### Empaquetar como JAR
```bash
mvn clean package
```

El JAR se generará en `target/apirestaurantes-0.0.1-SNAPSHOT.jar`

### Ejecutar el JAR
```bash
java -jar target/apirestaurantes-0.0.1-SNAPSHOT.jar
```

## 📚 Arquitectura

La aplicación sigue el patrón **MVC (Model-View-Controller)** con arquitectura en capas:

1. **Capa de Presentación** (Controllers): Maneja las peticiones HTTP
2. **Capa de Negocio** (Services): Contiene la lógica de negocio
3. **Capa de Persistencia** (DAOs): Acceso a la base de datos
4. **Capa de Datos** (Entities): Modelo de datos JPA

Los **DTOs** (Data Transfer Objects) se utilizan para transferir datos entre capas, y los **Mappers** convierten entre Entities y DTOs.

## 👥 Autor

Jose Manuel Perez Abellan

## 📄 Licencia

Este proyecto es de código abierto para fines educativos.

---

**¡Gracias por usar nuestra API! 🎉**

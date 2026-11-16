# 🛠️ Sistema de Gestión de Ferretería (API REST + Frontend)

API REST desarrollada con **Java y Spring Boot** para administrar el inventario de herramientas y productos de una ferretería. El proyecto implementa operaciones CRUD completas, persistencia en base de datos relacional **MySQL** mediante **Spring Data JPA**, y una interfaz gráfica web integrada con **Thymeleaf**.

> *Proyecto realizado como ejercicio práctico / prueba técnica Junior.*

---

## 🚀 Características principales

* **Gestión completa (CRUD) de herramientas:**
    * Registrar nuevas herramientas o productos.
    * Listar todo el inventario disponible.
    * Consultar el detalle de una herramienta específica por su ID.
    * Actualizar la información o el stock de un producto existente.
    * Eliminar herramientas del sistema.
* **Arquitectura en capas:** Separación clara entre controladores, servicios, repositorios y modelos.
* **Interfaz Web (Extra):** Vistas dinámicas con Thymeleaf para interactuar con el catálogo mediante formularios intuitivos.

---

## 📋 Modelo de Datos (`Herramienta`)

Cada producto registrado en la tabla de MySQL cuenta con los siguientes atributos:

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | Identificador único autogenerado (`AUTO_INCREMENT`) |
| `nombre` | `String` | Nombre de la herramienta o producto |
| `marca` | `String` | Fabricante o marca |
| `categoria` | `String` | Categoría (ej. Eléctricas, Manuales, Construcción) |
| `precio` | `Double` | Precio unitario del producto |
| `stock` | `Integer` | Cantidad disponible en inventario |
| `descripcion` | `String` | Detalles o especificaciones adicionales |

---

## 🛠️ Tecnologías utilizadas

* **Lenguaje:** Java 17 *(o la versión que hayas utilizado)*
* **Framework:** Spring Boot 3
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL 8
* **Motor de Plantillas (Frontend):** Thymeleaf
* **Gestor de Dependencias:** Maven

---

## 🔗 Endpoints principales de la API REST

*(Ajusta las rutas si usaste nombres distintos en tu `@RequestMapping`)*

| Método HTTP | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/herramientas` | Obtener todas las herramientas |
| `GET` | `/api/herramientas/{id}` | Consultar una herramienta por ID |
| `POST` | `/api/herramientas` | Registrar una nueva herramienta |
| `PUT` | `/api/herramientas/{id}` | Modificar una herramienta existente |
| `DELETE` | `/api/herramientas/{id}` | Eliminar una herramienta |

---

## ⚙️ Instalación y ejecución local

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com
   cd TU-REPOSITORIO
   ```

2. **Crea la base de datos en MySQL:**
   Abre tu cliente de MySQL (Workbench, DBeaver o terminal) y ejecuta:
   ```sql
   CREATE DATABASE ferreteria_db;
   ```

3. **Configura la conexión:**
   Abre el archivo `src/main/resources/application.properties` y coloca tus credenciales de MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ferreteria_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Ejecuta la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Accede al sistema:**
    * **Interfaz Web (Thymeleaf):** `http://localhost:8080/herramientas`
    * **API REST:** `http://localhost:8080/api/herramientas`

---

## 👤 Autor

* **Tu Nombre** - [Tu perfil de GitHub](https://github.com)

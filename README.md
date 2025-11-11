# 🔐 Spring Security CRUD - Sistema de Gestión de Cursos

Aplicación web desarrollada con **Spring Boot 3** y **Spring Security** que implementa un sistema completo de autenticación, autorización y CRUD de cursos con control de acceso basado en roles.

---

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Usuarios de Prueba](#-usuarios-de-prueba)
- [Funcionalidades](#-funcionalidades)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [API Endpoints](#-api-endpoints)
- [Seguridad](#-seguridad)
- [Troubleshooting](#-troubleshooting)
- [Autor](#-autor)

---

## ✨ Características

- ✅ Autenticación de usuarios con Spring Security
- ✅ Autorización basada en roles (USER y ADMIN)
- ✅ CRUD completo de cursos
- ✅ Control de acceso granular a funcionalidades
- ✅ Interfaz responsive con Bootstrap 5
- ✅ Validación de formularios
- ✅ Mensajes flash de éxito/error
- ✅ Página de error 403 personalizada
- ✅ Encriptación de contraseñas con BCrypt
- ✅ Persistencia con JPA/Hibernate
- ✅ Base de datos MySQL

---

## 🛠 Tecnologías Utilizadas

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Security 6.x**
- **Spring Data JPA**
- **Hibernate 6.x**
- **MySQL 8.x**
- **Lombok**
- **Validation API**

### Frontend
- **Thymeleaf**
- **Bootstrap 5.3.0**
- **Font Awesome 6.4.0**
- **HTML5 / CSS3**
- **JavaScript**

---

## 📦 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- ☕ **JDK 17** o superior
- 🗄️ **MySQL 8.0** o superior
- 🔨 **Maven 3.6+**
- 💻 **IDE** (Eclipse, IntelliJ IDEA, VS Code)
- 🌐 **Navegador web** moderno

---

## 🚀 Instalación y Configuración

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/spring-security-crud.git
cd spring-security-crud
```

### 2️⃣ Crear la base de datos

```sql
CREATE DATABASE bd_spring_security;
```

### 3️⃣ Configurar application.properties

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bd_spring_security
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 4️⃣ Compilar el proyecto

```bash
mvn clean install
```

### 5️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

O desde tu IDE, ejecuta la clase `SpringSecurityCrudApplication.java`

### 6️⃣ Acceder a la aplicación

Abre tu navegador y visita:
```
http://localhost:8086
```

---

## 📁 Estructura del Proyecto

```
spring-security-crud/
├── src/
│   ├── main/
│   │   ├── java/com/coello/springsecuritycrud/
│   │   │   ├── auth/
│   │   │   │   └── LoginSuccessHandler.java          # Manejador login exitoso
│   │   │   ├── config/
│   │   │   │   ├── MvcConfig.java                    # Configuración MVC
│   │   │   │   └── SpringSecurityConfig.java         # Configuración seguridad
│   │   │   ├── controllers/
│   │   │   │   └── CursoController.java              # Controlador de cursos
│   │   │   ├── entities/
│   │   │   │   ├── Curso.java                        # Entidad Curso
│   │   │   │   ├── Rol.java                          # Entidad Rol
│   │   │   │   └── Usuario.java                      # Entidad Usuario
│   │   │   ├── persistence/
│   │   │   │   ├── ICursoDao.java                    # Repositorio Curso
│   │   │   │   ├── IRolDao.java                      # Repositorio Rol
│   │   │   │   └── IUsuarioDao.java                  # Repositorio Usuario
│   │   │   ├── services/
│   │   │   │   ├── CursoServiceImpl.java             # Implementación servicio
│   │   │   │   ├── ICursoService.java                # Interface servicio
│   │   │   │   └── JpaUserDetailsService.java        # Servicio autenticación
│   │   │   └── SpringSecurityCrudApplication.java    # Clase principal
│   │   └── resources/
│   │       ├── static/
│   │       │   └── css/
│   │       │       └── style.css                     # Estilos personalizados
│   │       ├── templates/
│   │       │   ├── layout/
│   │       │   │   └── layout.html                   # Layout base
│   │       │   ├── error_403.html                    # Página error 403
│   │       │   ├── form.html                         # Formulario curso
│   │       │   ├── listar.html                       # Lista de cursos
│   │       │   └── login.html                        # Página login
│   │       └── application.properties                # Configuración
│   └── test/
├── pom.xml
└── README.md
```

---

## 👥 Usuarios de Prueba

La aplicación incluye dos usuarios preconfigurados:

| Usuario | Contraseña | Roles | Permisos |
|---------|------------|-------|----------|
| `user` | `12345` | ROLE_USER | Solo lectura (Ver cursos) |
| `admin` | `12345` | ROLE_USER, ROLE_ADMIN | Lectura y escritura completa |

---

## 🎯 Funcionalidades

### Para todos los usuarios autenticados:
- 👁️ Ver lista de cursos
- 🔍 Búsqueda de cursos
- 🚪 Cerrar sesión

### Solo para ADMIN:
- ➕ Crear nuevos cursos
- ✏️ Editar cursos existentes
- 🗑️ Eliminar cursos

---

## 📸 Capturas de Pantalla

### Página de Login
![Login](docs/images/login.png)

### Lista de Cursos (Vista Usuario)
![Lista Usuario](docs/images/lista-user.png)

### Lista de Cursos (Vista Admin)
![Lista Admin](docs/images/lista-admin.png)

### Formulario de Curso
![Formulario](docs/images/form.png)

### Error 403 - Acceso Denegado
![Error 403](docs/images/error-403.png)

---

## 🔗 API Endpoints

### Públicos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/login` | Página de login |

### Requiere autenticación (USER o ADMIN)
| Método | Endpoint | Descripción | Rol Requerido |
|--------|----------|-------------|---------------|
| GET | `/` | Redirección a listar | USER, ADMIN |
| GET | `/listar` | Lista de cursos | USER, ADMIN |

### Solo ADMIN
| Método | Endpoint | Descripción | Rol Requerido |
|--------|----------|-------------|---------------|
| GET | `/form` | Formulario nuevo curso | ADMIN |
| GET | `/form/{id}` | Formulario editar curso | ADMIN |
| POST | `/form` | Guardar curso | ADMIN |
| GET | `/eliminar/{id}` | Eliminar curso | ADMIN |

### Errores
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/error_403` | Página acceso denegado |

---

## 🔒 Seguridad

### Características de Seguridad Implementadas:

1. **Autenticación**
    - Basada en base de datos
    - Usuarios y contraseñas persistidos en MySQL
    - Contraseñas encriptadas con BCrypt

2. **Autorización**
    - Control de acceso basado en roles
    - Anotaciones `@Secured` en controladores
    - Restricciones en plantillas Thymeleaf

3. **Protección CSRF**
    - Habilitada por defecto
    - Tokens CSRF en formularios

4. **Sesiones**
    - Gestión automática de sesiones
    - Logout seguro

### Configuración de Seguridad

```java
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig {
    // Configuración de seguridad
}
```

---

## 🐛 Troubleshooting

### Error: "detached entity passed to persist: Rol"

**Solución:** Asegúrate de que la entidad `Usuario` no tenga `cascade = CascadeType.ALL` en la relación con `Rol`:

```java
@ManyToMany(fetch = FetchType.EAGER)  // Sin cascade
@JoinTable(...)
private List<Rol> roles;
```

### Error: "Access Denied" después de login

**Solución:** Verifica que el usuario tenga los roles correctos asignados en la base de datos.

### Error: Connection refused to MySQL

**Solución:**
1. Verifica que MySQL esté corriendo
2. Confirma las credenciales en `application.properties`
3. Asegúrate de que la base de datos exista

### Los estilos CSS no se cargan

**Solución:** Verifica que la carpeta `static/css` esté correctamente ubicada y que Spring Security permita el acceso:

```java
.requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
```

---

## 📝 Modelo de Datos

### Diagrama ER

```
┌─────────────┐         ┌──────────────────┐         ┌─────────────┐
│   Usuario   │         │ usuarios_roles   │         │     Rol     │
├─────────────┤         ├──────────────────┤         ├─────────────┤
│ id (PK)     │────────<│ usuario_id (FK)  │>────────│ id (PK)     │
│ username    │         │ rol_id (FK)      │         │ authority   │
│ password    │         └──────────────────┘         └─────────────┘
│ enabled     │
└─────────────┘

┌─────────────┐
│    Curso    │
├─────────────┤
│ id (PK)     │
│ nombre      │
│ creditos    │
└─────────────┘
```

---

## 🔄 Flujo de Autenticación

```
1. Usuario accede a la aplicación
2. Spring Security intercepta la petición
3. Redirige a /login si no está autenticado
4. Usuario ingresa credenciales
5. JpaUserDetailsService valida contra BD
6. Si es correcto: genera sesión + redirige a /listar
7. Si es incorrecto: muestra mensaje de error
8. En cada petición verifica roles y permisos
```

---

## 🧪 Testing

### Ejecutar tests

```bash
mvn test
```

### Tests incluidos
- ✅ Test de repositorios
- ✅ Test de servicios
- ✅ Test de seguridad (autenticación/autorización)

---



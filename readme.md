# 🎮 Tienda de Videojuegos - Proyecto Java con Swing y JPA

Este proyecto es una aplicación de escritorio construida en Java utilizando Swing para la interfaz gráfica y JPA (EclipseLink) para el acceso a base de datos. El sistema permite gestionar una tienda de videojuegos en la que los usuarios pueden registrarse, visualizar juegos disponibles y adquirirlos para su biblioteca personal.

## 📌 Características principales
- Gestión de usuarios (registro con imagen y datos de contacto).
- Visualización de juegos con imágenes, género y plataforma.
- Compra de juegos (evita compras duplicadas).
- Biblioteca personal para cada usuario.
- Imágenes por defecto si el juego no tiene asignada una.
- Copias de seguridad manuales en formato CSV.

## 📁 Estructura del proyecto

/imagenes
│
├── /logos → Imágenes por defecto según plataforma
│
└── /juegos → Imágenes personalizadas de los juegos

/dao → Clases DAO (acceso a base de datos)
/modelos → Entidades JPA
/util → Utilidades (conexión JPA, backups)
/vistas → Interfaces gráficas con Swing


## 💾 Backups (copias de seguridad)

El sistema permite la creación de backups en formato CSV para todas las tablas principales (usuarios, juegos, biblioteca, etc.).

Cada backup se guarda en una carpeta con el nombre del día y la hora de la ejecución.

**Importante:** El programa no utiliza los CSV como fuente principal de datos. Desde la primera ejecución, la aplicación se conecta directamente a la base de datos configurada con EclipseLink.

Actualmente, la restauración desde CSV no se realiza de forma automática, aunque existe funcionalidad para implementarlo manualmente.

## 🛠️ Requisitos

- JDK 17 o superior
- JPA con EclipseLink
- Base de datos H2, MySQL o PostgreSQL (según configuración en persistence.xml)
- IDE recomendado: NetBeans, IntelliJ IDEA o Eclipse

## 🚀 Instrucciones de ejecución

1. Clona o descarga este repositorio.
2. Configura la conexión a la base de datos en `persistence.xml`.
3. Ejecuta la clase principal (`Main.java` o similar).
4. La base de datos se crea automáticamente si no existe.
5. Puedes crear usuarios, comprar juegos y hacer backups desde la interfaz gráfica.

## ✅ Estado del proyecto

✔ Funcionalidad principal completada  
✔ Interfaz responsive con Swing  
✔ Gestión de imágenes personalizada  
🛠 Restauración automática desde backups pendiente


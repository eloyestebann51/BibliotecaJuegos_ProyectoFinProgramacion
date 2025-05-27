CREATE DATABASE IF NOT EXISTS bibliotecaJuegos;
USE bibliotecaJuegos;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    imagen_perfil VARCHAR(255)
);

-- Tabla de juegos
CREATE TABLE juegos (
    id_juego INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    plataforma VARCHAR(20) NOT NULL, -- CAMBIADO de ENUM a VARCHAR
    imagen_juego VARCHAR(255)
);

-- Tabla de biblioteca
CREATE TABLE biblioteca (
    id_biblioteca INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_juego INT NOT NULL,
    fecha_adquisicion DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_juego) REFERENCES juegos(id_juego) ON DELETE CASCADE
);

-- Tabla de detalles de usuario
CREATE TABLE usuario_detalle (
    id_usuario INT PRIMARY KEY,
    fecha_nacimiento DATE,
    pais VARCHAR(50),
    plataforma_favorita VARCHAR(20), -- CAMBIADO de ENUM a VARCHAR
    descripcion TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

-- Insertar juegos
INSERT INTO juegos (titulo, genero, plataforma, imagen_juego) VALUES
-- PS
('God of War Ragnarok', 'Acción', 'PS', 'imagenes/juegos/gow.jpg'),
('Spider-Man: Miles Morales', 'Acción', 'PS', 'imagenes/juegos/spiderman.jpg'),
('Uncharted 4: A Thief’s End', 'Aventura', 'PS', 'imagenes/juegos/uncharted.jpg'),
('Ratchet & Clank: Rift Apart', 'Acción', 'PS', NULL),
('The Last of Us Part II', 'Drama', 'PS', 'imagenes/juegos/tlou2.jpg'),
('FIFA 24', 'Deporte', 'PS', NULL),
('Horizon Forbidden West', 'Mundo Abierto', 'PS', 'imagenes/juegos/horizon.jpg'),
('Gran Turismo 7', 'Simulación', 'PS', 'imagenes/juegos/gt7.jpg'),
('Returnal', 'Roguelike', 'PS', NULL),
('Ghost of Tsushima', 'Aventura', 'PS', 'imagenes/juegos/ghost.jpg'),
-- NINTENDO
('The Legend of Zelda: Breath of the Wild', 'Aventura', 'NINTENDO', 'imagenes/juegos/zelda.jpg'),
('Mario Kart 8 Deluxe', 'Carreras', 'NINTENDO', NULL),
('Super Smash Bros. Ultimate', 'Lucha', 'NINTENDO', 'imagenes/juegos/smash.jpg'),
('Metroid Dread', 'Acción', 'NINTENDO', NULL),
('Pokemon Scarlet', 'RPG', 'NINTENDO', 'imagenes/juegos/pokemon.jpg'),
('Animal Crossing: New Horizons', 'Simulación', 'NINTENDO', 'imagenes/juegos/animal.jpg'),
('Luigi’s Mansion 3', 'Aventura', 'NINTENDO', NULL),
('Super Mario Odyssey', 'Plataformas', 'NINTENDO', 'imagenes/juegos/odyssey.jpg'),
('Fire Emblem: Three Houses', 'Estrategia', 'NINTENDO', NULL),
('Bayonetta 3', 'Acción', 'NINTENDO', 'imagenes/juegos/bayonetta.jpg'),
-- XBOX
('Halo Infinite', 'FPS', 'XBOX', NULL),
('Forza Horizon 5', 'Carreras', 'XBOX', 'imagenes/juegos/forza.jpg'),
('Gears 5', 'Acción', 'XBOX', 'imagenes/juegos/gears5.jpg'),
('Call of Duty: Modern Warfare III', 'FPS', 'XBOX', 'imagenes/juegos/cod.jpg'),
('Sea of Thieves', 'Aventura', 'XBOX', 'imagenes/juegos/sea.jpg'),
('Microsoft Flight Simulator', 'Simulación', 'XBOX', NULL),
('Elden Ring', 'RPG', 'XBOX', 'imagenes/juegos/eldenring.jpg'),
('Starfield', 'RPG', 'XBOX', 'imagenes/juegos/starfield.jpg'),
('Hi-Fi Rush', 'Ritmo', 'XBOX', NULL),
('Ori and the Will of the Wisps', 'Plataformas', 'XBOX', 'imagenes/juegos/ori.jpg');

-- Insertar usuarios
INSERT INTO usuarios (nombre, email, imagen_perfil) VALUES
('Carlos Romero', 'carlos.romero@example.com', 'imagenes/usuarios/carlos.png'),
('Lucía Fernández', 'lucia.fernandez@example.com', 'imagenes/usuarios/lucia.jpg'),
('David Ruiz', 'david.ruiz@example.com', NULL),
('Ana Torres', 'ana.torres@example.com', 'imagenes/usuarios/ana.png'),
('Miguel López', 'miguel.lopez@example.com', NULL),
('Sofía Méndez', 'sofia.mendez@example.com', 'imagenes/usuarios/sofia.jpg'),
('Javier Martín', 'javier.martin@example.com', 'imagenes/usuarios/javier.jpg'),
('Laura Gómez', 'laura.gomez@example.com', NULL),
('Diego Herrera', 'diego.herrera@example.com', 'imagenes/usuarios/diego.png'),
('Natalia Silva', 'natalia.silva@example.com', NULL);

-- Insertar usuario_detalle
INSERT INTO usuario_detalle (id_usuario, fecha_nacimiento, pais, plataforma_favorita, descripcion) VALUES
(1, '1995-08-20', 'España', 'PS', 'Amante de los juegos de aventura'),
(2, '2000-01-05', 'México', 'NINTENDO', 'Fan de Mario y Zelda'),
(4, '1992-03-14', 'Argentina', 'PS', 'Me encantan los exclusivos de PlayStation'),
(5, '1988-11-11', 'Chile', 'XBOX', 'Jugador competitivo de FPS'),
(6, '1999-06-22', 'Colombia', 'NINTENDO', 'Disfruto los juegos con mi familia'),
(7, '1996-09-09', 'Perú', 'XBOX', 'Fan de Halo desde pequeño'),
(8, '2001-04-30', 'Uruguay', 'PS', 'Fanática de los juegos narrativos'),
(10, '1993-12-01', 'Ecuador', 'NINTENDO', 'Me encanta la nostalgia de Nintendo');

-- Insertar biblioteca
INSERT INTO biblioteca (id_usuario, id_juego, fecha_adquisicion) VALUES
-- Carlos Romero
(1, 1, '2024-01-10'), (1, 4, '2024-01-15'), (1, 10, '2024-01-20'), (1, 14, '2024-01-25'),
-- Lucía Fernández
(2, 11, '2024-02-01'), (2, 12, '2024-02-05'), (2, 13, '2024-02-08'), (2, 18, '2024-02-10'),
-- David Ruiz
(3, 5, '2024-03-01'), (3, 9, '2024-03-05'),
-- Ana Torres
(4, 2, '2024-01-10'), (4, 7, '2024-01-14'), (4, 27, '2024-02-01'),
-- Miguel López
(5, 3, '2024-02-20'), (5, 15, '2024-02-23'), (5, 22, '2024-03-01'), (5, 26, '2024-03-04'),
-- Sofía Méndez
(6, 12, '2024-01-15'), (6, 16, '2024-01-18'), (6, 19, '2024-01-21'),
-- Javier Martín
(7, 6, '2024-03-10'), (7, 20, '2024-03-15'), (7, 25, '2024-03-18'),
-- Laura Gómez
(8, 8, '2024-04-01'), (8, 14, '2024-04-03'), (8, 24, '2024-04-05'),
-- Diego Herrera
(9, 1, '2024-02-10'), (9, 7, '2024-02-13'), (9, 17, '2024-02-15'),
-- Natalia Silva
(10, 13, '2024-01-10'), (10, 21, '2024-01-13'), (10, 28, '2024-01-15');
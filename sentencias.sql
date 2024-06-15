DROP DATABASE IF EXISTS inventario;
CREATE DATABASE inventario;
USE inventario;

CREATE TABLE departamento(
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE ciudades(
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    cod_departamento INT UNSIGNED,
    FOREIGN KEY (cod_departamento) REFERENCES departamento(codigo)
);

CREATE TABLE oficina(
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    cod_ciudad INT UNSIGNED,
    gerente VARCHAR(50),
    FOREIGN KEY (cod_ciudad) REFERENCES ciudades(codigo)
);

CREATE TABLE producto(
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100)
);

CREATE TABLE inventario(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cod_oficina INT UNSIGNED,
    cod_producto INT UNSIGNED,
    existencia TINYINT(1) DEFAULT 1,
    FOREIGN KEY (cod_oficina) REFERENCES oficina(codigo),
    FOREIGN KEY (cod_producto) REFERENCES producto(codigo)
);

-- Inserts para la tabla departamento
INSERT INTO departamento (nombre) VALUES ('Departamento 1');
INSERT INTO departamento (nombre) VALUES ('Departamento 2');

-- Inserts para la tabla ciudades
INSERT INTO ciudades (nombre, cod_departamento) VALUES ('Ciudad 1', 1);
INSERT INTO ciudades (nombre, cod_departamento) VALUES ('Ciudad 2', 2);

-- Inserts para la tabla oficina
INSERT INTO oficina (nombre, cod_ciudad, gerente) VALUES ('Oficina 1', 1, 'Luis Carlos');
INSERT INTO oficina (nombre, cod_ciudad, gerente) VALUES ('Oficina 2', 2, 'Fernanda Mejia');

-- Inserts para la tabla producto
INSERT INTO producto (descripcion) VALUES ('Producto 1');
INSERT INTO producto (descripcion) VALUES ('Producto 2');

-- Inserts para la tabla inventario
INSERT INTO inventario (cod_oficina, cod_producto, existencia) VALUES (1, 1, 1);
INSERT INTO inventario (cod_oficina, cod_producto, existencia) VALUES (2, 2, 1);


-- SENTENCIAS
-- A
SELECT nombre FROM oficina WHERE gerente LIKE '%luis%';

-- B
SELECT oficina.nombre as oficina, ciudades.nombre AS ciudad, departamento.nombre AS departamento
FROM oficina
JOIN ciudades ON oficina.cod_ciudad = ciudades.codigo
JOIN departamento ON ciudades.cod_departamento = departamento.codigo;

--C
SELECT oficina.nombre AS oficina
FROM oficina
JOIN inventario ON oficina.codigo = inventario.cod_oficina
JOIN producto ON inventario.cod_producto = producto.codigo
WHERE producto.descripcion LIKE '%1%';

--D
SELECT oficina.nombre AS oficina, SUM(inventario.existencia) AS total_existencia
FROM oficina
JOIN inventario ON oficina.codigo = inventario.cod_oficina
GROUP BY oficina.nombre
ORDER BY total_existencia DESC
LIMIT 1;

--E
SELECT oficina.nombre AS oficina, ciudades.nombre AS ciudad, producto.descripcion AS producto, inventario.existencia
FROM oficina
JOIN ciudades ON oficina.cod_ciudad = ciudades.codigo
JOIN inventario ON oficina.codigo = inventario.cod_oficina
JOIN producto ON inventario.cod_producto = producto.codigo
WHERE inventario.existencia < 10;

--F
UPDATE inventario
JOIN oficina ON inventario.cod_oficina = oficina.codigo
SET inventario.existencia = 4
WHERE oficina.cod_ciudad = 1;


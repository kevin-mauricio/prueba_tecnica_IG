DROP DATABASE IF EXISTS dinero_facil;
CREATE DATABASE dinero_facil;
USE dinero_facil;

CREATE TABLE clientes(
    cliente_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipo_documento ENUM('CC', 'CE', 'PASAPORTE') NOT NULL,
    numero_documento VARCHAR(12) NOT NULL UNIQUE,
    apellidos VARCHAR(40) NOT NULL,
    residencia VARCHAR(120) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    nit_empresa VARCHAR(15) NOT NULL UNIQUE,
    nombre_empresa VARCHAR(30) NOT NULL,
    direccion_empresa VARCHAR(120) NOT NULL,
    telefono_empresa VARCHAR(12) NOT NULL,
    cargo VARCHAR(30) NOT NULL,
    fecha_vinculacion TIMESTAMP NOT NULL
);

INSERT INTO clientes (tipo_documento, numero_documento, apellidos, residencia, ciudad, telefono, nit_empresa, nombre_empresa, direccion_empresa, telefono_empresa, cargo, fecha_vinculacion) VALUES
('CC', '1234567890', 'Pérez López', 'Calle 123 #45-67', 'Bogotá', '3101234567', '900123456', 'Empresa A', 'Carrera 10 #20-30', '3201234567', 'Gerente', '2023-01-15 08:30:00'),
('CE', '0987654321', 'García Torres', 'Avenida 45 #67-89', 'Medellín', '3112345678', '900654321', 'Empresa B', 'Avenida 30 #40-50', '3212345678', 'Analista', '2022-03-20 09:00:00'),
('PASAPORTE', 'A12345678', 'Rodríguez Martínez', 'Carrera 7 #12-34', 'Cali', '3123456789', '900789123', 'Empresa C', 'Calle 50 #60-70', '3223456789', 'Director', '2021-07-25 10:15:00'),
('CC', '1122334455', 'López Gómez', 'Transversal 9 #10-20', 'Cartagena', '3134567890', '900321654', 'Empresa D', 'Carrera 15 #25-35', '3234567890', 'Supervisor', '2020-05-30 14:45:00'),
('CE', '2233445566', 'Martínez Ramírez', 'Diagonal 6 #7-8', 'Barranquilla', '3145678901', '900987654', 'Empresa E', 'Calle 80 #90-100', '3245678901', 'Coordinador', '2019-11-10 11:00:00');


CREATE TABLE referencias_personales(
    r_personales_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT UNSIGNED,
    nombre VARCHAR(40) NOT NULL,
    direccion VARCHAR(120) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    email VARCHAR(120) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

CREATE TABLE referencias_familiares(
    r_familiares_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT UNSIGNED,
    nombre VARCHAR(40) NOT NULL,
    direccion VARCHAR(120) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    email VARCHAR(120) NOT NULL,
    parentesco VARCHAR(50),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

CREATE TABLE lineas_credito(
    l_credito_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    valor_maximo FLOAT NOT NULL,
    valor_minimo FLOAT NOT NULL,
    plazo_maximo SMALLINT NOT NULL
);

CREATE TABLE nuevo_credito(
    n_credito_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT UNSIGNED,
    l_credito_id INT UNSIGNED,
    valor FLOAT NOT NULL,
    plazo TIMESTAMP NOT NULL,
    descripcion VARCHAR(180) NOT NULL,
    estado TINYINT(1) DEFAULT 0,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id),
    FOREIGN KEY (l_credito_id) REFERENCES lineas_credito(l_credito_id)
);

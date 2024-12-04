USE bankdb;
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE cuentas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numeroCuenta VARCHAR(20) UNIQUE NOT NULL,
    saldo DOUBLE NOT NULL DEFAULT 0.0,
    tipoCuenta ENUM('AHORROS', 'CORRIENTE') NOT NULL,
    clienteId INT,
    FOREIGN KEY (clienteId) REFERENCES clientes(id)
);

SHOW TABLES;

INSERT INTO clientes (nombre, apellido, dni, email) 
VALUES ('Juan', 'Pérez', '12345678', 'juan.perez@example.com');

INSERT INTO cuentas (numeroCuenta, saldo, tipoCuenta, clienteId) 
VALUES ('1234567890', 1500.50, 'AHORROS', 1);

SELECT * FROM clientes;




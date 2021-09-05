CREATE SCHEMA AlmacenMotos;
USE AlmacenMotos;
CREATE TABLE productos(
	id_producto INT,
	referencia VARCHAR(50) NOT NULL,
	costo FLOAT(10,1) NOT NULL,
	PRIMARY KEY(id_producto)
);
CREATE TABLE clientes(
	id_cli INT,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	telefono INT(16) NOT NULL,
	PRIMARY KEY(id_cli)
);
CREATE TABLE ventas(
	id_venta INT NOT NULL PRIMARY KEY,
	fecha DATE,
	id_cliente INT NOT NULL,
	id_moto INT NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cli),
    FOREIGN KEY(id_moto) REFERENCES productos(id_producto)
);

INSERT INTO productos(id_producto, referencia, costo) VALUES(101, 'AKT', 1500000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(102, 'PULSAR', 3500000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(103, 'Harley', 9500000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(104, 'Chopper300', 2900000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(105, 'Renegade', 4250000.0);

INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(10, 'Julius', 'Hibbert', 66787876);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(11, 'Homero J.', 'Simpson', 79787876);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(12, 'Gregory', 'House', 45387871);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(14, 'Nick', 'Riviera', 45646543);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(15, 'Mark', 'Dacascos', 66787874);

INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(50, '2020-05-11', 10, 101);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(51, '2020-06-12', 11, 102);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(52, '2020-06-13', 12, 103);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(53, '2020-07-15', 14, 104);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(54, '2020-08-17', 15, 105);


INSERT INTO productos(id_producto, referencia, costo) VALUES(301, 'Honda', 2500000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(302, 'Bajaj', 6500000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(303, 'Auteco', 7500000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(304, 'Ducati', 6966000.0);
INSERT INTO productos(id_producto, referencia, costo) VALUES(305, 'Ferregi', 3550000.0);

INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(20, 'Jaime', 'Ramirez', 59684871);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(21, 'Alfredo R.', 'Dulcey', 59263228);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(22, 'Camilo', 'Perez', 45182969);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(24, 'Anderson', 'Gonzales', 36594817);
INSERT INTO clientes(id_cli, nombre, apellido, telefono) VALUES(25, 'Miguel', 'Dacota', 26597845);

INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(70, '2019-06-11', 20, 301);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(71, '2019-09-12', 21, 302);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(72, '2018-07-13', 22, 303);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(73, '2018-01-15', 24, 304);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(74, '2018-01-17', 25, 305);

INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(90, '2021-02-11', 10, 301);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(91, '2021-02-12', 11, 302);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(92, '2021-10-30', 12, 303);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(93, '2021-11-15', 14, 304);
INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(94, '2021-12-25', 15, 305);
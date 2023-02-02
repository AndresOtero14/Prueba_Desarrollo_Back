CREATE TABLE IF NOT EXISTS raza(
idraza INT PRIMARY KEY NOT NULL,
nombre varchar(50)
);


CREATE TABLE IF NOT EXISTS especie(
idespecie INT PRIMARY KEY NOT NULL,
nombre varchar(50),
fk_raza INT,
FOREIGN KEY (fk_raza) References raza(idraza)
);

CREATE TABLE IF NOT EXISTS amo(
idamo INT PRIMARY KEY NOT NULL,
tipoid varchar (10),
nombre varchar(100),
telefono varchar (12),
ciudad varchar (40),
direccion  varchar (50)

);


CREATE TABLE IF NOT EXISTS paciente (
idpaciente INT PRIMARY KEY NOT NULL,
nombre varchar(40),
fechaNapaciente date ,
fechaRegistro date ,
fk_especie INT ,
fk_amo INT ,
FOREIGN KEY (fk_especie) References especie(idespecie),
FOREIGN KEY (fk_amo) References amo(idamo)

);
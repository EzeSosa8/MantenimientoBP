
CREATE DATABASE mantenimientoBP;

USE mantenimientoBP;

CREATE TABLE edificio (
	id_edificio INT(4) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

CREATE TABLE equipamiento (
  id_equipamiento INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  marca VARCHAR(20) NOT NULL,
  modelo VARCHAR(20) NOT NULL,
  capacidad DOUBLE NOT NULL,
  id_edificio INT(4) NOT NULL,
  FOREIGN KEY (id_edificio) REFERENCES edificio(id_edificio)
);

CREATE TABLE contratista (
  id_contratista INT(8) NOT NULL PRIMARY KEY,
  razonSocial VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL,
  telefono INTEGER(20) NOT NULL
);

CREATE TABLE ordenServicio (
  id INT(15) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  descripcion VARCHAR(500) NOT NULL,
  plazo INTEGER(4) NOT NULL,
  fechaInicio DATE NOT NULL,
  fechaFin DATE NOT NULL,
  id_edificio INT(4) NOT NULL,
  id_contratista INT(8) NOT NULL,
  id_equipamiento INT(10) NOT NULL,
  FOREIGN KEY (id_edificio) REFERENCES edificio(id_edificio),
  FOREIGN KEY (id_contratista) REFERENCES contratista(id_contratista),
  FOREIGN KEY (id_equipamiento) REFERENCES equipamiento(id_equipamiento)
);

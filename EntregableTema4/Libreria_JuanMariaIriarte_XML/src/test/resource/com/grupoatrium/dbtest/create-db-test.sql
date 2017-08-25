DROP TABLE editorial;
DROP TABLE autor;
DROP TABLE autor_libro;
DROP TABLE libro;
DROP TABLE direccion;


CREATE TABLE editorial (
  id_editorial INTEGER PRIMARY KEY,
  nombre varchar(45),
  nif_cif varchar(10)
);

CREATE TABLE autor (
  id_autor INTEGER PRIMARY KEY,
  nombre varchar(45) DEFAULT NULL,
  nacionalidad varchar(45) DEFAULT NULL,
  bibliografia varchar(255) DEFAULT NULL,
  fk_direccion INTEGER DEFAULT NULL
);

CREATE TABLE libro (
  id_libro INTEGER PRIMARY KEY,
  titulo varchar(45) DEFAULT NULL,
  isbn varchar(45) DEFAULT NULL,
  fk_editorial INTEGER DEFAULT NULL,
  precio double DEFAULT NULL,
  descripcion varchar(255) DEFAULT NULL,
  publicacion INTEGER DEFAULT NULL
);

CREATE TABLE autor_libro (
  fk_autor INTEGER,
  fk_libro INTEGER,
  PRIMARY KEY (fk_autor, fk_libro)
);

CREATE TABLE direccion (
  id_direccion INTEGER PRIMARY KEY,
  calle varchar(45) DEFAULT NULL,
  poblacion varchar(45) DEFAULT NULL,
  provincia varchar(45) DEFAULT NULL,
  cp INTEGER DEFAULT NULL,
  numero INTEGER DEFAULT NULL
);

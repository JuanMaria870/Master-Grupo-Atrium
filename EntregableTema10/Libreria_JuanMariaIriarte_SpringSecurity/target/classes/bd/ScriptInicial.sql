INSERT INTO `libreria_springsecurity_jmir`.`editorial` (`id_editorial`, `nombre`, `nif_cif`) VALUES ('1', 'Editorial 1', '1234567890');
INSERT INTO `libreria_springsecurity_jmir`.`editorial` (`id_editorial`, `nombre`, `nif_cif`) VALUES ('2', 'Editorial 2', '2345678901');


INSERT INTO `libreria_springsecurity_jmir`.`direccion` (`id_direccion`, `calle`, `numero`, `poblacion`, `cp`, `provincia`) VALUES ('1', 'Aragon', '1', 'Valencia', '46001', 'Valencia');
INSERT INTO `libreria_springsecurity_jmir`.`direccion` (`id_direccion`, `calle`, `numero`, `poblacion`, `cp`, `provincia`) VALUES ('2', 'Colon', '2', 'Valencia', '46002', 'Valencia');
INSERT INTO `libreria_springsecurity_jmir`.`direccion` (`id_direccion`, `calle`, `numero`, `poblacion`, `cp`, `provincia`) VALUES ('3', 'Bailen', '3', 'Valencia', '46003', 'Valencia');
INSERT INTO `libreria_springsecurity_jmir`.`direccion` (`id_direccion`, `calle`, `numero`, `poblacion`, `cp`, `provincia`) VALUES ('4', 'Gandia', '4', 'Valencia', '46004', 'Valencia');

INSERT INTO `libreria_springsecurity_jmir`.`autor` (`id_autor`, `nombre`, `nacionalidad`, `bibliografia`) VALUES ('1', 'Juan', 'España', 'Autor de cuentos');
INSERT INTO `libreria_springsecurity_jmir`.`autor` (`id_autor`, `nombre`, `nacionalidad`, `bibliografia`) VALUES ('2', 'Pepe', 'España', 'Autor de novelas');
INSERT INTO `libreria_springsecurity_jmir`.`autor` (`id_autor`, `nombre`, `nacionalidad`, `bibliografia`) VALUES ('3', 'Alma', 'Francia', 'Autora de poesia');
INSERT INTO `libreria_springsecurity_jmir`.`autor` (`id_autor`, `nombre`, `nacionalidad`, `bibliografia`) VALUES ('4', 'Fran', 'Italia', 'Autor de suspense');


INSERT INTO `libreria_springsecurity_jmir`.`libro` (`id_libro`, `isbn`, `titulo`, `descripcion`, `publicacion`, `precio`, `editorial_id`) VALUES ('1', 'isbn 1', 'Cuento 1', 'Cuento corto', '2014', '10.5', '1');
INSERT INTO `libreria_springsecurity_jmir`.`libro` (`id_libro`, `isbn`, `titulo`, `descripcion`, `publicacion`, `precio`, `editorial_id`) VALUES ('2', 'isbn 2', 'Cuento 2', 'Cuento largo', '2016', '11.5', '2');
INSERT INTO `libreria_springsecurity_jmir`.`libro` (`id_libro`, `isbn`, `titulo`, `descripcion`, `publicacion`, `precio`, `editorial_id`) VALUES ('3', 'isbn 3', 'Novela 1', 'Novela larga', '2013', '12.5', '2');
INSERT INTO `libreria_springsecurity_jmir`.`libro` (`id_libro`, `isbn`, `titulo`, `descripcion`, `publicacion`, `precio`, `editorial_id`) VALUES ('4', 'isbn 4', 'Poesia 1', 'Poesia corta', '2012', '13.5', '2');
INSERT INTO `libreria_springsecurity_jmir`.`libro` (`id_libro`, `isbn`, `titulo`, `descripcion`, `publicacion`, `precio`, `editorial_id`) VALUES ('5', 'isbn 5', 'Libro suspense 1', 'Libro de suspense', '2011', '14.5', '2');
INSERT INTO `libreria_springsecurity_jmir`.`libro` (`id_libro`, `isbn`, `titulo`, `descripcion`, `publicacion`, `precio`, `editorial_id`) VALUES ('6', 'isbn 6', 'Poesia 1', 'Poesia larga', '2010', '15.5', '1');


INSERT INTO `libreria_springsecurity_jmir`.`autor_libro` (`id_autor`, `id_libro`) VALUES ('1', '1');
INSERT INTO `libreria_springsecurity_jmir`.`autor_libro` (`id_autor`, `id_libro`) VALUES ('1', '2');
INSERT INTO `libreria_springsecurity_jmir`.`autor_libro` (`id_autor`, `id_libro`) VALUES ('2', '3');
INSERT INTO `libreria_springsecurity_jmir`.`autor_libro` (`id_autor`, `id_libro`) VALUES ('3', '4');
INSERT INTO `libreria_springsecurity_jmir`.`autor_libro` (`id_autor`, `id_libro`) VALUES ('4', '5');
INSERT INTO `libreria_springsecurity_jmir`.`autor_libro` (`id_autor`, `id_libro`) VALUES ('3', '6');

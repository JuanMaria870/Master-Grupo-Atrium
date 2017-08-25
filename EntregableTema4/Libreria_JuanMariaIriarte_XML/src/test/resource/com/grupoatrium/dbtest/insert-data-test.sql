INSERT INTO editorial VALUES (1, 'Editorial ONE', '123456789S');
INSERT INTO editorial VALUES (2, 'Editorial TWO', '234567891P');

INSERT INTO direccion VALUES (1, 'Gafaut', 'Vinalesa', 'Valencia', 46114, 15);
INSERT INTO direccion VALUES (2, 'Enric Valor', 'Vinalesa', 'Valencia', 46114, 1);

INSERT INTO autor VALUES (1, 'Alma', 'España', 'Escritora de cuentos', 1);
INSERT INTO autor VALUES (2, 'Juan', 'España', 'Escritor de novelas', 1);
INSERT INTO autor VALUES (3, 'Pepe', 'Francia', 'Escritor de poesia', 2);

INSERT INTO libro VALUES (1, 'Cuento 1', '123456789CU', 1, 10.95, 'Cuento sobre uncornios',2015);
INSERT INTO libro VALUES (2, 'Novela 1', '123456789NO', 2, 15.95, 'Novela negra',2000);
INSERT INTO libro VALUES (3, 'Poemas 1', '123456789PO', 1, 10.85, 'Poemas del mañana',2010);
INSERT INTO libro VALUES (4, 'Cuento de novelas 1', '123456789CN', 2, 19.95, 'Cuento novela juvenil',2012);

INSERT INTO autor_libro VALUES (1, 1);
INSERT INTO autor_libro VALUES (2, 2);
INSERT INTO autor_libro VALUES (3, 3);
INSERT INTO autor_libro VALUES (1, 4);
INSERT INTO autor_libro VALUES (2, 4);



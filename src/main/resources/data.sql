/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dennis
 * Created: 14/03/2018
 */

INSERT INTO TIPO_PRENDA(nombre, precio) VALUES ('Camisas formales', 52900);
INSERT INTO TIPO_PRENDA(NOMBRE, PRECIO) VALUES ('Pantalones formales', 84200);
INSERT INTO TIPO_PRENDA(NOMBRE, PRECIO) VALUES ('Chaquetas', 76800);

INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (1, 32, 'Camisa corta', null, 'cc.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (1, 33, 'Camisa larga', null, 'cl.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (1, 34, 'Camisa corta a cuadros', null, 'cmc.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (1, 35, 'Buzo', null, 'bu.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (1, 36, 'Camisilla', null, 'cmll.jpg');

INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (2, 312, 'Pantalon dryl', null, 'pd.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (2, 313, 'Pantalon algodon', null, 'pa.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (2, 314, 'Pantalon seda', null, 'ps.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (2, 315, 'Pantalon gala', null, 'pg.jpg');

INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (3, 272, 'Chaqueta cuero', null, 'chc.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (3, 273, 'Chaqueta sintética', null, 'chs.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (3, 274, 'Chaqueta algodon', null, 'cha.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (3, 275, 'Chaqueta buzo', null, 'chb.jpg');
INSERT INTO PRENDA(id_tipo_prenda, codigo, nombre, descripcion, imagen) VALUES (3, 276, 'Chaqueta ejecutiva', null, 'che.jpg');

INSERT INTO COMPRADOR(tipo_identificacion, numero_identificacion, nombre) VALUES ('CC', '2020', 'Marta Lucía Ramirez');

INSERT INTO PEDIDO(id_comprador, fecha_hora_entrega, direccion_entrega) VALUES (1, '2018-04-01 14:00:00', 'Carrera 5A # 34-20');
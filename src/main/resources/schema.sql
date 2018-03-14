/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dennis
 * Created: 14/03/2018
 */


create table if not exists tipo_prenda
(
    id IDENTITY not null,
    nombre varchar(100) not null,
    precio number(17,2) not null,
    primary key(id)
);

create table if not exists prenda
(
    id IDENTITY not null,
    id_tipo_prenda integer not null,
    codigo integer not null,
    nombre varchar(100) not null,
    descripcion varchar(500),
    imagen varchar(200),
    primary key(id)
);

alter table prenda add constraint prenda_tipo_prenda_fk foreign key(id_tipo_prenda) references tipo_prenda(id);


create table if not exists comprador
(
    id IDENTITY not null,
    tipo_identificacion varchar(20) not null,
    numero_identificacion varchar(10) not null,
    nombre varchar(200) not null,
    primary key(id)
);

create table if not exists pedido
(
    id IDENTITY not null,
    id_comprador integer not null,
    fecha_hora_entrega timestamp,
    direccion_entrega varchar(250),
    total number(17,2),
    primary key(id)
);

alter table pedido add constraint pedido_comprador_fk foreign key(id_comprador) references comprador(id);

create table if not exists item_pedido
(
    id IDENTITY not null,
    id_pedido integer not null,
    id_prenda integer not null,
    cantidad integer not null,
    precio number(17,2),
    primary key(id)
);

alter table item_pedido add constraint item_pedido_pedido_fk foreign key(id_pedido) references pedido(id);
alter table item_pedido add constraint item_pedido_prenda_fk foreign key(id_prenda) references prenda(id);


insert into public.usuario (id_usuario, estado, clave, nombre)
values  (1, true, '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', 'srodriguez@gmail.com'),
        (2, true, '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', 'pmartinez@gmail.com'),
        (3, true, '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', 'mflores@gmail.com');

insert into public.rol (id_rol, descripcion, nombre)
values  (1, 'Administrador', 'ADMIN'),
        (2, 'Usuario', 'USER'),
        (3, 'Admin de bd', 'DBA');

insert into public.usuario_rol (id_usuario, id_rol)
values  (1, 1),
        (2, 2),
	(3, 3);

insert into public.grupo_coleccion (id_grupo_coleccion, nombre_grupo_coleccion, fk_id_usuario)
values  (1, 'segunda coleccion', 2);


insert into public.coleccion (id_coleccion, nombre_coleccion, fk_id_groupcolection)
values  (1, 'hijos de daana', 1);

insert into public.coleccion_carta (id_carta, id_coleccion)
values  (1, 1);

insert into public.carta (id_carta, codigo_carta, coste_carta, frecuencia_carta, fuerza_carta, habilidad_carta, historia_carta, ilustrador_carta, imagen_carta, nombre_carta, tipo_carta, fk_id_edicion)
values  (1, '1', '1', 'REAL', '1', 'habilidad carta', 'historia de daana', 'Genzo', 'genzo.jpg', 'daana', 'aliado', 1),
        (2, '2', '2', 'REAL', '2', 'habilidad ogma', 'HISTORIA OGMA', 'MAURICIO HERRERA', 'ogma.jpg', 'ogma', 'aliado', 1),
        (3, '1/100', '2', 'REAL', '1', 'habilidad carta', 'historia', 'Genzoas', 'genzoas.jpg', 'asdasd', 'aliado', 1),
        (4, '6/100', 's2', 'asdal', '4', 'habilidad', 'historia', 'genzo', 'genzo.jpg', 'genzocarta', 'oro', 1);

insert into public.edicion (id_edicion, anio_edicion, nombre_edicion, numero_cartas_edicion)
values  (1, '2004', 'hijos de daana', '236'),
        (2, '2000', 'el reto', '176'),
        (4, '2026', 'edici45onnueva', '255');

-------------------- TOKENS ----------------------

create table oauth_access_token (
token_id VARCHAR(256),
token bytea,
authentication_id VARCHAR(256),
user_name VARCHAR(256),
client_id VARCHAR(256),
authentication bytea,
refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

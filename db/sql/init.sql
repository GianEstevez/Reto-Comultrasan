CREATE TABLE IF NOT EXISTS PUBLIC.USUARIOS
(
    ID                  BIGSERIAL
        PRIMARY KEY,
    CORREO              VARCHAR(255) NOT NULL,
    LIMITE_ENLACES_PAGO BIGINT       NOT NULL,
    NUMERO_TELEFONO     VARCHAR(255) NOT NULL,
    PRIMER_APELLIDO     VARCHAR(255) NOT NULL,
    PRIMER_NOMBRE       VARCHAR(255) NOT NULL,
    SEGUNDO_APELLIDO    VARCHAR(255),
    SEGUNDO_NOMBRE      VARCHAR(255)
);

ALTER TABLE PUBLIC.USUARIOS
    OWNER TO ROOT;

-- CREATE TABLE IF NOT EXISTS PUBLIC.PRODUCTOS
-- (
--     ID         BIGSERIAL
--         PRIMARY KEY,
--     CODIGO     VARCHAR(255) NOT NULL,
--     NOMBRE     VARCHAR(255) NOT NULL,
--     ID_USUARIO BIGINT       NOT NULL
--         CONSTRAINT FK2SBQ0P983VQT057X5ABJYOPM0
--             REFERENCES PUBLIC.USUARIOS
-- );

-- ALTER TABLE PUBLIC.PRODUCTOS
--     OWNER TO ROOT;

-- CREATE TABLE ENLACES_PAGO
-- (
--     ID               BIGSERIAL PRIMARY KEY,
--     ACTIVO           BOOLEAN DEFAULT TRUE        NOT NULL,
--     CODIGO           VARCHAR(255)                NOT NULL
--         CONSTRAINT UK_T9VJF0L2PA74CAYMYI6LB65ET UNIQUE,
--     FECHA_HORA_DESDE TIMESTAMP(6) WITH TIME ZONE NOT NULL,
--     FECHA_HORA_HASTA TIMESTAMP(6) WITH TIME ZONE,
--     URL              VARCHAR(255)                NOT NULL,
--     ID_PRODUCTO      BIGINT                      NOT NULL
--         CONSTRAINT FKH8QWXSCAC4JCNTK96E8RCQS4M REFERENCES PRODUCTOS
-- );

-- ALTER TABLE ENLACES_PAGO
--     OWNER TO ROOT;

-- ALTER TABLE PUBLIC.ENLACES_PAGO
--     OWNER TO ROOT;

-- CREATE TABLE IF NOT EXISTS PUBLIC.TRANSACCIONES
-- (
--     ID          BIGSERIAL
--         PRIMARY KEY,
--     FECHA_HORA  TIMESTAMP(6) WITH TIME ZONE NOT NULL,
--     VALOR       DOUBLE PRECISION            NOT NULL,
--     ID_PRODUCTO BIGINT
--         CONSTRAINT FK38JMCFMPVOEII4HP2F8R2LFH7
--             REFERENCES PUBLIC.PRODUCTOS
-- );

-- ALTER TABLE PUBLIC.TRANSACCIONES
--     OWNER TO ROOT;

-- CREATE TABLE IF NOT EXISTS PUBLIC.TRANSACCIONES_ENLACE
-- (
--     ID             BIGSERIAL
--         PRIMARY KEY,
--     HUELLA         VARCHAR(255) NOT NULL,
--     IP             VARCHAR(255) NOT NULL,
--     ID_ENLACE      BIGINT       NOT NULL
--         CONSTRAINT FKAQ02VV8HAT9GW1QW5W4S17F57
--             REFERENCES PUBLIC.ENLACES_PAGO,
--     ID_TRANSACCION BIGINT       NOT NULL
--         CONSTRAINT FK7K168RS4MFB7LY8DQ1O4HUBW5
--             REFERENCES PUBLIC.TRANSACCIONES
-- );

-- ALTER TABLE PUBLIC.TRANSACCIONES_ENLACE
--     OWNER TO ROOT;

INSERT INTO public.usuarios (id, correo, limite_enlaces_pago, numero_telefono, primer_apellido, primer_nombre, segundo_apellido, segundo_nombre) VALUES (1, 'yuri@gmail.com', 0, '3102829322', 'estevez', 'yuri', 'ruiz', 'melissa');
INSERT INTO public.usuarios (id, correo, limite_enlaces_pago, numero_telefono, primer_apellido, primer_nombre, segundo_apellido, segundo_nombre) VALUES (2, 'edward@gmail.com', 4, '3102829322', 'parada', 'edward', 'silva', 'javier');
INSERT INTO public.usuarios (id, correo, limite_enlaces_pago, numero_telefono, primer_apellido, primer_nombre, segundo_apellido, segundo_nombre) VALUES (3, 'gian@gmail.com', 1, '3102829322', 'estevez', 'gianfranco', 'ruiz', null);

-- INSERT INTO public.productos (id, codigo, nombre, id_usuario) VALUES (1, 'COD1', 'Cuenta de Ahorros',  1);
-- INSERT INTO public.productos (id, codigo, nombre, id_usuario) VALUES (2, 'COD2', 'Cuenta de Ahorros Amiga',  2);
-- INSERT INTO public.productos (id, codigo, nombre, id_usuario) VALUES (3, 'COD3', 'Cuenta de Ahorros Enemiga',  2);
-- INSERT INTO public.productos (id, codigo, nombre, id_usuario) VALUES (4, 'COD4', 'Cuenta de Ahorros de Broma',  3);

-- INSERT INTO public.transacciones (id, fecha_hora, valor, id_producto) VALUES (1, NOW(), 10000, 1);
-- INSERT INTO public.transacciones (id, fecha_hora, valor, id_producto) VALUES (2, NOW(), 900000, 2);
-- INSERT INTO public.transacciones (id, fecha_hora, valor, id_producto) VALUES (3, NOW(), 1000000, 3);

-- INSERT INTO public.enlaces_pago (url, id, activo, codigo, id_producto, fecha_hora_desde, fecha_hora_hasta) VALUES ('https://localhost:5000/pago/', 1, TRUE, 'nrxuZt', 2, '2023-10-18 08:56:47.354268 +00:00', '2023-10-18 09:56:47.354269 +00:00');
-- INSERT INTO public.enlaces_pago (url, id, activo, codigo, id_producto, fecha_hora_desde, fecha_hora_hasta) VALUES ('https://localhost:5000/pago/', 2, TRUE, '5XY8Zi', 3, '2023-10-18 08:56:47.356942 +00:00', '2023-10-18 18:56:47.356942 +00:00');
-- INSERT INTO public.enlaces_pago (url, id, activo, codigo, id_producto, fecha_hora_desde, fecha_hora_hasta) VALUES ('https://localhost:5000/pago/', 3, TRUE, 'FYr3tq', 4, '2023-10-18 08:56:47.358435 +00:00', '2023-10-22 12:56:47.358435 +00:00');

-- INSERT INTO public.transacciones_enlace (id, id_enlace, id_transaccion, huella, ip) VALUES (1, 1, 1, 'fingerprint1', '192.168.1.1');
-- INSERT INTO public.transacciones_enlace (id, id_enlace, id_transaccion, huella, ip) VALUES (2, 2, 2, 'fingerprint2', '192.168.1.2');
-- INSERT INTO public.transacciones_enlace (id, id_enlace, id_transaccion, huella, ip) VALUES (3, 3, 3, 'fingerprint3', '192.168.1.3');

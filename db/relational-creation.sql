CREATE TABLE USUARIO(
	idUsuario SERIAL PRIMARY KEY,
	nombreUsuario VARCHAR(100),
	numeroDocumento VARCHAR(20),
	telefono VARCHAR(20),
  	correo VARCHAR(30)
);

CREATE TABLE CUENTA(
	idCuenta SERIAL PRIMARY KEY,
    saldo INTEGER,
    idUsuario INTEGER,
    FOREIGN KEY (idUsuario) REFERENCES USUARIO(idUsuario)
);

CREATE TABLE QR(
  	idQr SERIAL PRIMARY KEY,
  	fechaCreacion TIMESTAMP DEFAULT(now()),
  	fechaFinalizacion DATE,
  	estado BOOLEAN,
  	codigo VARCHAR(50),
  	idCuenta INTEGER,
  	FOREIGN KEY (idCuenta) REFERENCES CUENTA(idCuenta)
);

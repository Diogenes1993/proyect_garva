DROP DATABASE IF EXISTS GARVA;
CREATE DATABASE  GARVA;
USE GARVA;

DROP TABLE IF EXISTS DETALLE_PEDIDO;
DROP TABLE IF EXISTS DETALLE_USUARIO;
DROP TABLE IF EXISTS DETALLE_BOLETA_PEDIDO;
DROP TABLE IF EXISTS USUARIO;
DROP TABLE IF EXISTS TOTAL_PEDIDO;
DROP TABLE IF EXISTS BOLETA;
DROP TABLE IF EXISTS PEDIDO;
DROP TABLE IF EXISTS PAGO_GUARDADO;
DROP TABLE IF EXISTS EMPLEADO;
DROP TABLE IF EXISTS MENU;
DROP TABLE IF EXISTS CLIENTE;


CREATE TABLE CLIENTE
(
	PK_ID_CLIENTE 		INT  AUTO_INCREMENT ,
    NOMBRE_CLIENTE 		VARCHAR(50) NOT NULL,
    APELLIDO_CLIENTE 	VARCHAR(50) NOT NULL,
    DIRECCION_CLIENTE 	VARCHAR(60) ,
    TELEFONO_CLIENTE 	VARCHAR(15),
    CORREO_CLIENTE 		VARCHAR(80),
						UNIQUE KEY `id_cliente_uq`(PK_ID_CLIENTE)
);

INSERT INTO CLIENTE(NOMBRE_CLIENTE,APELLIDO_CLIENTE,DIRECCION_CLIENTE,TELEFONO_CLIENTE,CORREO_CLIENTE) VALUES("Juan","Martinez","Breña","98123123","sadasdaeqwe");

CREATE TABLE PAGO_GUARDADO
(
	PK_ID_PAGO    INT AUTO_INCREMENT,
    MONTO 	   	  DECIMAL(11,3) UNSIGNED NOT NULL,
    FECHA	   	  DATE NOT NULL,
    FK_ID_CLIENTE INT  NOT NULL,
				  UNIQUE KEY`PK_ID_CARGO`(PK_ID_PAGO),
				  INDEX(FK_ID_CLIENTE)
);

ALTER TABLE PAGO_GUARDADO ADD FOREIGN KEY`pago_cliente`(FK_ID_CLIENTE) REFERENCES CLIENTE(PK_ID_CLIENTE);


CREATE TABLE EMPLEADO
(
	PK_ID_EMPLEADO 				INT  AUTO_INCREMENT ,
    NOMBRE_EMPLEADO				VARCHAR(50) NOT NULL,
    APELLIDO_EMPLEADO 			VARCHAR(50) NOT NULL,
	DIRECCION_EMPLEADO 			VARCHAR(50) NOT NULL,
    TELEFONO_EMPLEADO 			VARCHAR(20) NOT NULL,
    ROL_EMPLEADO 				ENUM("CAJERA","COCINERO","CONTADORA") DEFAULT "CAJERA",
    FECHA_CONTRATACION_EMPLEADO DATE NOT NULL,
								UNIQUE KEY `id_empleado_uq`(PK_ID_EMPLEADO)
);



CREATE TABLE MENU
(
	PK_ID_MENU INT  AUTO_INCREMENT ,
    FECHA_MENU DATETIME DEFAULT CURRENT_TIMESTAMP() ,
    STOCK_MENU INT UNSIGNED DEFAULT(0)NOT NULL,
    PRECIO_MENU DECIMAL(11,3)  NOT NULL,
				UNIQUE KEY `id_menu_uq` (PK_ID_MENU)
);

CREATE TABLE PEDIDO 
(
	PK_ID_PEDIDO INT AUTO_INCREMENT,
    FECHA_PEDIDO DATETIME DEFAULT CURRENT_TIMESTAMP(),
    CANTIDAD 	 INT UNSIGNED UNSIGNED NOT NULL,
    FK_ID_MENU 	 INT   NOT NULL,
				 UNIQUE KEY `id_pedido_uq`(PK_ID_PEDIDO),
				 INDEX(FK_ID_MENU)
);

ALTER TABLE PEDIDO ADD FOREIGN KEY`pedido_menu`(FK_ID_MENU) REFERENCES MENU(PK_ID_MENU);

CREATE TABLE BOLETA
(
	PK_ID_BOLETA	INT  AUTO_INCREMENT,
    NRO_BOLETA	    VARCHAR(255) UNIQUE NOT NULL ,
    FECHA_BOLETA	DATETIME DEFAULT CURRENT_TIMESTAMP(),
    IGV				DECIMAL(5,2)  NOT NULL,
    FK_ID_CLIENTE 	INT  NOT NULL,
    FK_ID_EMPLEADO  INT  NOT NULL,
    FK_ID_PEDIDO    INT  NOT NULL,
    
					UNIQUE KEY `id_boleta_uq`(PK_ID_BOLETA),
					INDEX(FK_ID_CLIENTE),
					INDEX(FK_ID_EMPLEADO),
                    INDEX(FK_ID_PEDIDO)
                    
);

ALTER TABLE BOLETA ADD  FOREIGN KEY`boleta_cliente`(FK_ID_CLIENTE) REFERENCES CLIENTE(PK_ID_CLIENTE);
ALTER TABLE BOLETA ADD FOREIGN KEY`boleta_empleado`(FK_ID_EMPLEADO) REFERENCES EMPLEADO(PK_ID_EMPLEADO);
ALTER TABLE BOLETA ADD FOREIGN KEY`boleta_pedido`(FK_ID_PEDIDO) REFERENCES PEDIDO(PK_ID_PEDIDO);

CREATE TABLE TOTAL_PEDIDO
(
	PK_ID_GASTO  INT  AUTO_INCREMENT,
    FK_ID_PEDIDO INT  NOT NULL,
    TOTAL_MONTO  DECIMAL(11,4)  NOT NULL,
    FECHA 		 DATETIME DEFAULT CURRENT_TIMESTAMP() ,
				 UNIQUE KEY `id_gasto_uq`(PK_ID_GASTO),
				 INDEX(FK_ID_PEDIDO)
);
ALTER TABLE TOTAL_PEDIDO ADD FOREIGN KEY`total_pedido`(FK_ID_PEDIDO) REFERENCES PEDIDO(PK_ID_PEDIDO);


CREATE TABLE DETALLE_BOLETA_MENU
(
	PK_ID_DETALLE_PEDIDO INT  AUTO_INCREMENT,
    FK_ID_MENU		     INT  NOT NULL,
    FK_ID_BOLETA		 INT  NOT NULL,
    TOTAL 				 DECIMAL(11,3)  NOT NULL,
    RESTO 				 DECIMAL(11,3)  NOT NULL,
						 UNIQUE KEY`id_detalle_pedido_uq`(PK_ID_DETALLE_PEDIDO),
                         INDEX(FK_ID_MENU),
                         INDEX(FK_ID_BOLETA)
);

ALTER TABLE DETALLE_BOLETA_MENU ADD FOREIGN KEY`detalle_menu`(FK_ID_MENU) REFERENCES MENU(PK_ID_MENU);
ALTER TABLE DETALLE_BOLETA_MENU ADD FOREIGN KEY`detalle_boleta`(FK_ID_BOLETA) REFERENCES BOLETA(PK_ID_BOLETA);


CREATE TABLE USUARIO
(
	PK_ID_USUARIO 		INT  AUTO_INCREMENT,
    NOMBRE_USUARIO	 	VARCHAR(50) UNIQUE NOT NULL,
    CONTRASENIA 		VARCHAR(105) NOT NULL,
    ESTADO 				BOOLEAN DEFAULT TRUE,
    CORREO 				VARCHAR(150),
						UNIQUE KEY `id_usuario_uq` (PK_ID_USUARIO)
);


CREATE TABLE DETALLE_PEDIDO
(
	PK_ID_DETALLE_PEDIDO INT AUTO_INCREMENT,
	FK_ID_GASTO INT NOT NULL,
    FK_ID_PAGO INT NOT NULL,
    CUENTA	   DECIMAL(10,2),
			   UNIQUE KEY`id_detalle_pedido_uq`(PK_ID_DETALLE_PEDIDO)

);
ALTER TABLE DETALLE_PEDIDO ADD FOREIGN KEY`detalle_gasto`(FK_ID_GASTO) REFERENCES TOTAL_PEDIDO(PK_ID_GASTO);
ALTER TABLE DETALLE_PEDIDO ADD FOREIGN KEY`detalle_pago`(FK_ID_PAGO) REFERENCES PAGO_GUARDADO(PK_ID_PAGO);
	

CREATE TABLE DETALLE_USUARIO
(
	FK_ID_EMPLEADO INT  NOT NULL,
    FK_ID_USUARIO  INT  NOT NULL,
    FECHA_ENTRADA  DATETIME DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    FECHA_SALIDA   DATETIME  NULL,
					PRIMARY KEY (FK_ID_EMPLEADO,FK_ID_USUARIO,FECHA_ENTRADA)
);
ALTER TABLE  DETALLE_USUARIO ADD FOREIGN KEY`detalle_usuario`(FK_ID_USUARIO) REFERENCES USUARIO(PK_ID_USUARIO);
ALTER TABLE DETALLE_USUARIO ADD FOREIGN KEY`detalle_empleado`(FK_ID_EMPLEADO) REFERENCES EMPLEADO(PK_ID_EMPLEADO);


############################## ELIMINANOS LA BD SI EXISTE #####################
DROP DATABASE IF EXISTS GARVA;
############################ CREACION DE LA BD GARVA ##########################
CREATE DATABASE  GARVA;
USE GARVA;

######################### ELIMINAMOS LAS TABLAS SI EXISTEN #######################
DROP TABLE IF EXISTS DETALLE_PEDIDO;
DROP TABLE IF EXISTS DETALLE_USUARIO;
DROP TABLE IF EXISTS DETALLE_BOLETA_PEDIDO;
DROP TABLE IF EXISTS USUARIO;
DROP TABLE IF EXISTS TOTAL_PEDIDO;
DROP TABLE IF EXISTS BOLETA;
DROP TABLE IF EXISTS ESTADO_PEDIDO;
DROP TABLE IF EXISTS PEDIDO;
DROP TABLE IF EXISTS PAGO_GUARDADO;
DROP TABLE IF EXISTS ROL;
DROP TABLE IF EXISTS EMPLEADO;
DROP TABLE IF EXISTS MENU;
DROP TABLE IF EXISTS CLIENTE;


############################# CREACION DE TABLAS ########################
CREATE TABLE DISTRITO(
	pk_id_distrito  CHAR(8),
    nombre_distrito VARCHAR(50),
					UNIQUE KEY`id_distrito_up`(pk_id_distrito)
);

CREATE TABLE CLIENTE(
	pk_id_cliente		CHAR(8),
    nombre_cliente 		VARCHAR(50) NOT NULL,
    apellido_cliente 	VARCHAR(50) NOT NULL,
    fk_id_distrito  	CHAR(8) NOT NULL,
    telefono_cliente	VARCHAR(12) NOT NULL,
    email_cliente 		VARCHAR(80) NOT NULL,
						UNIQUE KEY `id_cliente_uq`(pk_id_cliente),
                        FOREIGN KEY `cliente_distrito`(fk_id_distrito)REFERENCES DISTRITO(pk_id_distrito)
);

CREATE TABLE ROL(
	pk_id_rol 	CHAR(4),
    nombre_rol  VARCHAR(30),
    ruta_image	VARCHAR(80),
				UNIQUE KEY`id_rol_uq`(pk_id_rol)
);

CREATE TABLE EMPLEADO(
	pk_id_empleado 				CHAR(6),
    nombre_empleado				VARCHAR(50) NOT NULL,
    apellido_empleado 			VARCHAR(50) NOT NULL,
	fk_id_distrito 			    CHAR(8) NOT NULL,
    telefono_empleado 			VARCHAR(20) NOT NULL,
    email_empleado				VARCHAR(150) NOT NULL,
    fecha_ingreso				DATE NOT NULL,
    fk_id_rol	 				CHAR(4) NOT NULL,
    							UNIQUE KEY `id_empleado_uq`(PK_ID_EMPLEADO),
                                FOREIGN KEY`rol_empleado`(fk_id_rol)  REFERENCES ROL(pk_id_rol),
                                FOREIGN KEY `empleado_distrito`(fk_id_distrito)REFERENCES DISTRITO(pk_id_distrito)
);

CREATE TABLE ADELANTO(
	pk_id_adelanto    CHAR(8),
    monto_adelanto 	  DOUBLE  NOT NULL,
    fecha_adelanto	  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fk_id_cliente     CHAR(8) NOT NULL,
    fk_id_empleado	  CHAR(6) NOT NULL,
					  UNIQUE KEY`pk_id_adelanto_uq`(pk_id_adelanto),
					  FOREIGN KEY`adelanto_cliente`(fk_id_cliente) REFERENCES CLIENTE(pk_id_cliente),
                      FOREIGN KEY`adelanto_empleado`(fk_id_empleado) REFERENCES EMPLEADO(pk_id_empleado)
);

CREATE TABLE MENU(
	pk_id_menu  	CHAR(8),
    nombre_menu 	VARCHAR(50),
    detalle_menu 	VARCHAR(60),
    fecha_menu  	DATETIME DEFAULT CURRENT_TIMESTAMP,
    stock_menu  	INT NOT NULL,
    precio_menu 	DOUBLE  NOT NULL,
    ruta_image      VARCHAR(150),
					UNIQUE KEY `id_menu_uq` (pk_id_menu)
);

CREATE TABLE ESTADO(
	pk_id_estado   INT(1),
    nombre_estado  VARCHAR(15),
				   UNIQUE`id_estado_unique`(PK_ID_ESTADO)
);

CREATE TABLE PEDIDO (
	pk_id_pedido CHAR(8),
    fecha_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cantidad 	 INT  UNSIGNED NOT NULL,
    fk_id_estado INT(1),
    fk_id_menu 	 CHAR(8) NOT NULL,
				 UNIQUE KEY `id_pedido_uq`(pk_id_pedido),
				 FOREIGN KEY`pedido_menu`(fk_id_menu) REFERENCES MENU(pk_id_menu),
                 FOREIGN KEY`pedido_estado`(fk_id_estado) REFERENCES ESTADO(pk_id_estado)
);

CREATE TABLE BOLETA(
	pk_id_boleta   CHAR(8),
    fecha_boleta   DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    igv			   DOUBLE,
    fk_id_cliente  CHAR(8) NOT NULL,
    fk_id_empleado CHAR(6) NOT NULL,
    fk_id_pedido   CHAR(8)  NOT NULL,
    
					UNIQUE KEY `id_boleta_uq`(pk_id_boleta),
                    FOREIGN KEY`boleta_cliente`(fk_id_cliente) REFERENCES CLIENTE(pk_id_cliente),
					FOREIGN KEY`boleta_empleado`(fk_id_empleado) REFERENCES EMPLEADO(pk_id_empleado),
					FOREIGN KEY`boleta_pedido`(fk_id_pedido) REFERENCES PEDIDO(pk_id_pedido)
);

/*
CREATE TABLE DETALLE_ADELANTO
(
	pk_id_detalle_adelanto  INT  AUTO_INCREMENT,
    fk_detalle_pedido       INT  NOT NULL,
    TOTAL_MONTO  DECIMAL(11,4)  NOT NULL,
    FECHA 		 DATETIME DEFAULT CURRENT_TIMESTAMP() ,
    
				 UNIQUE KEY `id_gasto_uq`(PK_ID_GASTO),
				 INDEX(FK_ID_PEDIDO)
);
ALTER TABLE TOTAL_PEDIDO ADD FOREIGN KEY`total_pedido`(FK_ID_PEDIDO) REFERENCES PEDIDO(PK_ID_PEDIDO);
*/

CREATE TABLE CONSUMO(
	fk_id_pedido   CHAR(8),
    fk_id_adelanto CHAR(8),
    fecha_consumo  DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    monto_adelanto DOUBLE,
				   PRIMARY KEY(fk_id_pedido,fk_id_adelanto,fecha_consumo),
                   FOREIGN KEY`consumo_de_adelanto`(fk_id_adelanto) REFERENCES ADELANTO(pk_id_adelanto),
                   FOREIGN KEY`consumo_de__pedido`(fk_id_pedido) REFERENCES PEDIDO(pk_id_pedido)
);

/*
CREATE TABLE DETALLE_BOLETA_MENU
(
	PK_ID_DETALLE_MENU INT  AUTO_INCREMENT,
    FK_ID_MENU		     INT  NOT NULL,
    FK_ID_BOLETA		 INT  NOT NULL,
    TOTAL 				 DECIMAL(11,3)  NOT NULL,
    RESTO 				 DECIMAL(11,3)  NOT NULL,
						 UNIQUE KEY`id_detalle_pedido_uq`(PK_ID_DETALLE_MENU),
                         INDEX(FK_ID_MENU),
                         INDEX(FK_ID_BOLETA)
);

ALTER TABLE DETALLE_BOLETA_MENU ADD FOREIGN KEY`detalle_menu`(FK_ID_MENU) REFERENCES MENU(PK_ID_MENU);
ALTER TABLE DETALLE_BOLETA_MENU ADD FOREIGN KEY`detalle_boleta`(FK_ID_BOLETA) REFERENCES BOLETA(PK_ID_BOLETA);
*/

CREATE TABLE USUARIO(
	pk_id_usuario 		CHAR(6),
    nombre_usuario	 	VARCHAR(50) UNIQUE NOT NULL,
    contrasenia 		VARCHAR(105) NOT NULL,
    fk_id_estado 		INT(1),
    email 				VARCHAR(150) NOT NULL,
						UNIQUE KEY `id_usuario_uq` (pk_id_usuario),
                        FOREIGN KEY`usuario_estado`(fk_id_estado) REFERENCES ESTADO(Pk_id_estado)
);

CREATE TABLE DETALLE_USUARIO(
	fk_id_empleado CHAR(6),
    fk_id_usuario  CHAR(6),
    fecha_entrada  DATETIME DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    fecha_salida   DATETIME  NULL,
				   PRIMARY KEY (fk_id_empleado,fk_id_usuario,fecha_entrada),
                   FOREIGN KEY`detalle_empleado`(fk_id_empleado) REFERENCES EMPLEADO(pk_id_empleado),
                   FOREIGN KEY`detalle_usuario`(fk_id_usuario) REFERENCES USUARIO(pk_id_usuario)
);

#################################### DISTRITO #####################################
DELIMITER $$
CREATE PROCEDURE SP_LISTAR_DISTRITO()
BEGIN
	SELECT pk_id_distrito,nombre_distrito FROM DISTRITO;
END$$
DELIMITER ;

INSERT INTO DISTRITO(pk_id_distrito,nombre_distrito) VALUES('DI000001','Comas');
INSERT INTO DISTRITO(pk_id_distrito,nombre_distrito) VALUES('DI000002','Breña');
INSERT INTO DISTRITO(pk_id_distrito,nombre_distrito) VALUES('DI000003','Surco');
INSERT INTO DISTRITO(pk_id_distrito,nombre_distrito) VALUES('DI000004','San Martin de Porres');

CALL SP_LISTAR_DISTRITO();

##################################### CLIENTE ######################################
##### INSERTAR #####
DELIMITER $$
CREATE PROCEDURE SP_INSERTAR_CLIENTE(
	IN vin_id CHAR(8),
    IN vin_nombre	  VARCHAR(50),
    IN vin_apellido   VARCHAR(50),
    IN vin_distrito   CHAR(8),
    IN vin_telefono   VARCHAR(12),
    IN vin_email      VARCHAR(80)
)
BEGIN
	INSERT INTO CLIENTE(pk_id_cliente,nombre_cliente,apellido_cliente,fk_id_distrito,telefono_cliente,email_cliente)
				 VALUES(vin_id,vin_nombre,vin_apellido,vin_distrito,vin_telefono,vin_email);
END$$
DELIMITER ;

##### ACTUALIZAR #####
DELIMITER $$
CREATE PROCEDURE SP_ACTUALIZAR_CLIENTE(
	IN vin_id CHAR(8),
    IN vin_nombre	  VARCHAR(50),
    IN vin_apellido   VARCHAR(50),
    IN vin_distrito   CHAR(8),
    IN vin_telefono   VARCHAR(12),
    IN vin_email      VARCHAR(80)
)
BEGIN
	UPDATE CLIENTE 
	SET nombre_cliente    = vin_nombre,
		apellido_cliente  = vin_apellido,
        fk_id_distrito    = vin_distrito,
        telefono_cliente  = vin_telefono,
        email_cliente     = vin_email
  WHERE pk_id_cliente     = vin_id;
END;
$$DELIMITER ;

##### ELIMINAR #####
DELIMITER $$
CREATE PROCEDURE SP_ELIMINAR_CLIENTE(
	IN vin_id CHAR(8)
)
BEGIN
DELETE FROM CLIENTE WHERE pk_id_cliente=vin_id;
END$$
DELIMITER ;

##### LISTAR #####
DELIMITER $$
CREATE PROCEDURE SP_LISTAR_CLIENTE()
BEGIN
	SELECT C.pk_id_cliente,C.nombre_cliente,C.apellido_cliente,D.nombre_distrito,C.telefono_cliente,C.email_cliente 
    FROM CLIENTE AS C INNER JOIN DISTRITO AS D ON C.fk_id_distrito=D.pk_id_distrito ORDER BY 1 ASC;
END$$
DELIMITER ;

#### BUSCAR_ULTIMO_CODIGO ####
DROP PROCEDURE IF EXISTS SP_BUSCAR_ULTIMO_CODIGO_C;
DELIMITER $$
CREATE PROCEDURE SP_NUEVO_CODIGO_C()
BEGIN
	SELECT SUBSTRING(MAX(pk_id_cliente),3) FROM CLIENTE;
END$$
DELIMITER ;

##### BUSCAR_IDS #####
DROP PROCEDURE  IF EXISTS SP_BUSCAR_ID_CLIENTE;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_IDS_CLIENTE(
		IN id CHAR(8)
    )
BEGIN
	SELECT C.pk_id_cliente,C.nombre_cliente,C.apellido_cliente,D.nombre_distrito,C.telefono_cliente,C.email_cliente 
    FROM CLIENTE AS C INNER JOIN DISTRITO AS D ON C.fk_id_distrito=D.pk_id_distrito
    HAVING C.pk_id_cliente LIKE CONCAT('%',id,'%') 
    ORDER BY 1 ASC;
END$$
DELIMITER ;

##### BUSCAR_ONE ####
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_ID_CLIENTE(
		IN id CHAR(8)
    )
BEGIN
	SELECT C.pk_id_cliente,C.nombre_cliente,C.apellido_cliente,D.nombre_distrito,C.telefono_cliente,C.email_cliente 
    FROM CLIENTE AS C INNER JOIN DISTRITO AS D ON C.fk_id_distrito=D.pk_id_distrito
    HAVING C.pk_id_cliente = id 
    ORDER BY 1 ASC;
END$$
DELIMITER ;


##### BUSCAR_NOMBRE_APELLIDO #####
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_NOMBRE_APELLIDO_CLIENTE(
		IN vin_valor VARCHAR(50)
    )
BEGIN
	SELECT C.pk_id_cliente,C.nombre_cliente,C.apellido_cliente,D.nombre_distrito,C.telefono_cliente,C.email_cliente 
    FROM CLIENTE AS C INNER JOIN DISTRITO AS D ON C.fk_id_distrito=D.pk_id_distrito
    HAVING C.nombre_cliente LIKE CONCAT('%',vin_valor,'%') OR C.apellido_cliente LIKE CONCAT('%',vin_valor,'%')
    ORDER BY 1 ASC;
END$$
DELIMITER ;

##### BUSCAR_DIRECCION #####
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_DISTRITO_CLIENTE(
		IN vin_valor VARCHAR(100)
    )
BEGIN
	SELECT C.pk_id_cliente,C.nombre_cliente,C.apellido_cliente,D.nombre_distrito,C.telefono_cliente,C.email_cliente 
    FROM CLIENTE AS C INNER JOIN DISTRITO AS D ON C.fk_id_distrito=D.pk_id_distrito
    HAVING D.nombre_distrito LIKE CONCAT('%',vin_valor,'%')
    ORDER BY 1 ASC;
END$$
DELIMITER ;

####### LISTA DE NO ADELANTOS ###
DELIMITER $$
CREATE PROCEDURE SP_LISTA_DE_NO_ADELANTOS()
BEGIN
	SELECT  C.pk_id_cliente,C.nombre_cliente,C.apellido_cliente,D.nombre_distrito,C.telefono_cliente,C.email_cliente  FROM CLIENTE AS C
		LEFT JOIN ADELANTO AS A ON C.pk_id_cliente =A.fk_id_cliente
		INNER JOIN DISTRITO AS D ON C.fk_id_distrito =D.pk_id_distrito
		WHERE A.fk_id_cliente IS NULL
		ORDER BY 1 ASC;
END$$
DELIMITER ;

CALL SP_INSERTAR_CLIENTE('CL000001','Ezequiel','Zambrano Aguírre','DI000001','981212345','ezequiel@gmail.com');
CALL SP_INSERTAR_CLIENTE('CL000002','Marcos','Zapata Maldonado','DI000002','901267364','zapata@gmail.com');
CALL SP_INSERTAR_CLIENTE('CL000003','Camila','Campos Espiral','DI000003','912365785','camila@gmail.com');
CALL SP_INSERTAR_CLIENTE('CL000004','Sergio','Burga Amador','DI000004','901254765','burga@gmail.com');
CALL SP_INSERTAR_CLIENTE('CL000005','Obed','Fransua Palacios','DI000003','973652645','palacios@gmail.com');
CALL SP_INSERTAR_CLIENTE('CL000006','Gonzalo','Xavi Malvi','DI000004','983654787','mandez@gmail.com');

CALL SP_LISTAR_CLIENTE();

##################################### ROL ######################################
##### LISTAR #####
DELIMITER $$
CREATE PROCEDURE SP_LISTAR_ROL()
BEGIN
SELECT pk_id_rol,nombre_rol,ruta_image FROM ROL;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_ROL(
	IN vin_dato VARCHAR(20)
)
BEGIN
SELECT pk_id_rol,nombre_rol,ruta_image FROM ROL WHERE pk_id_rol = vin_dato OR nombre_rol = vin_dato;
END$$
DELIMITER ;

INSERT INTO ROL(pk_id_rol,nombre_rol,ruta_image) VALUES('R001','Cocinero','src/pkg_utilidades/rol/cocinero.png');
INSERT INTO ROL(pk_id_rol,nombre_rol,ruta_image) VALUES('R002','Cajera','src/pkg_utilidades/rol/cajera.png');
INSERT INTO ROL(pk_id_rol,nombre_rol,ruta_image) VALUES('R003','Contadora','src/pkg_utilidades/rol/contadora.png');


##################################### EMPLEADO ####################################
##### INSERTAR #####
DROP PROCEDURE IF EXISTS SP_INSERTAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_INSERTAR_EMPLEADO(
	IN vin_id CHAR(8),
    IN vin_nombre	  VARCHAR(50),
    IN vin_apellido   VARCHAR(50),
    IN vin_distrito   CHAR(8),
    IN vin_telefono   VARCHAR(12),
    IN vin_email      VARCHAR(80),
    IN vin_ingreso	  DATE,
    IN vin_rol 		  CHAR(4)
)
BEGIN
	INSERT INTO EMPLEADO(pk_id_empleado,nombre_empleado,apellido_empleado,fk_id_distrito,telefono_empleado,email_empleado,fecha_ingreso,fk_id_rol)
				  VALUES(vin_id,vin_nombre,vin_apellido,vin_distrito,vin_telefono,vin_email,vin_ingreso,vin_rol);
END$$
DELIMITER ;

##### ACTUALIZAR #####
DROP PROCEDURE IF EXISTS SP_ACTUALIZAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_ACTUALIZAR_EMPLEADO(
	IN vin_id         CHAR(8),
    IN vin_nombre	  VARCHAR(50),
    IN vin_apellido   VARCHAR(50),
    IN vin_distrito   CHAR(8),
    IN vin_telefono   VARCHAR(12),
    IN vin_email      VARCHAR(80),
    IN vin_ingreso	  DATE,
    IN vin_rol 		  CHAR(4)
)
BEGIN
	UPDATE EMPLEADO 
	SET nombre_empleado    = vin_nombre,
		apellido_empleado  = vin_apellido,
        fk_id_distrito     = vin_distrito,
        telefono_empleado  = vin_telefono,
        email_empleado     = vin_email,
        fecha_ingreso      = vin_ingreso,
        fk_id_rol		   = vin_rol
  WHERE pk_id_empleado     = vin_id;
END$$
DELIMITER ;

##### ELIMINAR #####
DROP PROCEDURE IF EXISTS SP_ELIMINAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_ELIMINAR_EMPLEADO(
	IN vin_id CHAR(8)
)
BEGIN
DELETE FROM EMPLEADO WHERE pk_id_empleado=vin_id;
END$$
DELIMITER ;

##### LISTAR #####
DROP PROCEDURE IF EXISTS SP_LISTAR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_LISTAR_EMPLEADO()
BEGIN
	SELECT E.pk_id_empleado,E.nombre_empleado,E.apellido_empleado,D.nombre_distrito,E.telefono_empleado,E.email_empleado,E.fecha_ingreso,R.nombre_rol
    FROM EMPLEADO AS E INNER JOIN DISTRITO AS D ON E.fk_id_distrito=D.pk_id_distrito
    INNER JOIN ROL AS R ON E.fk_id_rol=R.pk_id_rol
    ORDER BY 1 ASC;
END$$
DELIMITER ;

#### BUSCAR_ULTIMO_CODIGO ####
DROP PROCEDURE IF EXISTS SP_BUSCAR_ULTIMO_CODIGO_E;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_ULTIMO_CODIGO_E()
BEGIN
	SELECT SUBSTRING(MAX(pk_id_empleado),3) FROM EMPLEADO;
END$$
DELIMITER ;

##### BUSCAR_IDS #####
DROP PROCEDURE IF EXISTS SP_BUSCAR_ID_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_ID_EMPLEADO(
		IN id CHAR(8)
    )
BEGIN
	SELECT E.pk_id_empleado,E.nombre_empleado,E.apellido_empleado,D.nombre_distrito,E.telefono_empleado,E.email_empleado,E.fecha_ingreso,R.nombre_rol
    FROM EMPLEADO AS E INNER JOIN DISTRITO AS D ON E.fk_id_distrito=D.pk_id_distrito
    INNER JOIN ROL AS R ON E.fk_id_rol=R.pk_id_rol
    HAVING E.pk_id_empleado LIKE CONCAT('%',id,'%')
    ORDER BY 1 ASC;
    
END$$
DELIMITER ;

##### BUSCAR_NOMBRE_APELLIDO #####
DROP PROCEDURE IF EXISTS SP_BUSCAR_NOMBRE_APELLIDO_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_NOMBRE_APELLIDO_EMPLEADO(
		IN vin_valor VARCHAR(100)
    )
BEGIN
	SELECT E.pk_id_empleado,E.nombre_empleado,E.apellido_empleado,D.nombre_distrito,E.telefono_empleado,E.email_empleado,E.fecha_ingreso,R.nombre_rol
    FROM EMPLEADO AS E INNER JOIN DISTRITO AS D ON E.fk_id_distrito=D.pk_id_distrito
    INNER JOIN ROL AS R ON E.fk_id_rol=R.pk_id_rol
    HAVING E.nombre_empleado LIKE CONCAT('%',vin_valor,'%') OR E.apellido_empleado LIKE CONCAT('%',vin_valor,'%')
    ORDER BY 1 ASC;
END$$
DELIMITER ;

##### BUSCAR_DIRECCION #####
DROP PROCEDURE IF EXISTS SP_BUSCAR_DIRECCION_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_DIRECCION_EMPLEADO(
		IN vin_valor VARCHAR(100)
    )
BEGIN
	SELECT E.pk_id_empleado,E.nombre_empleado,E.apellido_empleado,D.nombre_distrito,E.telefono_empleado,E.email_empleado,E.fecha_ingreso,R.nombre_rol
    FROM EMPLEADO AS E INNER JOIN DISTRITO AS D ON E.fk_id_distrito=D.pk_id_distrito
    INNER JOIN ROL AS R ON E.fk_id_rol=R.pk_id_rol 
    HAVING D.nombre_distrito LIKE CONCAT('%',vin_valor,'%')
    ORDER BY 1 ASC;
END$$
DELIMITER ;

##### BUSCAR EMPLEADO MODIFICADO POR COD ####
DROP PROCEDURE IF EXISTS SP_BUSCAR_MODIFICADO_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_MODIFICADO_EMPLEADO(
		IN vin_valor VARCHAR(100)
    )
BEGIN
	SELECT E.pk_id_empleado,E.nombre_empleado,E.apellido_empleado,D.nombre_distrito,E.telefono_empleado,E.email_empleado,E.fecha_ingreso,R.nombre_rol
    FROM EMPLEADO AS E INNER JOIN DISTRITO AS D ON E.fk_id_distrito=D.pk_id_distrito
    INNER JOIN ROL AS R ON E.fk_id_rol=R.pk_id_rol 
    HAVING E.pk_id_empleado = vin_valor
    ORDER BY 1 ASC;
END$$
DELIMITER ;

CALL SP_INSERTAR_EMPLEADO('EM0001','Daniel','Basilio Amador','DI000001','981243567','deadpo22003elinmortal@gmail.com','2021-01-12','R001');
CALL SP_INSERTAR_EMPLEADO('EM0002','Erick','Castilla Fernandez','DI000001','9186533567','castilladi@gmail.com','2022-02-22','R001');
CALL SP_INSERTAR_EMPLEADO('EM0003','Maria','Grande Palomino','DI000002','912316127','grandepalomino@gmail.com','2020-02-21','R003');
CALL SP_INSERTAR_EMPLEADO('EM0004','Margarita','Castillo Trinidad','DI000002','909812127','margarita@gmail.com','2021-12-02','R003');
CALL SP_INSERTAR_EMPLEADO('EM0005','Francisco','Pizarro Alcantara','DI000003','924353245','pizarroalcantara@gmail.com','2021-11-11','R002');
CALL SP_INSERTAR_EMPLEADO('EM0006','Eladio','Ballesteros Palacios','DI000002','999923443','ballesteros@gmail.com','2021-09-11','R003');
CALL SP_INSERTAR_EMPLEADO('EM0007','Magnolia','Soto Machaco','DI000003','981243567','machaco@gmail.com','2021-08-04','R002');
CALL SP_INSERTAR_EMPLEADO('EM0008','Diego','Quispe Huertas','DI000002','981243567','quispehuertas@gmail.com','2021-01-01','R002');
CALL SP_INSERTAR_EMPLEADO('EM0009','Bryan','Sandobal Custodia','DI000003','981243567','sandobal@gmail.com','2020-01-12','R002');
CALL SP_INSERTAR_EMPLEADO('EM0010','Anderson','Quito Calderon','DI000002','981243567','quito@gmail.com','2023-05-14','R003');

##################################### ADELANTO ####################################
##### INSERTAR #####
DELIMITER $$
CREATE PROCEDURE SP_INSERTAR_ADELANTO(
	IN id 	  		CHAR(8),
    IN monto		DOUBLE,
    IN id_cliente   CHAR(8),
    IN id_empleado  CHAR(6)
)
BEGIN
 INSERT INTO ADELANTO(pk_id_adelanto,monto_adelanto,fk_id_cliente,fk_id_empleado)
			   VALUES(id,monto,id_cliente,id_empleado);
END$$
DELIMITER ;

##### ACTUALIZAR #####
DELIMITER $$
CREATE PROCEDURE SP_ACTUALIZAR_ADELANTO(
	IN id 	  		CHAR(8),
    IN monto		DOUBLE,
    IN id_cliente   CHAR(8),
    IN id_empleado  CHAR(6)
)
BEGIN
	UPDATE ADELANTO 
    SET    monto_adelanto = monto,
           fk_id_cliente  = id_cliente,
           fk_id_empleado = id_empleado
	WHERE  pk_id_adelanto=id;
END$$
DELIMITER ;

##### ELIMINAR #####
DELIMITER $$
CREATE PROCEDURE SP_ELIMINAR_ADELANTO(
	IN id 	  		CHAR(8)
)
BEGIN
	DELETE FROM ADELANTO WHERE  pk_id_adelanto=id;
END$$
DELIMITER ;

##### LISTAR #####
DROP PROCEDURE IF EXISTS PS_LISTAR_ADELANTO;
DELIMITER $$
CREATE PROCEDURE SP_LISTAR_ADELANTO()
BEGIN
	SELECT A.pk_id_adelanto,A.monto_adelanto,A.fecha_adelanto,CONCAT(C.nombre_cliente,' ',C.apellido_cliente) AS cliente,CONCAT(E.nombre_empleado,' ',E.apellido_empleado) AS atencion  FROM ADELANTO AS A
    INNER JOIN CLIENTE AS C ON A.fk_id_cliente = C.pk_id_cliente
    INNER JOIN EMPLEADO AS E ON A.fk_id_empleado = E.pk_id_empleado
    ORDER BY 1 ASC;
END$$
DELIMITER ;

##### BUSCAR_ #####
DROP PROCEDURE IF EXISTS SP_BUSCAR_ADELANTO_XC;
DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_ADELANTO_XC(
	IN vin_dato VARCHAR(30)
)
BEGIN
	SELECT A.pk_id_adelanto,A.monto_adelanto,A.fecha_adelanto,CONCAT(C.nombre_cliente,' ',C.apellido_cliente) AS cliente,CONCAT(E.nombre_empleado,' ',E.apellido_empleado) AS atencion  FROM ADELANTO AS A
    INNER JOIN CLIENTE AS C ON A.fk_id_cliente = C.pk_id_cliente
    INNER JOIN EMPLEADO AS E ON A.fk_id_empleado = E.pk_id_empleado
    HAVING cliente LIKE CONCAT('%',vin_dato,'%')
    ORDER BY 1 ASC;
END$$
DELIMITER ;

CALL SP_INSERTAR_ADELANTO('AD000001','120','CL000001','EM0001');
CALL SP_INSERTAR_ADELANTO('AD000002','160','CL000003','EM0001');
CALL SP_INSERTAR_ADELANTO('AD000003','150','CL000004','EM0001');
CALL SP_INSERTAR_ADELANTO('AD000004','220','CL000005','EM0001');


	

#################################### MENU #################################3
########## INSERTAR ############
DELIMITER $$
CREATE PROCEDURE SP_INSERTAR_MENU(
	IN vin_id 		  CHAR(8),
    IN vin_nombre     VARCHAR(50),
    IN vin_detalle    VARCHAR(60),
    IN vin_stock	  INT,
    IN vin_precio	  DOUBLE,
    IN vin_ruta_image VARCHAR(50)
)
BEGIN
	INSERT INTO MENU(pk_id_menu,nombre_menu,detalle_menu,stock_menu,precio_menu,ruta_image)
			  VALUES(vin_id,vin_nombre,vin_detalle,vin_stock,vin_precio,vin_ruta_image);
END$$
DELIMITER ;

######### ACTUALIZAR ########
DELIMITER $$
CREATE PROCEDURE SP_ACTUALIZAR_MENU(
	IN vin_id 		  CHAR(8),
    IN vin_nombre     VARCHAR(50),
    IN vin_detalle    VARCHAR(60),
    IN vin_stock	  INT,
    IN vin_precio	  DOUBLE,
    IN vin_ruta_image VARCHAR(50)
)
BEGIN 
	UPDATE MENU
	   SET nombre_menu  = vin_nombre,
		   detalle_menu = vin_detalle,
           stock_menu   = vin_stock,
           precio_menu  = vin_precio,
           ruta_image   = vin_ruta_image
	WHERE  pk_id_menu = vin_id;  
END$$
DELIMITER ;


##################################### ESTADO ######################################

INSERT INTO ESTADO(pk_id_estado,nombre_estado) VALUES('0','ACTIVO');
INSERT INTO ESTADO(pk_id_estado,nombre_estado) VALUES('1','INACTIVO');
INSERT INTO ESTADO(pk_id_estado,nombre_estado) VALUES('2','PROCESO');
INSERT INTO ESTADO(pk_id_estado,nombre_estado) VALUES('3','ENTREGADO');


SELECT * FROM USUARIO;


DROP PROCEDURE IF EXISTS SP_BUSCAR_USUARIO;

DELIMITER $$
CREATE PROCEDURE SP_BUSCAR_USUARIO(
	IN vin_usuario VARCHAR(50)
)
BEGIN
SELECT `pk_id_usuario`, `nombre_usuario`, `contrasenia`, `fk_id_estado`, `email` FROM USUARIO WHERE nombre_usuario=vin_usuario;
END$$
DELIMITER ;

CALL SP_BUSCAR_USUARIO('MASTER');
INSERT INTO `garva`.`USUARIO` (`pk_id_usuario`, `nombre_usuario`, `contrasenia`, `fk_id_estado`, `email`) VALUES ('U001', 'MASTER', '123456', '1', 'master1@gmail.com');

/*BEGIN; 
INSERT INTO EMPLEADO(NOMBRE_EMPLEADO,APELLIDO_EMPLEADO,DIRECCION_EMPLEADO,TELEFONO_EMPLEADO,FK_ID_ROL,FECHA_INGRESO) VALUES ('Dante','Jr.Humbolt 353','+51984564','1','2023-12-12');
INSERT INTO USUARIO(NOMBRE_USUARIO,CONTRASENIA,CORREO) VALUES('MASTER','1231','ASDAD');  
COMMIT;   */



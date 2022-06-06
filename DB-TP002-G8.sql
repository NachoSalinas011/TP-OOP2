create database IF NOT EXISTS grupo_8_spring_db;

use grupo_8_spring_db;
/*----------------------- Inicio Parte Usuario --------------------------*/

CREATE TABLE `perfil` (
  `id_perfil` int NOT NULL AUTO_INCREMENT,
  `perfil` varchar(45) NOT NULL,
  `baja` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id_perfil`)
) ;

insert into perfil values (NULL, 'administrador', default);
insert into perfil values (NULL, 'auditoria', default);
select * from perfil;

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `tipo_doc` varchar(45) NOT NULL,
  `nro_doc` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `password` text NOT NULL,
  `baja` bit(1) DEFAULT b'0',
  `id_perfil` int,
  PRIMARY KEY (`id_usuario`,`perfil_id`),
  KEY `fk_usuario_perfil_idx` (`perfil_id`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`perfil_id`)
  REFERENCES `perfil` (`id_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


/*----------------------- Fin Parte Usuario --------------------------*/

/*----------------------- Inicio Parte Parcial --------------------------*/

CREATE TABLE `edificio` (
  `id_edificio` int NOT NULL AUTO_INCREMENT,
  `edificio` varchar(50) NOT NULL,
  PRIMARY KEY (`id_edificio`)
);

CREATE TABLE `aula` (
  `id_aula` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `id_edificio` int NOT NULL,
  PRIMARY KEY (`id_aula`),
  KEY `fk_aula_1_idx` (`id_edificio`),
  CONSTRAINT `fk_aula_1` FOREIGN KEY (`id_edificio`) 
  REFERENCES `edificio` (`id_edificio`)
);

CREATE TABLE `espacio` (
  `id_espacio` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `turno` char(1) NOT NULL,
  `id_aula` int NOT NULL,
  `libre` tinyint NOT NULL,
  PRIMARY KEY (`id_espacio`),
  KEY `fk_espacio_1_idx` (`id_aula`),
  CONSTRAINT `fk_espacio_1` FOREIGN KEY (`id_aula`) 
  REFERENCES `aula` (`id_aula`)
);

CREATE TABLE `tradicional` (
  `id_tradicional` int NOT NULL,
  `cant_bancos` int NOT NULL,
  `pizarron` varchar(20) NOT NULL,
  `tiene_proyector` tinyint NOT NULL,
  PRIMARY KEY (`id_tradicional`),
  CONSTRAINT `fk_tradicional_1` FOREIGN KEY (`id_tradicional`) 
  REFERENCES `aula` (`id_aula`)
);

CREATE TABLE `laboratorio` (
  `id_laboratorio` int NOT NULL,
  `cant_sillas` int NOT NULL,
  `cant_PC` int NOT NULL,
  PRIMARY KEY (`id_laboratorio`),
  CONSTRAINT `fk_laboratorio_1` FOREIGN KEY (`id_laboratorio`) 
  REFERENCES `aula` (`id_aula`)
);

INSERT INTO `edificio` VALUES
 (1, 'Marechal'),
 (2, 'Hernandez'),
 (3, 'Scalabrini');
 
INSERT INTO `aula` VALUES
 (1, 10, 1),
 (2,20,2),
 (3,13,3),
 (4,14,1),
 (5,15,2),
 (6,16,3);
 
INSERT INTO `espacio` VALUES
 (1,'2022-05-01','M',1,1),
 (2,'2022-05-01','N',2,1),
 (3,'2022-05-02','M',3,1);
 
INSERT INTO `tradicional` VALUES
 (1,50,'tiza',0),
 (2,70,'fibron',1),
 (3,20,'tactil',0);
 
INSERT INTO `laboratorio` VALUES (4,70,36),
(5,73,36),
(6,65,32);

/*----------------------- Fin Parte Parcial --------------------------*/

/*----------------------- Inicio Parte Pedido --------------------------*/

CREATE table `departamento` (
	`id_departamento` int not null auto_increment,
    `departamento` varchar(100) not null,
    PRIMARY KEY (`id_departamento`)
);

CREATE table `carrera` (
	`id_carrera` int not null auto_increment,
    `carrera` varchar(100) not null,
    `id_departamento` int not null,
	PRIMARY KEY (`id_carrera`),
	KEY `fk_carrera_idx` (`id_departamento`),
	CONSTRAINT `fk_carrera` FOREIGN KEY (`id_departamento`) 
	REFERENCES `departamento` (`id_departamento`)
);

CREATE table `materia` (
	`id_materia` int not null auto_increment,
	`cod_materia` varchar(10) not null,
    `materia` varchar(75) not null,
    `id_carrera` int not null,
    `profesor` varchar(75) not null,
    PRIMARY KEY (`id_materia`),
    KEY `fk_materia_idx` (`id_carrera`),
    CONSTRAINT `fk_materia` FOREIGN KEY (`id_carrera`)
    REFERENCES `carrera` (`id_carrera`)
);

CREATE table `nota_pedido` (
	`id_nota` int not null auto_increment,
    `fecha` date NOT NULL,
    `turno` char(1) not null,
    `cant_estudiantes` int not null,
    `id_materia` int not null,
    `observaciones` varchar(200),
    `id_aula` int not null,
    PRIMARY KEY (`id_nota`),
	KEY `fk_nota_pedido_idx` (`id_nota`),
    CONSTRAINT `fk_nota_pedido_materia` FOREIGN KEY (`id_materia`)
    REFERENCES `materia` (`id_materia`),
    CONSTRAINT `fk_nota_pedido_aula` FOREIGN KEY (`id_aula`)
    REFERENCES `aula` (`id_aula`)
);

CREATE table `final` (
	`id_final` int not null,
	`fecha_examen` date not null,    
	CONSTRAINT `fk_final_nota_pedido` FOREIGN KEY (`id_final`)
    REFERENCES `nota_pedido` (`id_nota`)
);

CREATE table `curso` (
	`id_curso` int not null,
	`cod_curso` varchar(10) not null,    
	CONSTRAINT `fk_curso_nota_pedido` FOREIGN KEY (`id_curso`)
    REFERENCES `nota_pedido` (`id_nota`)
);

INSERT INTO `departamento` VALUE
 (1, 'Desarrollo Productivo y Tecnologico'),
 (2, 'Departamento de Salud Comunitaria');
 
INSERT INTO `carrera` VALUE
 (1, 'Licenciatura en Sistemas',1),
 (2, 'Nutricion',2);
 
INSERT INTO `materia` VALUES
 (NULL, '8600','Programacion de Computadoras', 1, 'Nicolas Perez'),
 (NULL, '8616','Orientacion a Objetos 2',1, 'Alejandra Vranic, Gustavo Siciliano'),
 (NULL, '8603-4','Matematica 1',1, 'Luis Millan'),
 (NULL, '8603-3','Matematica 1',1, 'Vanesa Plaul'),
 (NULL, '01','Salud Colectiva',2, '');
 
 select * from materia;
 select * from carrera;
 select * from departamento;
 select * from usuario;

/*----------------------- Fin Parte Pedido --------------------------*/


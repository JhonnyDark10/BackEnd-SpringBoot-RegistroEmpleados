# BackEnd-SpringBoot-RegistroEmpleados

- verificar dentro de "src/main/resorce/application.properties"  su configuracion local de base de datos MySQL.

#Data source
#Indica el driver/lib para conectar java a mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#Url donde esta el servicio de tu mysql y el nombre de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/sistemaregistro

#Usuario y contrasena para tu base de datos descrita en la linea anterior
spring.datasource.username=root
spring.datasource.password=12345

#[Opcional]Imprime en tu consola las instrucciones hechas en tu base de datos.
spring.jpa.show-sql = true

#[Opcional]Crea las tablas.
#spring.jpa.hibernate.ddl-auto=create


- cree la base de datos 

create database SistemaRegistro;

CREATE TABLE sis_Usuarios(
	usu_id int auto_increment primary key not null,
	usu_id_pais int not null,
    usu_id_area int not null,
    usu_id_tipo int not null,
    usu_correo varchar(300) null,
	usu_apellido_paterno varchar(20) NOT NULL,
    usu_apellido_materno varchar(20) NOT NULL,
    usu_primer_nombre varchar(20) NOT NULL,
    usu_segundo_nombre varchar(20)  NULL,
    usu_numero_identificacion varchar(20) NOT NULL,
    usu_fecha_ingreso date,
    usu_fecha_edicion date,
    usu_fechahora_registro date,
	usu_estado char(1) NOT NULL
 );
 
 CREATE TABLE sis_Pais(
	pais_id int auto_increment primary key not null,
	pais_descripcion varchar(50) NOT NULL,
	pais_estado char(1) NOT NULL
 );
 
 CREATE TABLE sis_Tipoidentificacion(
	tipo_identificacion_id int auto_increment primary key not null,
	tipo_identificacion_descripcion varchar(50) NOT NULL,
	tipo_identificacion_estado char(1) NOT NULL
 );
 
  CREATE TABLE sis_Area(
	area_id int auto_increment primary key not null,
	area_descripcion varchar(50) NOT NULL,
	area_estado char(1) NOT NULL
 );
 
ALTER TABLE sis_Usuarios ADD FOREIGN KEY(usu_id_pais) 
REFERENCES sis_Pais(pais_id) ON DELETE CASCADE;

ALTER TABLE sis_Usuarios ADD FOREIGN KEY(usu_id_area) 
REFERENCES sis_Area(area_id) ON DELETE CASCADE;

ALTER TABLE sis_Usuarios ADD FOREIGN KEY(usu_id_tipo) 
REFERENCES sis_Tipoidentificacion(tipo_identificacion_id) ON DELETE CASCADE;


insert into sis_Pais(pais_descripcion,pais_estado) values("Colombia","A");
insert into sis_Pais(pais_descripcion,pais_estado) values("EEUU","A");

insert into sis_tipoidentificacion(tipo_identificacion_descripcion,tipo_identificacion_estado) values("Cédula de Ciudadanía","A");
insert into sis_tipoidentificacion(tipo_identificacion_descripcion,tipo_identificacion_estado) values("Cédula de Extranjería","A");
insert into sis_tipoidentificacion(tipo_identificacion_descripcion,tipo_identificacion_estado) values("Pasaporte","A");
insert into sis_tipoidentificacion(tipo_identificacion_descripcion,tipo_identificacion_estado) values("Permiso Especial","A");

insert into sis_Area(area_descripcion,area_estado) values("Administración","A");
insert into sis_Area(area_descripcion,area_estado) values("Financiera","A");
insert into sis_Area(area_descripcion,area_estado) values("Compras","A");
insert into sis_Area(area_descripcion,area_estado) values("Infraestructura","A");
insert into sis_Area(area_descripcion,area_estado) values("Operación","A");
insert into sis_Area(area_descripcion,area_estado) values("Talento Humano","A");
insert into sis_Area(area_descripcion,area_estado) values("Servicios Varios","A");


- Ejecute en la terminal el programa

 ".\mvnw.cmd spring-boot:run"
 
 

# BackEnd-SpringBoot-RegistroEmpleados

Para el proyecto se utilizo la herramienta de desarrollo "Intellij IDEA" y se creo la base del proyecto spring en https://start.spring.io/

- verificar dentro de "src/main/resorce/application.properties"  su configuracion local de base de datos MySQL.

#Data source
#Indica el driver/lib para conectar java a mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#Url donde esta el servicio de tu mysql y el nombre de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/sistemaregistro

#Usuario y contrasena para tu base de datos descrita en la linea anterior
spring.datasource.username=root
spring.datasource.password=123456

- cree la base de datos 

create database SistemaRegistro solicitar el documento al desarrollador;

- Ejecute en la terminal el programa

 ".\mvnw.cmd spring-boot:run"
 
 - verifico en el navegador 
 -  http://localhost:8080/usuario 
 -  http://localhost:8080/tipos 
 -  http://localhost:8080/areas 
 -  http://localhost:8080/paises
 -  apis
 -  http://localhost:8080/swagger-ui.html#/usuario-controller
 
 

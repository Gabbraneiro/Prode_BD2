# TP Final - Base de datos II

### Herramientas instaladas previamente.
- Java JDK 1.8
- Mysql 8 u otro gestor de base de datos.	
- Apache Maven.




### Pasos ejecutar el proyecto:

------------


#### 0. Verificaciones previas
- Variable de entorno de java configurada correctamente. (Agregar al PATH del sistema la carpeta /bin de java sdk)

------------


#### 1. Descarga del proyecto 
	git clone https://github.com/Gabbraneiro/Prode_BD2.git

------------


#### 2. Gestor de base de datos  (en caso de no usar mysql)
- Agregar al archivo **`Prode_BD2/pom.xml`** la/s dependencia/s correspondiente para el uso del gestor.

#### 3. Base de datos
1. Definir un usuario con el cual se conectara a la base de datos.
2. Crear una base de datos.
3. Darle permisos de INSERT, UPDATE, DELETE y SELECT al usuario definido en 1. sobre la base de datos creada en 2.
	
#### 4. Configuración de parámetros del proyecto.
Editar los siguientes parametros del archivo "Prode_BD2/src/main/resources/application.properties".


```yaml
spring.datasource.url = jdbc:{SGBD}://localhost:3306/{nombreBD}?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
#Se debe reemplazar {SGBD} por el gestor de base de datos que se use, en caso de usar mysql no cambiar.
#Se debe reemplazar {nombreBD} por el nombre de la base de datos creada en (3.2).
spring.datasource.username = {usuario}
spring.datasource.password = {contraseña}
#Se debe reemplazar {usuario} por el nombre del usuario creado en (3.1).
#Se debe reemplazar {contraseña} por la contraseña del usuario creado en (3.1).
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.{dialectoBD}
#Se debe reemplazar {dialectoBD} por el dialecto correspondiente al gestor instalado en (2)
```



#### 5. Descarga de dependencias 
Dentro de la carpeta del proyecto se debe ejecutar el siguiente comando.

**`mvn install`**

#### 6. Puesta en marcha del servidor 
Dentro de la carpeta del proyecto se debe ejecutar el siguiente comando.

**`mvn spring-boot:run`**

Una vez realizado estos pasos, ya se puede probar la api localmente en la url localhost:8080
La documentación de la API esta en el archivo [APIDoc](https://github.com/Gabbraneiro/Prode_BD2/edit/master/APIDoc.md "APIDoc") ubicado en la raiz del repositorio.

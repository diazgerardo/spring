# Repository📋
#### En el proyecto trabajaremos con las siguientes entidades en el proyecto de Java, y colecciones en nuestra base de datos:


## 👉Usuario

```bash
    @Id
	private String id;
	
	@Field
	private String username;
	
	@Field
	private String password;
	
	@Field
	private Boolean deleted;
	
	@Field
	private Role role;
```
## 👉Rol
```bash
    @Field
	private String idRole;
	
	@Field
	private String description;
```
## 👉Empleado
```bash
    @Id
	private String id;
	
    @Field
	private String cuil;
	
    @Field
	private String name;
	
    @Field
	private String surname;
	
    @Field
	private Double salary;
	
    @Field
	private Date createdAt;
    
    @Field
	private String position;
```



_Ademas de utilizar los metodos propios de la interfaz MongoRepository, se agregan metodos para filtrar segun ciertos campos._

 
```ruby
@Query(value="{ $or: [ {salary: {$gte:?0, $lt:?1}}, {position: ?2}]}")
```



#### En el proyecto también vamos a trabajar con la clase ModelMapper🛠️ para poder generar los Dto´s necesarios en nuestra capa de negocio o servicio. 


#### Para ejecutar la base mongodb via docker compose debera ser ejecutado:
```bash
D:\Luis\Chapter\Java\springmongodb>docker compose -f src/main/docker/mongodb.yml up -d
```

#### Realizar una post de datos se debera ejecutar
```bash
URL POST:  http://localhost:8080/employees/
{
    "cuil" : "12345678",
    "name" : "nombre2",
    "surname" : "apellido2",
    "salary" : 50,
    "fechaIngreso" : "2020-06-08T20:28:13.390+00:00",
    "position" : "desarrollador"
}
```

#### Realizar un GET que trae todos los empleados
```bash
URL GET:  http://localhost:8080/employees/
RTA Similar
[
    {
        "id": "62a1060ee9658e584e49d2ca",
        "cuil": "12345678",
        "name": "luis",
        "surname": "moyano",
        "salary": 100.0,
        "fechaIngreso": null,
        "position": "lider"
    },
    {
        "id": "62a106605c1669068372a3b6",
        "cuil": "12345678",
        "name": "nombre",
        "surname": "apellido",
        "salary": 50.0,
        "fechaIngreso": "2022-06-08T20:28:13.390+00:00",
        "position": "desarrollador"
    },
    {
        "id": "62a106b6e98c3c62c3fa3bf0",
        "cuil": "12345678",
        "name": "nombre2",
        "surname": "apellido2",
        "salary": 50.0,
        "fechaIngreso": "2020-06-08T20:28:13.390+00:00",
        "position": "desarrollador"
    }
]
```



## 
&emsp;

## Wiki 📖
* Puedes encontrar mucho más de cómo utilizar estas herramientas [ModelMapper](https://www.baeldung.com/java-modelmapper),
[Queries mongo db](https://www.devglan.com/spring-boot/spring-data-mongodb-queries).
##
###
&ensp;

con ❤️ por [Franco Frigerio](https://github.com/FrancoFrigerio) 😊

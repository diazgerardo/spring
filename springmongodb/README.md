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


## 
&emsp;

## Wiki 📖
* Puedes encontrar mucho más de cómo utilizar estas herramientas [ModelMapper](https://www.baeldung.com/java-modelmapper),
[Queries mongo db](https://www.devglan.com/spring-boot/spring-data-mongodb-queries).
##
###
&ensp;

con ❤️ por [Franco Frigerio](https://github.com/FrancoFrigerio) 😊

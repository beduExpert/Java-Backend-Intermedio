## Ejemplo 02: Manejo de errores con Spring

### Objetivos
* Familiarizarnos con el manejo de errores con Spring 

### Prerequisitos
* Maven
* JDK 11
* Postman

### Procedimiento

1. Continuamos con el ejemplo 1
2. Vamos a crear los siguientes paquetes `exceptions` y `services`:
3. En el paquete `exceptions` creamos la clase `RestException` y extendemos de la clase `RuntimeException`
4. Creamos los siguientes constructores con el IDE y heredamos de la clase padre:
```java
    public RestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestException(String message) {
		super(message);
	}
```
5. En el paquete `services` creamos la interfaz `AutorService` y la clase `AutorServiceImpl` y extendemos de la clase `AutorService`
6. Creamos los siguientes metodos en la interfaz `AutorService`:

```java
    Autor saveAutor(Autor autor);
	
	Autor getAutor(Long id) throws RestException;
	
	Autor updateAutor(Autor autor);
	
	void deleteAutor(Long id);
```

7. Implementamos los metodos en la clase clase `AutorServiceImpl`

```java
    @Autowired
	private AutorRepository autorRepository;
	
	@Override
	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Autor getAutor(Long id) throws RestException {
		if(!autorRepository.existsById(id)) {
			throw new RestException("Se requiere un Id existente para obtener el autor.");
		}else {
			return autorRepository.getOne(id);
		}
		
	}

	@Override
	public Autor updateAutor(Autor autor){
		return autorRepository.save(autor);
	}

	@Override
	public void deleteAutor(Long id){
		autorRepository.deleteById(id);
	}
```

8. De esta manera estamos pasando toda la logica a la clase service y el controller `AutorController` solo se dedique a hacer uso de metodos por lo que cambiamos el atributo de `AutorRepository` a `AutorService`:

```java
    @Autowired
	private AutorService autorService;
```

9. Modificamos todos los metodos del controller para que se ocupen los de la interfaz y en el metodo getAutor dejarlo de la siguiente manera:

```java
    @GetMapping("/getAutor/{id}")
	public Autor getAutor(@PathVariable Long id) {
		try {
			return autorService.getAutor(id);
		} catch (RestException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
```
De esta manera estamos cachando el error `RestException` y sobre escribiendo el mensaje que devuelve por defualt Spring y con la ventaja de poder editar el estatus y el mensaje de error.

10. Tambien esta la opción de cachar cualquier excepción que maneja spring data y editar el mensaje error que se devuelve al cliente:
 ```java
    @DeleteMapping("/deleteAutor/{id}")
	public void deleteAutor(@PathVariable Long id) {
		try {
			autorService.deleteAutor(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
```








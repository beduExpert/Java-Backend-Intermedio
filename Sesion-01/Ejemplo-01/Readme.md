## Ejemplo 1: 

### Objetivo
- Indagar en los conceptos de MongoDB (BD NoSQL) y las base de datos no relacionales.
- Conocer las sentencias básicas de MongoDB
- Conocer casos de uso de bases de datos no relacionales, tanto sus ventajas como desventajas.

### Requisitos
- MongoDB instalado
- mongodb compass (Recomendado pero no necesario)

### Desarrollo
* En esta sección se mostrarán algunas sentencias NoSQL y algunos datos importantes para que el alumno comprenda el funcionamiento de las BD no relacionales, específicamente con MongoDB.

Para esta sección se hará uso de un gestor de mongo. En caso que se prefiera utilizar la consola de linea de comandos de la página de mongo, esto será válido ya que el objetivo es conocer la funcionalidad y familiarizarse con los comandos y conceptos de MongoDB. La URL de la interfáz es la siguiente:
https://docs.mongodb.com/manual/tutorial/getting-started/#examples
(Parte del código de esta sección está plasmado aquí, aunque los ejercicios quizá no).

1. Seleccionar una base de datos (Si no existe se creará al insertar un registro)

```javascript
use users;
```
2. Crear un documento:

```javascript
db.users.insertOne({ username: "rosaHdez", email: "rosa.hdez@email.com", Password: "nosegura", createdAt: new Date(), updatedAt: new Date() });

```

3. crear dos documentos simultaneamente:

```javascript
db.users.insertMany(
    [
        { username: "rosaHdez", email: "rosa.hdez@email.com", Password: "nosegura", createdAt: new Date(), updatedAt: new Date() },
        { username: "Ruben123", email: "rubn12.3@email.com", Password: "tampocoEsSegura", createdAt: new Date(), updatedAt: new Date() }
    ]
);
```
4. Seleccionar todos los usuarios (documentos) de la colección (ambas sentencias son equivalentes):

```javascript
db.users.find();
db.users.find({});
```

5. Seleccionar los usuarios cuyo usuario sea "Ruben123":

```javascript
db.users.find({ username: "Ruben123" });
```

6. Seleccionar cuántos usuarios tienen un usuario "Ruben123"

```javascript
db.users.find({ username: "Ruben123" }).count();
```

7. Agregar el campo "age" al primer registro cuyo usuario sea "Ruben123":

```javascript
db.users.updateOne({ _id: db.users.findOne({ username: "Ruben123" })._id }, { $set: { age: 35 } });
```
8. seleccionar todos los usuarios cuyo campo edad sea mayor a 30:
```javascript
db.users.find({ age: { $gt: 30 } } );
```

Para ver los operadores de comparación frecuentes en en las consultas de tipo búsqueda, por ejemplo: mayor que, menor que, etc. vea la siguiente página:
https://docs.mongodb.com/manual/reference/operator/query-comparison/

### un poco más

Dada la siguiente colección:

```javascript
db.inventory.insertMany([
   { item: "journal", qty: 25, status: "A", size: { h: 14, w: 21, uom: "cm" }, tags: [ "blank", "red" ] },
   { item: "notebook", qty: 50, status: "A", size: { h: 8.5, w: 11, uom: "in" }, tags: [ "red", "blank" ] },
   { item: "paper", qty: 10, status: "D", size: { h: 8.5, w: 11, uom: "in" }, tags: [ "red", "blank", "plain" ] },
   { item: "planner", qty: 0, status: "D", size: { h: 22.85, w: 30, uom: "cm" }, tags: [ "blank", "red" ] },
   { item: "postcard", qty: 45, status: "A", size: { h: 10, w: 15.25, uom: "cm" }, tags: [ "blue" ] }
]);
```

- Mostrar los items (documentos) que tengan estatus A, pero solamente si en su tamaño el ancho es menor a 17.

```javascript
db.inventory.find({ status: "A" , "size.w": { $lt: 17 } } );
```

- Mostrar únicamente el nombre del item y el primer tag de los documentos que tengan estatus A y su ancho sea este entre a 15 y 30 incluyendo este último.

```javascript
db.inventory.find({ status: "A" , "size.w": { $lt: 30, $gte: 15 } }, {_id: 0, item: 1, tags: { $slice: 1 } } );
```
En el ejemplo anterior, el segundo parámetro de la consulta muestra los atributos que se quieren retornar con un boleano (recordar que cualquier número diferente a 0 (o -0) se evaluará en verdadero, en este caso size.w y tags se retornarán), sin embargo en tags se usa el operador $slice para retornar solo el primer elemento. Recordar que MongoDB está fuertemente influenciado por JavaScript. el _id se mostrará por defecto, en este ejemplo especificamos que no se desea retornar (algo no recomendado) para cumplir con el objetivo.

Si se tienen conocimientos en este lenguaje a veces es conveniente hacer analogías con la sintaxys y/o el funcionamiento, en este caso con el método slice que se le pude aplicar a los Arrays en JavaScript, lo mismo que la evaluación de los boleanos.

- Eliminar los documentos que tengan tres tags

```javascript
db.inventory.deleteMany({ tags: { $size: 3 } });
```

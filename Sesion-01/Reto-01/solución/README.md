## Solución:

```json
{
    "nombre": "Jorge",
    "apellido": "Gonzales",
    "personasACargo": [{
        "nombre": "Aaron",
        "apellido": "Sotelo",
        "cargo": "Ing. en comp.",
        "edad": 25,
        "personasACargo": [{
            "nombre": "Rosa",
            "apellido": "Soto",
            "edad": 30
        }]
    }],
    "cargo": "Gerente de sistemas"
}
```

1. Explicar por qué esta colección está correctamente estructurada teniendo en cuenta los campos `personasACargo` las dos veces que aparece y su estructura:

``` 
En las bases de datos no relacionales la estructura no es rígida, los campos pueden variar y ser dinámicos conforme se requiera. MongoDB es una base de datos orientada a documentos y su estructura no debe ser siempre la misma en estos. Por lo tanto, esta estructura aunque no tenga los mismos campos que aparentemente deberían ser similares (en una base de datos relacional), en este caso no es así. Es importante tener en cuenta que no estamos limitados por la estructura de los documentos en una primera instancia.
```

2. Escriba una consulta que inserte un documento con un `cargo: "Director comercial"` con al menos dos personas a cargo:

```json
# La estructura podría ser diferente, sin embargo se debe tener la instrucción de inserción con un documento dentro con al menos un campo `cargo` y un array `personasACargo` con al menos dos documentos. (Los campos añadidos son opcionales y válidos):

db.empleados.insertOne({
    "nombre": "Rogelio",
    "apellido": "Miramontes",
    "personasACargo": [
        {
            "nombre": "Aaron",
            "cargo": "empleado 1",
        },
        {
            "nombre": "Rosa",
            "apellido": "Soto",
            "edad": 30
        }
    ],
    "cargo": "Director comercial"
});
```

3. Escriba una consulta que arroje las personas a cargo mayores de 30 años del gerente Jorge Gonzales:

```json
db.empleados.find({ "nombre": "Jorge", "apellido": "Gonzales", "personasACargo.edad": { $gt: 18 } }, { "_id": 0, "personasACargo": 1 });
```
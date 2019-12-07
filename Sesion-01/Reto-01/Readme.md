## Reto 1: 

### Objetivo
- Comprobar conocimiento en sentencias Mongo
- Aplicar conceptos teoricos y mejorar la comprensión del funcionamiento de MongoDB.

### Requisitos
- MongoDB instalado
- mongodb compass (Recomendado pero no necesario)

### Desarrollo

Teniendo en cuenta la siguiente colección llamada `empleados`:

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

1. Explicar por qué esta colección está correctamente estructurada teniendo en cuenta los campos `personasACargo` las dos veces que aparece y su estructura.

2. Escriba una consulta que inserte un documento con un `cargo: "Director comercial"` con al menos dos personas a cargo.

3. Escriba una consulta que arroje las personas a cargo mayores de 30 años del gerente Jorge Gonzales.

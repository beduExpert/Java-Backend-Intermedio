## Reto 3: 

### Objetivo
- Reafirmar conocimientos del Ejemplo03
- Personalizar las búsquedas a nivel sentencia MongoDB desde Spring Data MongoDB
- Explorar algunas posibilidades del ORM.

### Requisitos
- MongoDB instalado
- JDK 8 o superior
- IDE de tu preferencia
- mongodb compass (Recomendado pero no necesario)

### Desarrollo

A partir del proyecto ejemplo03 realice lo siguiente:

1. Inspecciona la clase MongoTemplate (desde el IDE o documentación) si lo requieres.
2. comprende los métodos MongoTemplate#find y MongoTemplate#findOne
- - Para los atributos de estas clases puedes utilizar e importar las siguientes clases de esta manera:
```
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
```
3. Reemplaza en la clase principal (Ejemplo03Application) el uso de los repositorios y en su lugar haz uso de la clase MongoTemplate y los métodos que acabas de aprender (unicamente deberían cambiar 3 líneas).

4. verifica que el proyecto funcione igual que en el ejemplo03

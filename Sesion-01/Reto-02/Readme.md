## Reto 2: 

### Objetivo
- Confirmar conocimientos Spring Data
- Aplicar conocimientos previos y visualizar los resultados en MongoDB

### Requisitos
- MongoDB instalado
- JDK 8 o superior
- IDE de tu preferencia
- mongodb compass (Recomendado pero no necesario)

### Desarrollo

Continuar desde el ejemplo02.

En muchas aplicaciones de la vida real hay registros de usuarios y un `login` por lo que hacer una búsqueda de usuarios dado un usuario y/o email es muy frecuente.

1. Con base a conocimientos previos en Spring Data crea dos métodos en el repositorio `UserRepository` para obtener `un` usuario. El primer método que lo obtenga dado el nombre de usuario y el segundo dado el email. (En este caso se omite el password por cuestiones de seguridad dependiente en un proyecto específico, p.ej encriptamiento, etc. y eso ya no corresponde al curso.)

2. Comprueba en la clase principal del proyecto, remueve el código anterior de la implementación del método run de la interfaz CommandLineRunner y ahora comprueba en este que tus métodos funcionen correctamente. Para esto Guarda dos registros con el mismo Email y verifica que solo uno es recuperado al hacer la búsqueda por email. (Existen opciones mejores, pero este ejemplo es solo con fines educativos).

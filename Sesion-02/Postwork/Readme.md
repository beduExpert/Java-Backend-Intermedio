## Postwork Sesión 02:

A lo largo de este proyecto reafirmaremos lo que se ha aprendido durante las sesiones.

### Módulo 2 - Consumo REST-SOAP

Continuamos con el postwork de la sesion 1

Ahora lo que haremos es consumir un servicio para llenar el documento de Pacientes (Patient). Entramos a la siguiente URL https://www.mocky.io/ ,en la cual agregaremos el siguiente cuerpo:

```json

[
    {
        "name": "Alfredo",
        "lastname": "Hernandez",
        "birthday": "1990-02-15",
        "stature": 173,
        "weigth": 72
    },
    {
        "name": "Luis",
        "lastname": "Hernandez",
        "birthday": "1990-02-15",
        "stature": 183,
        "weigth": 82
    },
    {
        "name": "David",
        "lastname": "Hernandez",
        "birthday": "1990-02-15",
        "stature": 163,
        "weigth": 65
    },
    {
        "name": "Anabel",
        "lastname": "Hernandez",
        "birthday": "1990-02-15",
        "stature": 163,
        "weigth": 60
    },
    {
        "name": "Viridiana",
        "lastname": "Hernandez",
        "birthday": "1990-02-15",
        "stature": 173,
        "weigth": 72
    },
    {
        "name": "Carolina",
        "lastname": "Hernandez",
        "birthday": "1990-02-15",
        "stature": 180,
        "weigth": 75
    }

]
```
Damos click en Generate my HTTP Response y arriba nos aparecera el link que ocuparemos.

Deberan crear un servicio que haga el trabajo del mapping y guardado de los pacientes que devuelve el JSON, llamar el metodo en su clase principal (metodo run) 


## Postwok Sesión 1: 

### Objetivo

- Afirmar conocimientos de `Bases de datos no relacionales`
- Afirmar conocimientos MongoDB
- Afirmar conocimientos Spring Data MongoDB

### Requisitos

- MongoDB instalado
- mongodb compass (Recomendado pero no necesario)
- DJK8+
- IDE de preferencia (Se recomienda IntelliJ o STS4 )

### Desarrollo

Un hospital requiere un pequeño sistema para generar recetas. Por ahora solo se requiere que estas se guarden, pero posteriormente se piensa generar un módulo de reportes.

Analice con cuidado el siguiente Documento Mongo correspondiente a  una receta (documento llamado `prescription` ) expedida por un médico, cree las entidades (documentos) y repositorios con Spring Data MongoDB para poder replicarla (los _id pueden cambiar por obvias razones), intente hacer algunas validaciones en los documentos (`javax.validation.constraints`) de acuerdo a reglas de negocio que usted crea convenientes:

```json
{
    "_id": "5dfa9c2afcdb5c43fe9394c5",
    "doctor": {
        "_id": "5dfa9c2afcdb5c43fe9394c0",
        "name": "Diana Laura",
        "lastname": "García",
        "birthday": "1995-09-12T06:00:00.000Z",
        "specialized": false,
        "yearsExperience": 1
    },
    "patient": {
        "_id": "5dfa9c2afcdb5c43fe9394c1",
        "name": "Alfredo",
        "lastname": "Hernandez",
        "birthday": "1990-02-15T06:00:00.000Z",
        "stature": 163,
        "weigth": 172
    },
    "createdAt": "2019-12-18T21:37:46.808Z",
    "diseases": [
        {
            "_id": "5dfa9c2afcdb5c43fe9394c2",
            "name": "Flu",
            "causes": [
                "Human contact"
            ],
            "symptoms": [
                "cough",
                "distemper"
            ],
            "signs": [
                "distemper",
                "redness of the area around the eyes"
            ]
        }
    ],
    "medicationDetails": [
        {
            "_id": "5dfa9c2afcdb5c43fe9394c4",
            "medicament": {
                "_id": "5dfa9c2afcdb5c43fe9394c3",
                "name": "paracetamol",
                "quantity": "100 mg =1ml = 25 drops",
                "expirationDate": "2025-02-10T06:00:00.000Z"
            },
            "Days": 7,
            "timeIntervals": 8,
            "quantity": "5 drops"
        }
    ],
    "_class": "org.bedu.postworksone.documents.Prescription"
}
```

2. Replique el documento anterior desde Spring (Puede utilizar pruebas unitarias o la interfaz `CommandLineRunner`)

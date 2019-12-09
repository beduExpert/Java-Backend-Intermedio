## Ejemplo 01: Instalación y uso básico de Apache Kafka

### Objetivo
1. Instalar Apache Kafka y hacer un ejemplo sencillo

### Procedimiento

**Nota** Estas instrucciones de instalación són aptas sólo para ambientes de desarrollo y demostrativos.

#### Descargar Apache Kafka
2. Descarga el archivo [kafka_2.11-2.3.1.tgz](https://www-us.apache.org/dist/kafka/2.3.1/kafka_2.11-2.3.1.tgz) (Si falla el link puedes buscarlo en el [sitio oficial](https://kafka.apache.org/downloads)).
3. Descomprime el archivo para tener la siguiente estructura
```bash
    kafka_2.12-2.3.1
    ├── bin
    ├── config
    ├── libs
    ├── LICENSE
    ├── logs
    ├── NOTICE
    └── site-docs
```

#### Iniciar Zookeeper y Apache Kafka

Apache Kafka hace uso de Zookeeper para matener la sincronizcación y la alta disponibilidad. Si se tiene instalado y configurado este sistema se recomienda usarlo. Pero para este ejemplo podemos usar el que está incluído.

4. A partir del directorio descomprimido ejecuta:
```bash
   bin/zookeeper-server-start.sh config/zookeeper.propertie
```
5. Con Zookeeper iniciado, desde otra consola ejecuta:
```bash
   bin/kafka-server-start.sh config/server.properties
```

#### Crear un tópico

Para poder hacer el intercambio de mensajes es necesario crear un tópico, de lo contario el sistema fallará al publicar un mensaje por no existir la cola correspondiente.

6. Para crear un tópico llamado _bedu-msg_ ejecuta desde una nueva consola la instrucción
```bash
   bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic bedu-msg
```

En este ejemplo estamos creando una única partición y una única copia de nuestra cola de mensajes.

#### Conectar un productor

7. Ejecuta el comando:
```bash
   bin/kafka-console-producer.sh --broker-list localhost:9092 --topic bedu-msg
```

El puerto 9092 está configurado en el archivo config/server.properties

Al ejecutarlo tendrás el prompt _>_

Puedes comenzar a escribir mensajes. Cada nueva línea inicia un mensaje nuevo.

#### Conectar un consumidor

8. En una nueva consola ejecuta el comando:
```bash
   bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic bedu-msg --from-beginning
```

Gracias a la opción _--from-beginning_ nuestra consola recibe el acumulado de todos los mensajes que se han enviado a ese tópico. Si queremos recibir sólo los que se generen luego de la conexión, omitimos esa instrucción.

#### Comunicación en tiempo real

9. Desde la consola del productor escribe un nuevo mensaje y verás cómo se refleja inmediatamente en la consola del consumidor.


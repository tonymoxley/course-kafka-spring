## Spring Boot - course kafka with spring
Proyecto de spring basico para configurar Apache Kafka y entender los fundamentos de kafka (consumer, producer, cluster partitions, etc).

### Dependencias maven
Se debe crear un proyecto spring boot, utilizando cualquier version del starter parent que este entre la v2.0.0 y v2.7.8,
y se debe agregar la siguiente dependencia de Apache kafka:
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```
### Configuraciones
#### Apache kafka - consumer
Para configurar el consumer y conectarse al host de kafka, se debera editar la siguiente clase 
de configuración:
```java
@Configuration
public class ApacheKafkaConfig {
    
    public Map<String, Object> consumerProperties() {
        final Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "devs4j-group");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    }
}
```
##### Nota: solo se debera editar el BOOTSTRAP_SERVERS_CONFIG y GROUP_ID_CONFIG
### Ejecución de kafka con docker
Ejecutar apache kafka desde docker desktop o desde la terminal, posterior a esto ejecutar el siguiente comando 
para entrar al shell de kafka:
```shell
docker exec -it kafka /bin/sh
```
Al ingresar al shell se navegara hacia la carpeta de la version de kafka instalado-> bin/opt/kafka_x.xx-x.x.x
, y se ejecutara el siguiente comando para crear el topic:
```shell
bin/kafka-topics.sh --bootstrap-server  localhost:9092 --create --topic devs4j-topic --partitions 5 --replication-factor 1
```
Para listar los topics creados se utiliza el siguiente comando:
```shell
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```
Para ejecutar el producer desde consola y mandar mensajes al topic creado ejecutar:
```shell
bin/kafka-console-producer.sh --topic devs4j-topic --bootstrap-server localhost:9092
```
Para ejecutar un consumer desde consola y recibir los mensajes del topic creado ejecutar:
```shell
bin/kafka-console-consumer.sh --topic devs4j-topic --from-beginning --bootstrap-server localhost:9092
```
### Ejecución del proyecto
Si todo compila correctamente, seleccionar el proyecto desde el IDE hacer clic secundario > ejecutar como proyecto spring boot,
o mediante la terminal-> navegar hacia la carpeta del proyecto y ejecutar el comando:
```shell
mvn spring-boot:run
```
### :hammer_and_wrench: Languages and Tools :
<div>
<img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original-wordmark.svg" title="Spring" alt="Spring" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/apachekafka/apachekafka-original-wordmark.svg" title="Kafka" alt="Kafka" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/git/git-plain.svg" title="Spring" alt="Git" width="40" height="40"/>&nbsp;
</div>
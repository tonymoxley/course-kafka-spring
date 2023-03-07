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
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "topic-demo-group");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    }
}
```
##### Nota: solo se debera editar el BOOTSTRAP_SERVERS_CONFIG y GROUP_ID_CONFIG

### :hammer_and_wrench: Languages and Tools :
<div>
<img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original-wordmark.svg" title="Spring" alt="Spring" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/apachekafka/apachekafka-original-wordmark.svg" title="Kafka" alt="Kafka" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/git/git-plain.svg" title="Spring" alt="Git" width="40" height="40"/>&nbsp;
</div>
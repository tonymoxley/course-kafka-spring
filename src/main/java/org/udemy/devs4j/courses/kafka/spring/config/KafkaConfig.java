package org.udemy.devs4j.courses.kafka.spring.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase configura el consumer de kafka para leer los mensajes del topic, al igual que se configura el producer de kafka
 * encargado de mandar los mensajes al topic.
 *
 * @author  Ing. Jose Antonio Hernández
 * @version 1.0
 */
@Configuration
public class KafkaConfig {

    /**
     * Este método crea un hash map con las configuraciones del consumer que se utilizará para leer los mensajes de kafka
     * por medio del host, puerto y topic de kafka a consumir.
     * @return un {@link Map} de las configuraciones del host de kafka
     */
    public Map<String, Object> consumerProperties() {
        final Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "devs4j-group");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return properties;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProperties());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory() {
        final ConcurrentKafkaListenerContainerFactory<String, String>
                listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(consumerFactory());
        return listenerContainerFactory;
    }

}

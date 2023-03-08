package org.udemy.devs4j.courses.kafka.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Proyecto Spring boot para aprender a crear y configurar un proyecto que utilice apache kafka, para producir y consumir mensajes.
 *
 * @author Ing. Jose Antonio Hernández
 * @version 1.0
 */
@Slf4j
@SpringBootApplication
public class CourseKafkaSpringApplication {

	/**
	 * Este método se utiliza para interceptar y leer los mensajes enviados por un producer de kafka. {@link KafkaListener}
	 * @param message valor enviado al topic de kafka
	 */
	@KafkaListener(topics = "devs4j-topic", groupId = "devs4j-group")
	public void listen(final String message) {
		log.info("message received: {}", message);
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseKafkaSpringApplication.class, args);
	}

}

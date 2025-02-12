package com.gajula;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude= { HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class, KafkaAutoConfiguration.class})
@EnableScheduling
@OpenAPIDefinition
//@EnableKafka
public class Main extends SpringBootServletInitializer {

	private final static Logger admin = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws Exception{
		try{
			admin.info("Spring Boot Main Start");
			System.setProperty("spring.devtools.restart.enabled", "false");
			SpringApplication.run(Main.class, args);
			admin.info("Spring Boot Main End");
		}catch (Exception e){
			e.printStackTrace();
			admin.error("Spring Boot Main error "+e.getMessage());
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}
}
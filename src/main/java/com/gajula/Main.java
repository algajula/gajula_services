package com.gajula;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude= { HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class, KafkaAutoConfiguration.class})
@EnableScheduling
//@EnableKafka
public class Main {

	private final static Logger admin = LogManager.getLogger("admin");

	public static void main(String[] args) throws Exception{
		try{
			admin.info("Spring Boot Main Start");
			SpringApplication.run(Main.class, args);
			admin.info("Spring Boot Main End");
		}catch (Exception e){
			admin.error("Spring Boot Main error "+e.getMessage());
		}
	}
}
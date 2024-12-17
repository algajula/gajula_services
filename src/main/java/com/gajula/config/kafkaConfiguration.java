package com.gajula.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConfiguration {

	private final static Logger admin = LogManager.getLogger("admin");

	@Value("${train.kafka.consumer.bootstrap-servers}")
	private String bootstrapServers;
	@Value("${train.kafka.consumer.group-id}")
	private String groupId;
	@Value("${train.kafka.consumer.pollTimeout}")
	private int pollTimeout;
	@Value("${train.kafka.consumer.maxPartitionFetchBytes}")
	private int maxPartitionFetchBytes;
	@Value("${train.kafka.consumer.auto-offset-reset}")
	public String AUTO_OFFSET_RESET_CONFIG_EARLIEST;
	@Value("${train.kafka.producer.keyvalue-serializer}")
	public String keyValueSerializer;
	@Value("${train.kafka.consumer.keyvalue-deserializer}")
	public String keyValueDeserializer;

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keyValueSerializer);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, keyValueSerializer);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "GajulaClient");
		admin.info("Created producer factory");
		return new DefaultKafkaProducerFactory<>(props);
	}

	public Map<String, Object> getConsumerFactoryProperties() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyValueDeserializer);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, keyValueDeserializer);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AUTO_OFFSET_RESET_CONFIG_EARLIEST);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, maxPartitionFetchBytes);
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "300000");
		return props;
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		admin.info("Creating kafka template");
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean(name = "customerConsumerFactory")
	public ConsumerFactory<String, String> customerConsumerFactory() {
		Map<String, Object> props = getConsumerFactoryProperties();
		admin.info("Customer Consumer factory created ");
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean(name = "customerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, String> customerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(customerConsumerFactory());
		factory.getContainerProperties().setPollTimeout(pollTimeout);
		factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
		admin.info("=====Customer Factory==========");
		return factory;
	}

	@Bean(name = "bookConsumerFactory")
	public ConsumerFactory<String, String> bookConsumerFactory() {
		Map<String, Object> props = getConsumerFactoryProperties();
		admin.info("Book Consumer factory created ");
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean(name = "bookFactory")
	public ConcurrentKafkaListenerContainerFactory<String, String> bookFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(bookConsumerFactory());
		factory.getContainerProperties().setPollTimeout(pollTimeout);
		factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
		admin.info("=====Book Factory==========");
		return factory;
	}

}

package com.nigam.home.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LogEventKafkaProducer {
	
	@Autowired
	private KafkaProducer<String, String> logEventProducer;
	
	private static final Logger logger = LoggerFactory.getLogger(LogEventKafkaProducer.class);
	
	public void send(String topic, String appName, String payload) {
		logger.info("Sending Kafka Message: " + payload + ", to topic=" + topic);
		this.logEventProducer.send(new ProducerRecord<String, String>(topic, appName, payload));
	}

}

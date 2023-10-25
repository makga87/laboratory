package com.example.springkafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ReserveProducerAsync {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:29092,localhost:39092,localhost:49092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		try {
			for (int i = 0; i < 3; i++) {
				ProducerRecord<String, String> record = new ProducerRecord<>("reserve", "Apache Kafka Is a distributed streaming platform -" + i);
				producer.send(record, new ReserveProducerCallback(record));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}

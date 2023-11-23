
package com.example.springkafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ReserveConsumerAsync {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", "10.162.5.66:9092, 10.162.5.66:9093, 10.162.5.66:9094");
		props.put("group.id", "kafka-tx-test-consumer-01");
		props.put("enable.auto.commit", "false");
		props.put("auto.offset.reset", "latest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		Consumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("transaction-topic"));

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
				for (ConsumerRecord<String, String> record : records) {
					System.out.printf("#### Topic: %s , Partition: %d, Offset: %d, Key: %s, Received Message: %s\n",
									  record.topic(), record.partition(), record.offset(), record.key(), record.value());
				}

				consumer.commitAsync();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}
}


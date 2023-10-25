package com.example.springkafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReserveProducerCallback implements Callback {

	private ProducerRecord<String, String> record;

	@Override
	public void onCompletion(RecordMetadata metadata, Exception e) {
		if (e != null) {
			e.printStackTrace();
		} else {
			System.out.printf("#### Topic: %s , Partition: %d, Offset: %d, Key: %s, Received Message: %s\n",
							  metadata.topic(), metadata.partition(), metadata.offset(), record.key(), record.value());
		}
	}
}

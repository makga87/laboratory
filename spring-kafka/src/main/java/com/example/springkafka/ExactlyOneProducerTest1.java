package com.example.springkafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ExactlyOneProducerTest1 {

	public static void main(String[] args) {

		String bootstrapservers = "10.162.5.66:9092, 10.162.5.66:9093, 10.162.5.66:9094";

		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapservers);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true"); // 중복없는 전송을 위한 설정
		props.setProperty(ProducerConfig.ACKS_CONFIG, "all"); // 중복없는 전송을 위한 필수 설정
		props.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5"); // ACK를 받지 않은 상태에서 하나의 커넥션에서 보낼 수 있는 최대 요청 수
		props.setProperty(ProducerConfig.RETRIES_CONFIG, "5");
		props.setProperty(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "Lee-Dong-Hee");
		props.setProperty(ProducerConfig.LINGER_MS_CONFIG, "5000"); // 버퍼에 담아두다가 지정된 시간이 지나면 자동으로 flush

		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		producer.initTransactions(); // transaction topic 이 EMPTY상태, epoch가 +1 된다.
		producer.beginTransaction();

		try {

			for (int i = 0; i < 1; i++) {
				ProducerRecord<String, String> record = new ProducerRecord<>("transaction-topic",
																			 "Hello Kafka TX - " + i);
				producer.send(record);

				System.out.println("Message sent successfully");

				producer.flush(); // transaction topic 이 ONGOING
			}


		} catch (Exception e) {
			producer.abortTransaction(); // transaction topic abort 값 이 COMPLETE ABORT
			e.printStackTrace();
		} finally {
			producer.commitTransaction(); // transaction topic 이 COMPLETE
			producer.close();
		}
	}
}

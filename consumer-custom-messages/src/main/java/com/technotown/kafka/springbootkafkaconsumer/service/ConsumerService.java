package com.technotown.kafka.springbootkafkaconsumer.service;

import com.technotown.kafka.springbootkafkaconsumer.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "location-topic", groupId = "location-group-id", concurrency = "3")
    public void listen(ConsumerRecord<String,Location> message) {
        log.info("Key: {} | Value: {}", message.key(), message.value());
        log.info("Partition: {} | Offset: {}", message.partition(), message.offset());
    }
}

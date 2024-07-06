package com.techno.kafka.producerdemo.service;

import ch.qos.logback.core.util.FixedDelay;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    //generateRandomTransaction
    public String generateRandomTransaction(){
        String vendors[]={"Amazon","Paypal","Visa","mastercard"};
        String vendor= vendors[ThreadLocalRandom.current().nextInt(vendors.length)];
        double amount = ThreadLocalRandom.current().nextDouble(0.10,1000.0);
        return "Vendor: "+vendor+"Amount $"+amount;
    }

    //SendPaymentTransactions Asynchronously
   // @Scheduled(fixedRate = 2000)
    public void SendPaymentTransactionsAsynchronously(){
        String transaction= generateRandomTransaction();
        log.info("Sending payment transactions {}",transaction);
        kafkaTemplate.send("payment-topic",transaction)
                .whenComplete(((sendResult, throwable) -> {
                    if(throwable!=null){
                        onFailure(throwable);
                    }else {
                        onSuccess(sendResult);
                    }
                }));

    }

    private void onSuccess(SendResult<String, String> sendResult) {
        log.info("Received new metadata. \n" +
                        "Topic: {}, Partition: {}, Offset: {}, Timestamp: {}",
                sendResult.getRecordMetadata().topic(),
                sendResult.getRecordMetadata().partition(),
                sendResult.getRecordMetadata().offset(),
                sendResult.getRecordMetadata().timestamp());
    }

    private void onFailure(Throwable throwable) {
        log.info("Error occurred while producing the message {}", throwable);
    }

    public String generateTransactionKey(){
        return UUID.randomUUID().toString();
    }


    //SendPaymentTransactions-2)synchronously

    @Scheduled(fixedRate = 2000)
    public SendResult<String,String> SendPaymentTransactionsSynchronously() throws ExecutionException, InterruptedException {
        String transaction= generateRandomTransaction();
        log.info("Sending payment transactions {}",transaction);
       SendResult<String,String> sendResult = kafkaTemplate.send("payment-topic",generateTransactionKey(),transaction).get();
        log.info("Received new metadata. \n" +
                        "Topic: {}, Partition: {}, Offset: {}, Timestamp: {}",
                sendResult.getRecordMetadata().topic(),
                sendResult.getRecordMetadata().partition(),
                sendResult.getRecordMetadata().offset(),
                sendResult.getRecordMetadata().timestamp());
        return sendResult;
    }
}

package com.mhv.springkafka.kafkaUtility;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "new-item-available",
            groupId = "mhv"
    )
    void listener(String data){
        System.out.println("Consumed : " + data + " 🥳");
    }
}

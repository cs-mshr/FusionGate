package com.paynav.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListner {

    @KafkaListener(topics = "FirstTopic", groupId = "first-group")
    public void listenToCodeDecodeKafkaTopic(String messageReceived) {
        System.out.println("Message received is " + messageReceived);
    }

}
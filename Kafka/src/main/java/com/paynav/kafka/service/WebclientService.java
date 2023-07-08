package com.paynav.kafka.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service  @RequiredArgsConstructor
public class WebclientService {

    private final WebClient webClient;
    private final KafkaProducer kafkaProducer;

    public void makeApiRequest() {
        String key = "JEnhDf";
        String command = "get_Transaction_Details";
        String var1 = "2022-08-05";
        String var2 = "2022-08-06";
        String hash = "eb76c2a2ae354161808d39d45e2c333434302d6185aa55f9605074e32deb9468cab2451a70c581eddcbd183415d877032e5ddc0ac8b5c2c225c17d7cc6a327c5";

        webClient.post()
                .body(BodyInserters.fromFormData("key", key)
                        .with("command", command)
                        .with("var1", var1)
                        .with("var2", var2)
                        .with("hash", hash))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(kafkaProducer::sendMessageToTopic);
    }
}

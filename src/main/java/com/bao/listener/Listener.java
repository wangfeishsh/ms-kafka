package com.bao.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by user on 16/10/11.
 */
@Component
public class Listener {
    private final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "topic1",group = "siTestGroup")
    public void listen1(String foo) {
        System.out.println("======"+foo);
        this.latch1.countDown();
    }
}

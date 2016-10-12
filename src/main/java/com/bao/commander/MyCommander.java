package com.bao.commander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by user on 16/10/11.
 */
@Component
public class MyCommander implements CommandLineRunner {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Override
    public void run(String... strings) throws Exception {
        StopWatch stopWatch = new StopWatch("monitor");
        stopWatch.start("first");
        kafkaTemplate.setDefaultTopic("topic1");
        kafkaTemplate.sendDefault("0", "foo");
        kafkaTemplate.sendDefault("2", "bar");
        kafkaTemplate.sendDefault("0", "baz");
        kafkaTemplate.sendDefault("2", "qux");
        kafkaTemplate.flush();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}

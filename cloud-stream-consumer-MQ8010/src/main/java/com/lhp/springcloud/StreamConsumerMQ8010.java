package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Amumu
 * @create 2021/5/11 23:36
 */
@EnableBinding
@SpringBootApplication
public class StreamConsumerMQ8010 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMQ8010.class);
    }
}

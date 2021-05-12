package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Amumu
 * @create 2021/4/27 21:30
 */
@EnableBinding
@SpringBootApplication
public class MQProvider8008 {

    public static void main(String[] args) {
        SpringApplication.run(MQProvider8008.class);
    }
}

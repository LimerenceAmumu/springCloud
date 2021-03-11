package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Amumu
 * @create 2021/3/11 20:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006Application.class,args);
    }
}

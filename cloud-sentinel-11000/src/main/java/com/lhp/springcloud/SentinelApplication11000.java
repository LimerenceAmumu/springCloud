package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @author: lihp
 * @date: 2022/2/23 10:42
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelApplication11000 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication11000.class, args);
    }

}

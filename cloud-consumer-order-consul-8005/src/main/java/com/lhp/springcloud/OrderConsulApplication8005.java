package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Amumu
 * @create 2021/3/11 20:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulApplication8005 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication8005.class,args);
    }
}

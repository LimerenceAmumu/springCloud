package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Amumu
 * @create 2021/3/13 19:58
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignApplication80.class,args);
    }
}

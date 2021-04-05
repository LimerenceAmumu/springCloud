package com.lhp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Amumu
 * @create 2021/4/4 8:37
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderOpenfeignHytrixApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignHytrixApplication80.class,args);
    }
}

package com.lhp.springcloud ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Amumu
 * @create 2021/3/1 21:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lhp.springcloud.dao")
@EnableEurekaClient
public class PaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class,args);
    }
}

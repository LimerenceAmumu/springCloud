package com.lhp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Amumu
 * @create 2021/3/3 19:43
 */
@Configuration
public class MainConfig {
    @Bean
    @LoadBalanced  //为了测试自己的LB 而注释
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

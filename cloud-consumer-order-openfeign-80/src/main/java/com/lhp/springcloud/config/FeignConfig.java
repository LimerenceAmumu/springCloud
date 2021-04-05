package com.lhp.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Amumu
 * @create 2021/3/31 20:50
 */
@Configuration
public class FeignConfig {
    /**
     * feign 的日志级别
     * @return
     */
    @Bean
    Logger.Level feignLogLevle(){
        return Logger.Level.FULL;
    }
}

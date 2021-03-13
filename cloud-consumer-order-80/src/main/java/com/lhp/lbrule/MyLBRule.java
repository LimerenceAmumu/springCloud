package com.lhp.lbrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Amumu
 * @create 2021/3/11 22:35
 */
@Configuration
public class MyLBRule {
    @Bean
    public IRule rule(){
        return new RandomRule();
    }

}

package com.lhp.springcloud.rest;

import com.lhp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Amumu
 * @create 2021/4/3 9:01
 */
@Slf4j
@RestController
public class PaymentRest {
    @Value("${server.port}")
    private Integer port;
    @Resource
    PaymentService paymentService;
    @RequestMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        String s = paymentService.paymentService_ok(id);
        log.info(s);
        return s+port;
    }
    /**
     * 也可以正常返回
     * @param seconds
     * @return
     */
    @RequestMapping("/hystrix/timeout/{seconds}")
    public String timeout(@PathVariable("seconds") Integer seconds){
        String s = paymentService.paymentService_timeout(seconds);
        log.info(s);
        return s+port;
    }

    @RequestMapping("/hystrix/clientFallback/{seconds}")
    public String clientFallback(@PathVariable("seconds") Integer seconds){
        String s = paymentService.clientFallback(seconds);
        log.info(s);
        return s+port;
    }


    //=============服务熔断======================circuitBreaker

    /**
     * 测试 服务   熔断  先压力测试 错误的 即 a《0  故意制造许多错误，然后就会出现  当输入的的a 》0  时 也会出错 显示服务熔断，过一会又恢复
     * @param a
     * @return
     */
    @RequestMapping("/hystrix/circuitBreaker/{a}")
    public String circuitBreaker(@PathVariable("a") Integer a){
        String s = paymentService.circuitBreaker(a);
        log.info(s);
        return s;
    }
}

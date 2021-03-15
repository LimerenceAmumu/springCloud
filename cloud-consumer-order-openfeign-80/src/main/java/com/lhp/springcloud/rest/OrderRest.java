package com.lhp.springcloud.rest;

import com.lhp.springcloud.feignService.PaymentService;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Amumu
 * @create 2021/3/11 20:32
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderRest {
    @Resource
    PaymentService paymentService;
    @RequestMapping("/feign")
    public CommonResult demo(){
        return paymentService.feign();
    }


    /**
     * 测试超时时间
     * @return
     */
    @RequestMapping("/feignLongTime")
    public CommonResult feignLongTime(){
        return paymentService.feignLongTime();
    }

}
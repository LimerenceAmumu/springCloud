package com.lhp.springcloud.rest;

import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public static final String PROVIDER_PAYMENT="http://cloud-provider-payment-consul";
    @Resource
    RestTemplate restTemplate;
    @RequestMapping("/consul")
    public CommonResult demo(){
        return restTemplate.getForObject(PROVIDER_PAYMENT+"/payment/payment/consul",CommonResult.class);
    }



}
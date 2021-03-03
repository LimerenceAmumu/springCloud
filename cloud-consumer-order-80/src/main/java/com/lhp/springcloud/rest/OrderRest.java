package com.lhp.springcloud.rest;

import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Amumu
 * @create 2021/3/3 19:44
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderRest {
    public static final String PROVIDER_PAYMENT="http://127.0.0.1:8001/payment";
    @Resource
    RestTemplate restTemplate;
    @RequestMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        return restTemplate.postForObject(PROVIDER_PAYMENT+"/add",payment,CommonResult.class);
    }

    @RequestMapping("/get/{id}")
    public CommonResult add(@PathVariable Long id){
        return restTemplate.getForObject(PROVIDER_PAYMENT+"/get/"+id,CommonResult.class);

    }

}

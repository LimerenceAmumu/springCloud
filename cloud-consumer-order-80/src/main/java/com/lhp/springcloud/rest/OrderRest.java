package com.lhp.springcloud.rest;

import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.lb.MyLB;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Amumu
 * @create 2021/3/3 19:44
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderRest {
    public static final String PROVIDER_PAYMENT="http://CLOUD-PROVIDER-PAYMENT";
    @Resource
    RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    MyLB myLB;
    @RequestMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        return restTemplate.postForObject(PROVIDER_PAYMENT+"/payment/add",payment,CommonResult.class);
    }

    @RequestMapping("/get/{id}")//CLOUD-PROVIDER-PAYMENT
    public CommonResult get(@PathVariable Long id){
        return restTemplate.getForObject(PROVIDER_PAYMENT+"/payment/get/"+id,CommonResult.class);

    }
    @RequestMapping("lb")
    public CommonResult lb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        ServiceInstance instance = myLB.instance(instances);
        return new CommonResult(200,"success",instance.getPort());
    }

}

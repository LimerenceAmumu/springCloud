package com.lhp.springcloud.rest;

import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.service.IPaymentService;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Amumu
 * @create 2021/3/2 21:29
 */
@RequestMapping("/payment")
@RestController
public class PaymentRest {
    @Value("${server.port}")
    private Integer port;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    IPaymentService paymentService;
    @RequestMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        paymentService.save(payment);
        return new CommonResult(200,"success,port====="+port);
    }

    @RequestMapping("/get/{id}")
    public CommonResult add(@PathVariable Long id){
        Payment byId = paymentService.getById(id);
        return new CommonResult(200,"success,port====="+port,byId);
    }
    //discoveryClient
    @RequestMapping("/discoveryClientInfo")
    public CommonResult discoveryClient(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-PAYMENT");
        for (ServiceInstance instance : instances) {
            System.out.println("instance.getInstanceId() = " + instance.getInstanceId());
            System.out.println("instance.getHost() = " + instance.getHost());
            System.out.println("instance.getPort() = " + instance.getPort());
        }
        return new CommonResult(200,"success",discoveryClient);
    }
    @RequestMapping("/feign")
    public CommonResult feign(){
        return new CommonResult(200,"success",port);
    }

    @RequestMapping("/feignLongTime")
    public CommonResult feignLongTime(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"success",port);
    }
}

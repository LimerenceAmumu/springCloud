package com.lhp.springcloud.rest;

import com.lhp.springcloud.feignService.PaymentService;
import com.lhp.springcloud.util.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Amumu
 * @create 2021/3/11 20:32
 */
@RestController
@RequestMapping("/consumer/order/hystrix")
@DefaultProperties(defaultFallback = "defaulFallback")
public class OrderRest {
    @Resource
    PaymentService paymentService;

    @RequestMapping("/ok/{id}")
    public String demo(@PathVariable("id") Integer id){
        return paymentService.ok(id);
    }


    /**
     * 测试超时时间
     * @return
     */
    @RequestMapping("/time_long/{seconds}")
    public String feignLongTime(@PathVariable("seconds") Integer seconds){
        return paymentService.timeout(seconds);
    }

    /**
     * 测试 客户端的 降级  传参：2 触发自己 不会触发服务端
     * @return
     */
    @HystrixCommand(fallbackMethod = "clientFallback_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    @RequestMapping("/clientFallback/{seconds}")
    public String clientFallback(@PathVariable("seconds") Integer seconds){
        return paymentService.fallback(seconds);
    }
    public String clientFallback_fallback( Integer seconds){
        return Thread.currentThread().getName() + "\t 客户端 clientFallback_fallback=== 耗费了" + seconds + " （单位:s）hhhh~";
    }


    /**
     * 测试默认的 降级方法
     * @param seconds
     * @return
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    @RequestMapping("/testDefaulFallback/{seconds}")
    public String testDefaulFallback(@PathVariable("seconds") Integer seconds){
        int a=2/10;
        return paymentService.fallback(seconds);
    }
    public String defaulFallback(){
        return Thread.currentThread().getName()+"\t  global  defaulFallback";
    }


    /**
     * 测试 直接实现类 的 服务降级 不用新建其他的非业务方法
     * @param seconds
     * @return
     */
    @RequestMapping("/testFallback/{seconds}")
    public String testFallback(@PathVariable("seconds") Integer seconds){
        //int a=2/10;
        return paymentService.ok(seconds);
    }
}
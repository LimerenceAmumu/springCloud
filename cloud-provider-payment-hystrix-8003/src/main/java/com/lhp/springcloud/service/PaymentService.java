package com.lhp.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Amumu
 * @create 2021/4/3 8:25
 */
@Service
public class PaymentService {

    public String paymentService_ok(Integer id) {
        return Thread.currentThread().getName() + "\t PaymentService.ok " + id + "hhhh~";
    }

    /**
     * @param secends
     * @return
     * @HystrixCommand 执行时间大于3秒或者发生异常时（timeoutInMilliseconds 3000） 执行 fallbackMethod 指定的方法
     */
    @HystrixCommand(fallbackMethod = "paymentService_timeout_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentService_timeout(Integer secends) {
        //发生异常时也会直接执行  降级方法
        int a = 1 / 0;
        try {
            TimeUnit.SECONDS.sleep(secends);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "\t PaymentService.timeout=== 耗费了" + secends + " （单位:s）hhhh~";
    }

    /**
     * paymentService_timeout 的兜底方案
     *
     * @param secends
     * @return
     */
    public String paymentService_timeout_fallback(Integer secends) {
        return Thread.currentThread().getName() + "\t PaymentService.paymentService_timeout_fallback===服务繁忙" + secends + " （单位:s）hhhh~";
    }

    /**
     * 此方法用于测试 客户端的  降级策略， 传入参数为 2时，并不会触发自己的 降级，但是  会触发客户端的 降级方法
     *
     * @param secends
     * @return
     */
    @HystrixCommand(fallbackMethod = "clientFallback_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")})
    public String clientFallback(Integer secends) {
        try {
            TimeUnit.SECONDS.sleep(secends);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "\t PaymentService.clientFallback=== 耗费了" + secends + " （单位:s）hhhh~";
    }

    /**
     * paymentService_timeout 的兜底方案
     *
     * @param secends
     * @return
     */
    public String clientFallback_fallback(Integer secends) {
        return Thread.currentThread().getName() + "\t PaymentService.paymentService_timeout_fallback===服务端 ：服务繁忙" + secends + " （单位:s）hhhh~";
    }


    //============服务熔断==============

    @HystrixCommand(fallbackMethod = "circuitBreaker_fallback", commandProperties = {
            //服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 失败率阈值
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    public String circuitBreaker(Integer a) {
        if (a <= 0) {
            throw new RuntimeException("参数不可以小于0");
        }
        return "服务正常执行";
    }

    public String circuitBreaker_fallback(Integer secends) {
        return "服务熔断了";
    }
}

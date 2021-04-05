package com.lhp.springcloud.feignService;

import com.lhp.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX",fallback = PaymentService02Impl.class)
public interface PaymentService {
    @RequestMapping("/hystrix/ok/{id}")
     String ok(@PathVariable("id") Integer id);

    @RequestMapping("/hystrix/timeout/{seconds}")
     String timeout(@PathVariable("seconds") Integer seconds);

    @RequestMapping("/hystrix/fallback/{seconds}")
    String fallback(@PathVariable("seconds") Integer seconds);
}
package com.lhp.springcloud.feignService;

import com.lhp.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Amumu
 * @create 2021/3/13 20:08
 */
@Component
@FeignClient("CLOUD-PROVIDER-PAYMENT")
public interface PaymentService {
    @RequestMapping("/payment/feign")
    CommonResult feign();

    @RequestMapping("/payment/feignLongTime")
     CommonResult feignLongTime();
}

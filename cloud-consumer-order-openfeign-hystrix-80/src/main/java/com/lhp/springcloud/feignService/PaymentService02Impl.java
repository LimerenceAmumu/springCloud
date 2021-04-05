package com.lhp.springcloud.feignService;

import org.springframework.stereotype.Component;

/**
 * @author Amumu
 * @create 2021/4/4 15:37
 */
@Component
public class PaymentService02Impl implements PaymentService {
    @Override
    public String ok(Integer id) {
        return "PaymentService02Impl.ok  ";
    }

    @Override
    public String timeout(Integer seconds) {
        return "PaymentService02Impl.timeout  ";
    }

    @Override
    public String fallback(Integer seconds) {
        return null;
    }
}

package com.lhp.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhp.springcloud.entity.Payment;

/**
 * @author Amumu
 * @create 2021/3/2 21:27
 */
public interface IPaymentService extends IService<Payment> {
    void add(Payment payment);
}

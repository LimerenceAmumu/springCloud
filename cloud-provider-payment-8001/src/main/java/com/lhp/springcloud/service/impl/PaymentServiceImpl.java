package com.lhp.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhp.springcloud.dao.PaymentDao;
import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

/**
 * @author Amumu
 * @create 2021/3/2 21:27
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements IPaymentService {

    @Override
    public void add(Payment payment) {

    }
}

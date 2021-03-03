package com.lhp.springcloud.rest;

import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.service.IPaymentService;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Amumu
 * @create 2021/3/2 21:29
 */
@RequestMapping("/payment")
@RestController
public class PaymentRest {
    @Resource
    IPaymentService paymentService;
    @RequestMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        paymentService.save(payment);
        return new CommonResult(200,"success");
    }

    @RequestMapping("/get/{id}")
    public CommonResult add(@PathVariable Long id){
        Payment byId = paymentService.getById(id);
        return new CommonResult(200,"success",byId);
    }
}

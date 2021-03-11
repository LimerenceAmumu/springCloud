package com.lhp.springcloud.rest;

import com.lhp.springcloud.entity.Payment;
import com.lhp.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Amumu
 * @create 2021/3/11 20:13
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PaymentRest {
    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/payment/consul")
    public CommonResult demo(){
        String uuid = UUID.randomUUID().toString();
        log.info("uuid: \t"+uuid);
        return new CommonResult(200,"success,port: \t"+port+"uuid: \t"+uuid);
    }


}

package com.lhp.springcloud.rest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelFlowLimitController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/testA")
    public String testA() {
        return "服务访问成功------testA";
    }
    @GetMapping("/testB")
    public String testB() {
        return "服务访问成功------testB";
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testCbyAnnotation") //通过注解定义资源
    public String testC() {
        log.info("服务访问成功------testC：" + serverPort);
        return "服务访问成功------testC：" + serverPort;
    }

    /**
     * 通过 Sentinel 控制台定义流控规则
     *
     */
    @GetMapping("/testD")
    @SentinelResource(value = "testD-resource", blockHandler = "blockHandlerTestD") //通过注解定义资源
    public String testD() {
        log.info(" 服务访问成功------testD：" + serverPort);
        return " 服务访问成功------testD：" + serverPort;
    }
    /**
     * 限流之后的逻辑
     * @param exception
     * @return
     */
    public String blockHandlerTestD(BlockException exception) {
        log.info(Thread.currentThread().getName() + " TestD服务访问失败! 您已被限流，请稍后重试");
        return " TestD服务访问失败! 您已被限流，请稍后重试";
    }
}
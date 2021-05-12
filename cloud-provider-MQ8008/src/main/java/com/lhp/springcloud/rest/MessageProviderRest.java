package com.lhp.springcloud.rest;

import com.lhp.springcloud.service.IMessageService;
import com.lhp.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Amumu
 * @create 2021/5/11 21:24
 */
@RestController
public class MessageProviderRest {
    @Resource
    IMessageService messageService;
    @RequestMapping("/sendMessage")
    public CommonResult sendMessage(@RequestParam String message){
        messageService.send();
        return new CommonResult(200,"success");
    }
}

package com.example.cloudprovidernacos.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: lihp
 * @date: 2022/2/11 11:13
 */
@RestController
@RefreshScope
public class DemoRest {

    @Value("${lhp.name}")
    private String useLocalCache;

    @RequestMapping("/get")
    public String get() {
        return useLocalCache;
    }
}

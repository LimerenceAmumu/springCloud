package com.lhp.springcloud.service.impl;

import com.lhp.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author Amumu
 * @create 2021/5/4 20:47
 */
@Slf4j
@EnableBinding(Source.class)// 定义消息的推送管道
public class MessageServiceImpl implements IMessageService {
    @Resource
    private MessageChannel output;// 消息的管道
    @Override
    public void send() {

        String serial = UUID.randomUUID().toString();
        log.info("生产者流水号："+serial);
        output.send(MessageBuilder.withPayload(serial).build());
    }
}

package com.lhp.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amumu
 * @create 2021/5/11 23:37
 */
@Component
@EnableBinding(Sink.class)
public class RecesiveMessageRest {
    @Value("${server.port}")
    private String port;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("接收到的消息： ======="+message.getPayload()+"\t 端口号："+port);
    }

}

package com.teng.springcloud.service.impl;

import com.teng.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author
 * @create 2021-07-14 20:26
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        System.out.println("serial = " + serial);
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}

package com.leo.order.controller;

import com.leo.order.dto.OrderDTO;
import com.leo.order.message.StreamClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {

    @Autowired
    StreamClient streamClient;

    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public String print() {
        return env;
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/mq")
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.input().send(MessageBuilder.withPayload(orderDTO).build());
    }


}

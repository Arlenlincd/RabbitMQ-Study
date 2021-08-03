package com.arlin.servcice.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DirectSMSConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"sms.direct.queue"})
@Service
public class DirectSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms.direct.queue---接收到订单消息-->" + message);
    }
}
package com.arlin.servcice.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DirectEmailConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"email.direct.queue"})
@Service
public class DirectEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email.direct.queue---接收到订单消息-->" + message);
    }
}

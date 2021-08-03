package com.arlin.servcice.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FanoutEmailConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"email.fanout.queue"})
@Service
public class FanoutEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email.fanout.queue---接收到订单消息-->" + message);
    }
}

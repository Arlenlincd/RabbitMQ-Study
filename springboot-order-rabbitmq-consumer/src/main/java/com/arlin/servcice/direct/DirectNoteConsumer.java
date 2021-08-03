package com.arlin.servcice.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DirectNoteConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"note.direct.queue"})
@Service
public class DirectNoteConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("note.direct.queue---接收到订单消息-->" + message);
    }
}
package com.arlin.servcice.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TopicNoteConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "note.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "#.note.#"
))
public class TopicNoteConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("note.topic.queue---接收到订单消息-->" + message);
    }
}
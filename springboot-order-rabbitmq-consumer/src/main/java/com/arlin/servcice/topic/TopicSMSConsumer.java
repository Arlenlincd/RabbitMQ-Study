package com.arlin.servcice.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TopicSMSConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "com.#"
))
public class TopicSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms.topic.queue---接收到订单消息-->" + message);
    }
}
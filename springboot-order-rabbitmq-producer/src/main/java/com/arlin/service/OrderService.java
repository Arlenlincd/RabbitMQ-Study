package com.arlin.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/27
 */
@Service
public class OrderService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 模拟用户下单
     *
     * @param userId
     * @param productId
     * @param num
     */
    public void makeOrder(String exchangeName, String routingKey, String userId, String productId, int num) {
        //1.根据商品id查询库存是否足够
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功：" + orderId);
        //3.通过MQ来完成消息的分发
        //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }


    /**
     * 模拟用户下单 - 定时消息方式
     *
     * @param exchangeName
     * @param routingKey
     * @param userId
     * @param productId
     * @param num
     */
    public void makeTTLMessageOrder(String exchangeName, String routingKey, String userId, String productId, int num) {
        //1.根据商品id查询库存是否足够
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功：" + orderId);

        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("5000");   //设置消息过期时间
                message.getMessageProperties().setContentEncoding("UTF-8"); //设置编码
                return message;
            }
        };

        //3.通过MQ来完成消息的分发
        //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId, messagePostProcessor);
    }
}

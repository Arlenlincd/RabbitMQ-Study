package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitMqConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/27
 */
@Configuration
public class DirectConfig {

    /**
     * 声明注册direct模式的交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    /**
     * 声明队列 sms.direct.queue email.direct.queue note.direct.queue
     */
    @Bean
    public Queue smsQueueDirect() {
        return new Queue("sms.direct.queue");
    }
    @Bean
    public Queue emailQueueDirect() {
        return new Queue("email.direct.queue");
    }
    @Bean
    public Queue noteQueueDirect() {
        return new Queue("note.direct.queue");
    }

    /**
     * 完成绑定关系
     */
    @Bean
    public Binding smsBindingDirect() {
        return BindingBuilder.bind(smsQueueDirect()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding emailBindingDirect() {
        return BindingBuilder.bind(emailQueueDirect()).to(directExchange()).with("email");
    }
    @Bean
    public Binding noteBindingDirect() {
        return BindingBuilder.bind(noteQueueDirect()).to(directExchange()).with("note");
    }
}

package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FanoutConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/27
 */
@Configuration
public class FanoutConfig {

    /**
     * 声明注册fanout模式的交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    /**
     * 声明队列 sms.fanout.queue email.fanout.queue note.fanout.queue
     */
    @Bean
    public Queue smsQueueFanout() {
        return new Queue("sms.fanout.queue");
    }
    @Bean
    public Queue emailQueueFanout() {
        return new Queue("email.fanout.queue");
    }
    @Bean
    public Queue noteQueueFanout() {
        return new Queue("note.fanout.queue");
    }

    /**
     * 完成绑定关系
     */
    @Bean
    public Binding smsBindingFanout() {
        return BindingBuilder.bind(smsQueueFanout()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBindingFanout() {
        return BindingBuilder.bind(emailQueueFanout()).to(fanoutExchange());
    }
    @Bean
    public Binding noteBindingFanout() {
        return BindingBuilder.bind(noteQueueFanout()).to(fanoutExchange());
    }
}

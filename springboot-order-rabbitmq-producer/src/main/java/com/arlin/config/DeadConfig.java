package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: DeadConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/8/1
 */
@Configuration
public class DeadConfig {

    /**
     * 声明注册direct模式的死信队列的交换机
     * @return
     */
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange("dead_order_exchange", true, false);
    }

    /**
     * 声明队列 dead.direct.queue
     */
    @Bean
    public Queue deadQueue() {
        return new Queue("dead.direct.queue", true);
    }

    /**
     * 完成绑定关系
     */
    @Bean
    public Binding deadBindingDirect() {
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("dead");
    }

}

package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TTLConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/29
 */
@Configuration
public class TTLConfig {

    /**
     * 声明注册direct模式的交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directTTLExchange() {
        return new DirectExchange("ttl_order_exchange", true, false);
    }

    // 队列的过期时间
    @Bean
    public Queue directTTLQueue() {
        //设置过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        args.put("x-dead-letter-exchange", "dead_order_exchange");
        args.put("x-dead-letter-routing-key", "dead");  //fanout模式不需要配置
        return new Queue("ttl.direct.queue", true, false, false, args);
    }

    @Bean
    public Queue directTTLMessageQueue() {
        return new Queue("ttl.direct.message.queue", true);
    }

    @Bean
    public Binding ttlBingding() {
        return BindingBuilder.bind(directTTLQueue()).to(directTTLExchange()).with("ttl");
    }

    @Bean
    public Binding ttlMessageBingding() {
        return BindingBuilder.bind(directTTLMessageQueue()).to(directTTLExchange()).with("ttl_message");
    }

}

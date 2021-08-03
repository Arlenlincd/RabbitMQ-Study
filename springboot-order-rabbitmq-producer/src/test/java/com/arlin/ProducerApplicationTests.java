package com.arlin;

import com.arlin.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
//        orderService.makeOrder("fanout_order_exchange", "", "user", "product", 12);
//        orderService.makeOrder("direct_order_exchange", "sms", "user", "product", 12);
//        orderService.makeOrder("topic_order_exchange", "com.email", "user", "product", 12);
        orderService.makeOrder("ttl_order_exchange", "ttl", "user", "product", 12); //定时队列
//        orderService.makeTTLMessageOrder("ttl_order_exchange", "ttl_message", "user", "product", 12); //定时消息
    }
}

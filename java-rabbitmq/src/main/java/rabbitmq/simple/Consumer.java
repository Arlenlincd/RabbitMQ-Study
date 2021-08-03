package rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/25
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.15.0.9");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection("生产者");
        //2.创建通道
        Channel channel = connection.createChannel();
        //3.接受内容
        channel.basicConsume("queue1", true, new DeliverCallback() {
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("收到消息是" + new String(message.getBody(), "UTF-8"));
            }
        }, new CancelCallback() {
            public void handle(String consumerTag) throws IOException {
                System.out.println("接受失败了");
            }
        });
        //4.关闭
        channel.close();
        connection.close();
    }
}


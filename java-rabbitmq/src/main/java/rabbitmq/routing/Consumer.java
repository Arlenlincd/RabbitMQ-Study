package rabbitmq.routing;

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

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //1.创建连接工厂
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("10.15.0.9");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("admin");
            connectionFactory.setPassword("admin");
            connectionFactory.setVirtualHost("/");
            //获取队列名称
            final String queueName = Thread.currentThread().getName();
            Connection connection = null;
            //2.创建通道
            Channel channel = null;
            //3.接受内容
            try {
                connection = connectionFactory.newConnection("生产者");
                channel = connection.createChannel();

                channel.basicConsume(queueName, true,
                        (consumerTag, message) -> {
                            System.out.println(message.getEnvelope().getDeliveryTag());
                            System.out.println("收到消息是" + new String(message.getBody(), "UTF-8"));
                        },
                        consumerTag -> System.out.println("接受失败了"));

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //4.关闭
                try {
                    channel.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        new Thread(runnable, "queue1").start();
        new Thread(runnable, "queue2").start();
        new Thread(runnable, "queue3").start();
    }

}


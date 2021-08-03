package rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Producer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/25
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.102");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
//        connectionFactory.setHandshakeTimeout(3000000);
        Connection connection = connectionFactory.newConnection("生产者");
        //2.创建通道
        Channel channel = connection.createChannel();
        //3.通过创建交换机，声明队列，绑定关系，路由key，发送消息和接受消息
        /*
         * @params1：队列名称
         * @params2：是否持久化，非持久化消息会存盘吗？会存盘，但是会随着重启服务器而丢失
         * @params3：是否独占队列
         * @params4：是否自动删除，随着最后一个消费者消息完毕消息以后是否把队列自动删除
         * @params5：携带附属属性
         */
        String queueName = "queue1";
        channel.queueDeclare(queueName,false,false,false,null);
        //4.发送消息给队列queue
        /*
         * @params1：交换机
         * @params2：队列、路由key
         * @params3：消息的状态控制
         * @params4：消息主题
         */
        //面试题：可以存在没有交换机的队列吗？不可能，虽然没有指定交换机但是一定会存在一个默认的交换机
        String message = "Hello";
        channel.basicPublish("",message, null,message.getBytes());
        //5.关闭
        channel.close();
        connection.close();
    }
}

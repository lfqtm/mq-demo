package cn.itcast.mq;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerApplicationTest {

	@Test
	void main() throws IOException, TimeoutException {
		//1 建立连接工程
		ConnectionFactory factory = new ConnectionFactory();
		// 设置连接参数
		factory.setHost("192.168.137.105");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		factory.setUsername("root");
		factory.setPassword("root");
		// 建立连接
		Connection connection = factory.newConnection();

		//2创建连接通道
		Channel channel = connection.createChannel();

		//3创建队列
		String queueName = "simple.queue";
		// 参数1 连接队列名称
		// 参数2 是否持久化
		// 参数3 当前用户是否独有
		// 参数4 当前队列没有消息时 是否删除队列
		// 参数5 其他属性
		channel.queueDeclare(queueName, false, false, false, null);

		//4订阅消息，异步监听
		String message = "hello rabbitmq!";
		// 参数1 队列name
		// 参数2 autoAck 确认机制，是否拿到了消息，再是否删除
		// 参数3 匿名内部类，消费规则
		channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
			// 异步监听
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body);
				System.out.println("获取的消息为：" + message);

			}
		});
		System.out.println("ok");

		//5关闭连接和通道
		channel.close();
		connection.close();
	}
}

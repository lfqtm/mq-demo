package cn.itcast.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class PublisherApplicationBasicAPITest {

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

		//4发送消息
		String message = "hello rabbitmq!";
		// 参数1 交换机
		// 参数2 队列name
		// 参数3 发送消息时，消息属性
		// 参数4 消息内容
		channel.basicPublish("", queueName, null, message.getBytes());
		System.out.println("ok");

		//5关闭连接和通道
		channel.close();
		connection.close();


	}
}

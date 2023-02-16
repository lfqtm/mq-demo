package cn.itcast.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicAMQPTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * topicExchange
	 */
	@Test
	public void testSendTopicExchange() {
		// 交换机名称
		String exchangeName = "itcast.topic";
		// 消息
		String message = "喜报！孙悟空大战哥斯拉，胜!";
		// 发送消息
		rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
	}
}

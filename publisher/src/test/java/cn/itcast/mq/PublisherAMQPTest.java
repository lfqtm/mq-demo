package cn.itcast.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublisherAMQPTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * basicQueue
	 */
	@Test
	public void testAMQP() {
		String message = "hello rabbit mq";
		String queueName = "simple.queue";
		rabbitTemplate.convertAndSend(queueName, message);
	}

	/**
	 * workQueue
	 * 向队列中不停发送消息，模拟消息堆积。
	 */
	@Test
	public void testWorkQueue() throws InterruptedException {
		// 队列名称
		String queueName = "simple.queue";
		// 消息
		String message = "hello, message_";
		for (int i = 0; i < 50; i++) {
			// 发送消息
			rabbitTemplate.convertAndSend(queueName, message + i);
			Thread.sleep(20);
		}
	}
}

package cn.itcast.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FanoutAMQPTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void testFanoutExchange() {
		// 交换机名称
		String exchangeName = "itcast.fanout";
		// 消息
		String message = "hello, everyone!";

		// convertAndSend
		// 参数1 交换机名称
		// 参数2 路由规则（fanout模式下规则为空）
		// 参数3 消息内容
		for (int i = 0; i < 10; i++) {
			rabbitTemplate.convertAndSend(exchangeName, "", message);
		}
		System.out.println("fanout消息发送成功");
	}
}

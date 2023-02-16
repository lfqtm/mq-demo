package cn.itcast.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SendObjectTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void testSendMap() throws InterruptedException {
		// 准备消息
		Map<String,Object> msg = new HashMap<>();
		msg.put("name", "Jack");
		msg.put("age", 21);
		// 发送消息
		rabbitTemplate.convertAndSend("simple.queue", msg);
		System.out.println("发送对象成功");
	}

}

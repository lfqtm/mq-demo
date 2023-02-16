package cn.itcast.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsumerAMQPTest {
	@Autowired
	private AmqpTemplate amqpTemplate;


}

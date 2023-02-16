package cn.itcast.mq.listner;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅 - Direct模式（添加路由规则）
 */
@Component
public class DirectListener {

	@RabbitListener(bindings = @QueueBinding(
		value = @Queue(name = "direct.queue1"),
		exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
		key = {"red", "blue"}
	))
	public void listenDirectQueue1(String msg) {
		System.out.println("消费者接收到direct.queue1的消息：【" + msg + "】");
	}

	@RabbitListener(bindings = @QueueBinding(
		value = @Queue(name = "direct.queue2"),
		exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
		key = {"red", "yellow"}
	))
	public void listenDirectQueue2(String msg) {
		System.out.println("消费者接收到direct.queue2的消息：【" + msg + "】");
	}
}

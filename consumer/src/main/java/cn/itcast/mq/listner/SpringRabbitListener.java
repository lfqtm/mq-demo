package cn.itcast.mq.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Slf4j
public class SpringRabbitListener {

	/**
	 * 1简单模式
	 * 监听指定的rabbitmq队列
	 */
//	@RabbitListener(queues = "simple.queue")
//	public void listenSimpleQueueMessage(String msg) throws InterruptedException {
//		log.info("=======" + msg);
//	}

	/**
	 * 2工作模式
	 */
//	@RabbitListener(queues = "simple.queue")
//	public void listenWorkQueue1(String msg) throws InterruptedException {
//		System.out.println("消费者1接收到消息：【" + msg + "】" + LocalTime.now());
//		Thread.sleep(20); //时间差
//	}

	/**
	 * 2工作模式
	 */
//	@RabbitListener(queues = "simple.queue")
//	public void listenWorkQueue2(String msg) throws InterruptedException {
//		System.err.println("消费者2........接收到消息：【" + msg + "】" + LocalTime.now());
//		Thread.sleep(200);
//	}
}

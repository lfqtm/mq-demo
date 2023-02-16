package cn.itcast.mq.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

@Component
@Slf4j
public class SendObjectListener {

	@RabbitListener(queues = "simple.queue")
	public void listenWorkQueue1(Map<String, String> msg) throws InterruptedException {
		System.out.println("消费者1接收到消息：【" + msg + "】" + LocalTime.now());
		log.info("消息内容为：{}", msg);
		Thread.sleep(20); //时间差
	}

}

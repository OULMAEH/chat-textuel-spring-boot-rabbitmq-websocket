package com.chat.rabbitmq;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chat.message.Message;
import com.chat.message.MessageService;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Component
public class RabbitMQReceiver {
	

	@Autowired
	private MessageService messageService;
	
	
	//@RabbitListener(queues = "#{rabbit.getQueue()}")
	public void MessageListener(Message message) {
		System.out.println("coming from Rabbit listener :"+message);
		//messageService.create(message);
		
	}
	
	
}

package com.chat.rabbitmq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.message.Message;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@RestController
public class RabbitMQController {
	

	
	@Autowired
	private RabbitMQpublisher rabbitpublisher;
	
	
	@PostMapping(value = "/addMessageToRabbit")
	public Message create(@RequestBody Message message) {
		
		rabbitpublisher.sendMessage(message);
		
		return message;
		
	}	

}

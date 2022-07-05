package com.chat.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.message.Message;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Service
public class RabbitMQpublisher {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	Rabbit rabbit;
	
	public void sendMessage(Message msg){
		
		rabbitTemplate.convertAndSend("amq.topic","exchange", msg);
        								
    }

	
}

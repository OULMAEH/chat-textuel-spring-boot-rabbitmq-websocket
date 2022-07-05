package com.chat.websocket;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


import com.chat.message.Message;
import com.chat.rabbitmq.RabbitMQpublisher;



/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Controller
public class WebSocketController {
	
	@Autowired(required=false)
	private SimpMessagingTemplate messagetemplate;
	
	private RabbitMQpublisher rabbitpublisher;
	
	@MessageMapping("/sendmessage")
    public Message sendMessage(@Payload Message message){		
	
		
		/*messagetemplate.convertAndSendToUser(message.getReceivers().getUsername(),
										 "/topic/exchange", 
										 message);*/
		
		
		messagetemplate.convertAndSend("/topic/exchange", message);
		
		System.out.println("Receiver : "+message.getReceivers().getUsername());
		System.out.println("Message received successfully \nMessage content :"+message.getMessageContent()+"\n");
        
		return message;
    }
    
}

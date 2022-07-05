package com.chat.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Configuration
public class RabbitMQBinding {
	
	final Rabbit rabbit = new Rabbit();
	
	@Bean
	public Queue queueMessagerie() {
		
		Queue queue = new Queue("clientQueue", false);
		rabbit.setQueue(queue.getActualName());
		System.out.println("inside binding :  " +rabbit.getQueue()+ "  after  that");
		return queue;
		
	}
	
	@Bean
	public Exchange exchange() {
		
		Exchange exchange = new TopicExchange("amq.topic");

		return exchange;
	}
	

	@Bean
	public Binding binding(TopicExchange exchange, Queue queue) {
		
		Binding binding = BindingBuilder.bind(queue).to(exchange).with("exchange");		
		
        return binding;
		
	}
	
	
}

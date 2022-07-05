package com.chat.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	private final WebSocketProprties proprties = new WebSocketProprties("localhost", 61613, "guest", "guest");
	
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		
        registry.addEndpoint("/chat")
        .setAllowedOrigins("http://localhost:3000") //domain
        .withSockJS();
        
    }

    /**
     *
     */
    @Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
        
		registry.setApplicationDestinationPrefixes("/thousandchat");
		registry.setUserDestinationPrefix("/user");		
		registry.enableStompBrokerRelay("/direct","/topic")
				.setRelayHost("localhost")
				.setRelayPort(61613)
				.setSystemLogin("guest")
				.setSystemPasscode("guest");
		
		}
}

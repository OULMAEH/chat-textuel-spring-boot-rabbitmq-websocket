package com.chat.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.chat.message.Message;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Component
public class WebSocketChatEventListener {
	
	@Autowired
    private SimpMessageSendingOperations messagingTemplate;

   @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        System.out.println("nouvelle connexion de websocket");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        System.out.println("disconnected from web socket connection");
        
    }
}

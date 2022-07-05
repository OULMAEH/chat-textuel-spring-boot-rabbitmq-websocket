package com.chat.message;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Service
public class MessageService implements MessageInterface{
	
	@Autowired
	private MessageRepository messageRepository;
	
	
	@Override
	public Message create(Message message) {
		return messageRepository.save(message);
	}


	@Override
	public Message update(Message message, long idMessage) {
		Optional<Message> messageToUpdate = messageRepository.findById(idMessage);
		if (messageToUpdate.isPresent()) {
			message.setIdMessage(idMessage);
			return messageRepository.saveAndFlush(message);
		}
		return message;
	}


	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}


	@Override
	public Message findOne(long idMessage) {
		Message messageLookUp = null;
		Optional<Message> message = messageRepository.findById(idMessage);
		if (message.isPresent()) {
			messageLookUp = message.get();
		}
		return messageLookUp;	}


	@Override
	public void delete(long idMessage) {
		Optional<Message> message = messageRepository.findById(idMessage);
		if (message.isPresent()) {
			messageRepository.deleteById(idMessage);
		}		
	}


	@Override
	public Message archive(Message message, long idMessage) {
		Optional<Message> messageToUpdate = messageRepository.findById(idMessage);
		if (messageToUpdate.isPresent()) {
			message.setIdMessage(idMessage);
			return messageRepository.saveAndFlush(message);
		}
		return message;
	}

}

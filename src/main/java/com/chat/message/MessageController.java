package com.chat.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@RestController
@RequestMapping("/")
public class MessageController {

	@Autowired
	private MessageInterface messageInterface;

	/**
	 * @param message
	 * @return
	 * @see com.chat.message.MessageInterface#create(com.chat.message.Message)
	 */
	@PostMapping(value = "/message/addMessage")
	public Message create(@RequestBody Message message) {
		return messageInterface.create(message);
	}

	/**
	 * @param message
	 * @param idMessage
	 * @return
	 * @see com.chat.message.MessageInterface#update(com.chat.message.Message, long)
	 */
	@PatchMapping(value = "/message/updateMessage/{id}")
	public Message update(@RequestBody Message message,@PathVariable long idMessage) {
		return messageInterface.update(message, idMessage);
	}

	/**
	 * @return
	 * @see com.chat.message.MessageInterface#findAll()
	 */
	@GetMapping(value = "/allMessages")
	public List<Message> findAll() {
		return messageInterface.findAll();
	}

	/**
	 * @param idMessage
	 * @return
	 * @see com.chat.message.MessageInterface#findOne(long)
	 */
	@GetMapping(value = "/oneMessage/{id}")
	public Message findOne(@PathVariable long idMessage) {
		return messageInterface.findOne(idMessage);
	}

	/**
	 * @param idMessage
	 * @see com.chat.message.MessageInterface#delete(long)
	 */
	@DeleteMapping(value = "/message/deleteMessage/{id}")
	public void delete(@PathVariable long idMessage) {
		messageInterface.delete(idMessage);
	}

	/**
	 * @param message
	 * @param idMessage
	 * @return
	 * @see com.chat.message.MessageInterface#archive(com.chat.message.Message, long)
	 */
	@PatchMapping(value = "/message/archiveMessage/{id}")
	public Message archive(@RequestBody Message message,@PathVariable long idMessage) {
		return messageInterface.archive(message, idMessage);
	}
}

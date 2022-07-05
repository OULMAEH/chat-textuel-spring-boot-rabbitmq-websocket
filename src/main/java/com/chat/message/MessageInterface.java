package com.chat.message;

import java.util.List;


/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
public interface MessageInterface {
	//Default JPA CRUD
	Message create(Message message);
	Message update(Message message, long idMessage);
	List<Message> findAll();
	Message findOne(long idMessage);
	void delete(long idMessage);
		
	//Custom Methods
	Message archive(Message message, long idMessage);

}

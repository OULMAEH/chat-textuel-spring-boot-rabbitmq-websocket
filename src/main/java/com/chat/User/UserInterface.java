package com.chat.User;

import java.util.List;


/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
public interface UserInterface {
	//Default JPA CRUD
	User create(User user);
	User update(User user, long idUser);
	List<User> findAll();
	User findOne(long idUser);
	void delete(long idUser);
			
	//Custom Methods
	User archive(User user, long idUser);
	Role createRole(Role role);
	User getUser(String username);
	void addRoleToUser(String username,String role);

}

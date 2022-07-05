package com.chat.User;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@RepositoryRestResource(path="user")
public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByUsername(String username);

}

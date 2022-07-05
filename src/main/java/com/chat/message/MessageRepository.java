package com.chat.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@RepositoryRestResource(path = "message")
public interface MessageRepository extends JpaRepository<Message, Long>{

}

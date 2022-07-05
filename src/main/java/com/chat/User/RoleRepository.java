package com.chat.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@RepositoryRestResource(path="role")
public interface RoleRepository extends JpaRepository<Role,Long>{
	
	Role findByRole(String role);

}

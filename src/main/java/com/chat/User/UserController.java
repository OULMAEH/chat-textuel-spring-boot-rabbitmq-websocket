package com.chat.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

	@Autowired
	private UserInterface userInterface;

	
	/**
	 * @param user
	 * @return
	 * @see com.chat.User.UserInterface#create(com.chat.User.User)
	 */
	@PostMapping(value = "/user/addUser")
	public User create(@RequestBody User user) {
		return userInterface.create(user);
	}

	/**
	 * @param user
	 * @param idUser
	 * @return
	 * @see com.chat.User.UserInterface#update(com.chat.User.User, long)
	 */
	@PatchMapping(value = "/user/updateUser/{id}")
	public User update(@RequestBody User user,@PathVariable long idUser) {
		return userInterface.update(user, idUser);
	}

	/**
	 * @return
	 * @see com.chat.User.UserInterface#findAll()
	 */
	@GetMapping(value = "/allUsers")
	public List<User> findAll() {
		return userInterface.findAll();
	}

	/**
	 * @param idUser
	 * @return
	 * @see com.chat.User.UserInterface#findOne(long)
	 */
	@GetMapping(value = "/oneUser/{id}")
	public User findOne(@PathVariable long idUser) {
		return userInterface.findOne(idUser);
	}

	/**
	 * @param idUser
	 * @see com.chat.User.UserInterface#delete(long)
	 */
	@DeleteMapping(value = "/user/deleteUser/{id}")
	public void delete(@PathVariable long idUser) {
		userInterface.delete(idUser);
	}

	/**
	 * @param user
	 * @param idUser
	 * @return
	 * @see com.chat.User.UserInterface#archive(com.chat.User.User, long)
	 */
	@PatchMapping(value = "/user/archiveUser/{id}")
	public User archive(@RequestBody User user,@PathVariable long idUser) {
		return userInterface.archive(user, idUser);
	}
	
	@PostMapping(value = "/role/addRole")
	public Role create(@RequestBody Role role) {
		return userInterface.createRole(role);
	}
	
	@PostMapping(value = "/role/addRoleToUser")
	public ResponseEntity<?> saveRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
		
		userInterface.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRole());
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping(value = "/role/addRoleToUser")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
		
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		
	}
}
class RoleToUserForm{
	private String username;
	private String role;
	/**
	 * @param username
	 * @param role
	 */
	public RoleToUserForm(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}
	/**
	 * 
	 */
	public RoleToUserForm() {
		super();
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
}
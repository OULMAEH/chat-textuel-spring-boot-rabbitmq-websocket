package com.chat;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.chat.User.Role;
import com.chat.User.User;
import com.chat.User.UserService;

@SpringBootApplication
public class ThousandChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThousandChatApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner run(UserService userService) {
		
		return args -> {
		
			userService.createRole(new Role(1, "ROLE_USER"));
			userService.createRole(new Role(2, "ROLE_ADMIN"));
			
			userService.create(new User(1, "yassine@com", "068787878", "yassine@admin", "admin", new ArrayList<>()));
			userService.create(new User(2, "admin@com", "068787878", "admin@admin", "admin", new ArrayList<>()));
			userService.create(new User(3, "khalid@com", "068787878", "khalid@admin", "admin", new ArrayList<>()));
			userService.create(new User(4, "achraf@com", "068787878", "achraf@admin", "admin", new ArrayList<>()));
			userService.create(new User(5, "amine@com", "068787878", "amine@admin", "admin", new ArrayList<>()));

			userService.addRoleToUser("admin@admin", "ROLE_ADMIN");
			userService.addRoleToUser("yassine@admin", "ROLE_ADMIN");
			userService.addRoleToUser("khalid@admin", "ROLE_ADMIN");
			userService.addRoleToUser("achraf@admin", "ROLE_ADMIN");
			userService.addRoleToUser("yassine@admin", "ROLE_USER");
		};
		
	}*/
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

package com.chat.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Service @Transactional
public class UserService implements UserInterface,UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User update(User user, long idUser) {
		Optional<User> userToUpdate = userRepository.findById(idUser);
		if (userToUpdate.isPresent()) {
			user.setIdUser(idUser);
			return userRepository.saveAndFlush(user);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(long idUser) {
		User userLookUp = null;
		Optional<User> user = userRepository.findById(idUser);
		if (user.isPresent()) {
			userLookUp = user.get();
		}
		return userLookUp;
	}

	@Override
	public void delete(long idUser) {
		Optional<User> user = userRepository.findById(idUser);
		if (user.isPresent()) {
			userRepository.deleteById(idUser);
		}	
	}

	@Override
	public User archive(User user, long idUser) {
		Optional<User> userToUpdate = userRepository.findById(idUser);
		if (userToUpdate.isPresent()) {
			user.setIdUser(idUser);
			return userRepository.saveAndFlush(user);
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			System.out.println("user found");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> { 
			authorities.add(new SimpleGrantedAuthority(role.getRole())); 
			});
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}

	@Override
	public Role createRole(Role role) {
		
		return roleRepository.save(role);
		
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		
		User user = userRepository.findByUsername(username);
		Role rol = roleRepository.findByRole(role);
		
		user.getRoles().add(rol);
	}

}

package com.obyleus.policymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obyleus.policymanagement.entity.User;
import com.obyleus.policymanagement.repository.IUserRepository;

@RestController
@RequestMapping("/api/v1/policy-management")
public class UserController {
	
	private IUserRepository userRepository;
	
	public UserController(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("/users")
	public User addNewUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
		
	}
		
	@GetMapping("/users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/users/{id}")	
	public User updateUserById(@PathVariable int id, @RequestBody User newUser) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setUserPass(newUser.getUserPass());
			foundUser.setUserFirstName(newUser.getUserFirstName());
			foundUser.setUserLastName(newUser.getUserLastName());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepository.deleteById(id);
}
}
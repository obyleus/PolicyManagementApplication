package com.obyleus.policymanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obyleus.policymanagement.entity.User;
import com.obyleus.policymanagement.service.UserService;

@RestController
@RequestMapping("/api/v1/policy-management")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public User addNewUser(@RequestBody User newUser) {
		return userService.addNewUser(newUser);
	}
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PutMapping("/users/{id}")	
	public User updateUserById(@PathVariable int id, @RequestBody User newUser) {
		return userService.updateUserById(id, newUser);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userService.deleteUserById(id);
	}
}
package com.obyleus.policymanagement.service;

import java.util.List;

import com.obyleus.policymanagement.entity.User;

public interface IUserService {
	
	List<User> getAll();
	User getUserById(int id);
	void add(User user);
	void update(User user);
	void delete(User user);
}

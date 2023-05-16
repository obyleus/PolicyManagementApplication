package com.obyleus.policymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.User;
import com.obyleus.policymanagement.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	 
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @Transactional
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
 
    @Transactional
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
 
    @Transactional
    public User updateUserById(int id, User newUser) {
    	User foundUser = userRepository.getUserById(id);
		if(null != foundUser) {
			foundUser.setUserName(newUser.getUserName());
			foundUser.setUserPass(newUser.getUserPass());
			userRepository.updateUserById(foundUser);
			return foundUser;
		}else
			return null;
    }
 
    @Transactional
    public void deleteUserById(int id) {
    	User foundUser = userRepository.getUserById(id);
		if(null != foundUser) {
        userRepository.deleteUser(foundUser);
		}		
    }
    
    @Transactional
	public User addNewUser(User newUser) {
		userRepository.addNewUser(newUser);
		return newUser;
	}
}

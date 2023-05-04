package com.obyleus.policymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obyleus.policymanagement.entity.User;


public interface IUserRepository extends JpaRepository<User, Integer> {
	
	

}

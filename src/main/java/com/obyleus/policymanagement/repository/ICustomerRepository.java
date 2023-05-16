package com.obyleus.policymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obyleus.policymanagement.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findById(int id);
}

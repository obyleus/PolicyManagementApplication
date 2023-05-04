package com.obyleus.policymanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obyleus.policymanagement.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> getAllCustomer();
	Customer getCustomerById(int id);
	void addNewCustomer(Customer customer);
	void updateCustomerById(int id);
	void deleteCustomerById(Customer customer);	
}

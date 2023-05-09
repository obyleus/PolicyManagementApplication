package com.obyleus.policymanagement.service;

import java.util.List;


import com.obyleus.policymanagement.entity.Customer;


public interface ICustomerService {
	
	List<Customer> getAll();
	Customer getCustomerById(int id);
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);

}

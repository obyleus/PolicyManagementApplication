package com.obyleus.policymanagement.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.Customer;
import com.obyleus.policymanagement.repository.CustomerRepository;

@Service
public class CustomerService  {
	
	private CustomerRepository customerRepository;
 
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
 
    @Transactional
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
 
    @Transactional
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }
 
    @Transactional
    public Customer updateCustomerById(int id, Customer newCustomer) {
    	Customer foundCustomer = customerRepository.getCustomerById(id);
		if(null != foundCustomer) {
			foundCustomer.setCustomerNumber(newCustomer.getCustomerNumber());
			foundCustomer.setCustomerFirstName(newCustomer.getCustomerFirstName());
			foundCustomer.setCustomerLastName(newCustomer.getCustomerLastName());
			customerRepository.updateCustomerById(foundCustomer);
			return foundCustomer;
		}else
			return null;
    }
 
    @Transactional
    public void deleteCustomerById(int id) {
    	Customer foundCustomer = customerRepository.getCustomerById(id);
		if(null != foundCustomer) {
        customerRepository.deleteCustomer(foundCustomer);
		}
		
    }
    
    @Transactional
	public Customer addNewCustomer(Customer newCustomer) {
		customerRepository.addNewCustomer(newCustomer);
		return newCustomer;
	}
}

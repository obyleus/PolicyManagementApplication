package com.obyleus.policymanagement.service;


import java.util.List;
import java.util.Optional;

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
        return customerRepository.findAll();
    }
 
    @Transactional
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
 
    @Transactional
    public Customer updateCustomerById(int id, Customer newCustomer) {
    	Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			Customer foundCustomer = customer.get();
			foundCustomer.setCustomerNumber(newCustomer.getCustomerNumber());
			foundCustomer.setCustomerFirstName(newCustomer.getCustomerFirstName());
			foundCustomer.setCustomerLastName(newCustomer.getCustomerLastName());
			customerRepository.save(foundCustomer);
			return foundCustomer;
		}else
			return null;
    }
 
    @Transactional
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
		
    }
    
    @Transactional
	public Customer addNewCustomer(Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}

}

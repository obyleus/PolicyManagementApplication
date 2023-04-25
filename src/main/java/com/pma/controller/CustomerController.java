package com.pma.controller; 

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

import com.pma.entity.Customer;
import com.pma.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/policy-management")
public class CustomerController {
	
	
	private CustomerRepository customerRepository;
	
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	
	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/customers/{id}")	
	public Customer updateCustomerById(@PathVariable int id, @RequestBody Customer newCustomer) {
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
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		customerRepository.deleteById(id);
	}	
}

package com.pma.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.entity.Customer;
import com.pma.repository.CustomerRepository;

@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Autowired
	@PostMapping("/new")
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}
	
	@Autowired
	@GetMapping("/list")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerRepository.deleteById(id);
	}	
}

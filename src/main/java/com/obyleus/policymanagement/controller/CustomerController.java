package com.obyleus.policymanagement.controller; 

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obyleus.policymanagement.entity.Customer;
import com.obyleus.policymanagement.service.CustomerService;

@RestController
@RequestMapping("/api/v1/policy-management")
public class CustomerController {
	
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
		return customerService.addNewCustomer(newCustomer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@PutMapping("/customers/{id}")	
	public Customer updateCustomerById(@PathVariable int id, @RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(id, newCustomer);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		customerService.deleteCustomerById(id);
	}	
}

package com.pma.service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Service;
import com.pma.entity.Customer;
import com.pma.repository.CustomerRepository;

@Service
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CustomerService {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerService.class, args);
	}
	
	
	public CommandLineRunner databasePopulator(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer(1020, "haha", "hehe"));
		};
	}
	

}

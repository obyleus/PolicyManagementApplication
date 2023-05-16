package com.obyleus.policymanagement.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com"})
@ComponentScan(basePackages = {"com.obyleus.policymanagement.*"})
@EnableJpaRepositories("com.obyleus.policymanagement.*")
@EntityScan("com.obyleus.policymanagement.entity")
public class PolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyManagementApplication.class, args);
	}

}

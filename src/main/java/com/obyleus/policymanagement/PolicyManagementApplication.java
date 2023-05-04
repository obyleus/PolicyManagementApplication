package com.obyleus.policymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"test"} , exclude = JpaRepositoriesAutoConfiguration.class)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })

public class PolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyManagementApplication.class, args);
	}

}

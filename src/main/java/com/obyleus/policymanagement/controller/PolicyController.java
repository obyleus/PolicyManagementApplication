package com.obyleus.policymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obyleus.policymanagement.entity.Policy;
import com.obyleus.policymanagement.service.PolicyService;

@RestController
@RequestMapping("/api/v1/policy-management")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	public PolicyController(PolicyService policyService) {
		this.policyService = policyService;
	}
	
	@PostMapping("/policies")
	public Policy addNewPolicy(@RequestBody Policy newPolicy) {
		return policyService.addNewPolicy(newPolicy);
	}
	
	@GetMapping("/policies")
	public List<Policy> getAllPolicy() {
		return policyService.getAllPolicy();
	}
	
	@GetMapping("/policies/{id}")
	public Policy getPolicyById(@PathVariable int id) {
		return policyService.getPolicyById(id);
	}	
	
	@PutMapping("/policies/{id}")
	public Policy update(@PathVariable int id, @RequestBody Policy policy) {
		return policyService.update(id, policy);
	}
}
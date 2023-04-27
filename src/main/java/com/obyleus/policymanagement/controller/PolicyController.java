package com.obyleus.policymanagement.controller;

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

import com.obyleus.policymanagement.entity.Policy;
import com.obyleus.policymanagement.repository.PolicyRepository;

@RestController
@RequestMapping("/api/v1/policy-management")
public class PolicyController {
	
	private PolicyRepository policyRepository;
	
	public PolicyController(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
	}
	
	@PostMapping("/policies")
	public Policy addNewPolicy(@RequestBody Policy newPolicy) {
		return policyRepository.save(newPolicy);
	}
	
	@GetMapping("/policies")
	public List<Policy> getAllPolicy() {
		return policyRepository.findAll();
	}
	
	@GetMapping("/policies/{id}")
	public Policy getPolicyById(@PathVariable int id) {
		return policyRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/policies/id/{id}")
	public Policy updatePolicyById(@PathVariable int id, @RequestBody Policy newPolicy) {
		Optional<Policy> policy = policyRepository.findById(id);
		if (policy.isPresent()) {
			Policy foundPolicy = policy.get();
			foundPolicy.setPolicyNumber(newPolicy.getPolicyNumber());
			foundPolicy.setPolicyTypeId(newPolicy.getPolicyTypeId());
			foundPolicy.setPolicyPremium(newPolicy.getPolicyPremium());
			foundPolicy.setPolicyStatus(newPolicy.getPolicyStatus());
			foundPolicy.setPolicyCreateDate(newPolicy.getPolicyCreateDate());
			policyRepository.save(newPolicy);
			return foundPolicy;
		}else
			return null;
	}
	
	@DeleteMapping("/policies/id/{id}")
	public void deletePolicyById(@PathVariable int id) {
		policyRepository.deleteById(id);
	}	
	
	
}

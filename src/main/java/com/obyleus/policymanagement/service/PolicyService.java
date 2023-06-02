package com.obyleus.policymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.Policy;
import com.obyleus.policymanagement.repository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;	
	
	public PolicyService(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
	}
	
	@Transactional
    public List<Policy> getAllPolicy() {
        return policyRepository.getAllPolicy();
    }
	
	@Transactional
	public Policy getPolicyById(int id) {
		return policyRepository.findById(id);
	}
	
	@Transactional
	public Policy update(int id, Policy newPolicy) {
		Policy foundPolicy = policyRepository.findById(id);
		if(null != foundPolicy) {
			foundPolicy.setPolicyPremium(newPolicy.getPolicyPremium());
			foundPolicy.setPolicyStatus(newPolicy.getPolicyStatus());
			policyRepository.update(foundPolicy);
				return foundPolicy;
		}else
			
			return null;	
	}	
	
	@Transactional
	public Policy addNewPolicy(Policy newPolicy) {
		policyRepository.addNewPolicy(newPolicy);
		return newPolicy;
	}
}

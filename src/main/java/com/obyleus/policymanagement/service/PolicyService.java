package com.obyleus.policymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.Policy;
import com.obyleus.policymanagement.repository.PolicyRepository;

@Service
public class PolicyService {
	
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
		return policyRepository.getPolicyById(id);
	}
	
	@Transactional
    public Policy updatePolicy(int id, Policy newPolicy) {
    	Policy foundPolicy = policyRepository.getPolicyById(id);
		if(null != foundPolicy) {
			foundPolicy.setPolicyPremium(newPolicy.getPolicyPremium());
			policyRepository.updatePolicy(newPolicy);
			return foundPolicy;
		}else
			return null;
    }
	
	@Transactional
    public Policy updatePolicyStatus(int id, Policy newPolicy) {
    	Policy foundPolicy = policyRepository.getPolicyById(id);
		if(null != foundPolicy) {
			foundPolicy.setPolicyStatus(newPolicy.getPolicyStatus());
			policyRepository.updatePolicyStatus(newPolicy);
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

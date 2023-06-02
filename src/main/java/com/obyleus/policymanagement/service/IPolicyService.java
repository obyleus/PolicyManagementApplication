package com.obyleus.policymanagement.service;

import java.util.List;

import com.obyleus.policymanagement.entity.Policy;

public interface IPolicyService {
	
	List<Policy> getAll();
	Policy getPolicyById(int id);
	//void add(Policy newPolicy);
	//void update(Policy policy);
	
	Policy add(Policy policy);
	Policy update(int id, Policy policy);
}

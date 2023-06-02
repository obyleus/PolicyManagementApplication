package com.obyleus.policymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obyleus.policymanagement.entity.Policy;

public interface IPolicyRepository extends JpaRepository<Policy, Integer> {
	
	List<Policy> findById(int id);
	List<Policy> findByPolicyNumber(String policy_number);
}

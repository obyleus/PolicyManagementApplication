package com.obyleus.policymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obyleus.policymanagement.entity.Policy;

public interface IPolicyRepository extends JpaRepository<Policy, Integer> {

}

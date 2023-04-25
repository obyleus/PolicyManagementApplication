package com.pma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pma.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}

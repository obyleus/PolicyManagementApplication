package com.obyleus.policymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obyleus.policymanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

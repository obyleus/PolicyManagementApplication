package com.obyleus.policymanagement.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.Policy;

import jakarta.persistence.EntityManager;

@Repository
public class PolicyRepository {
	
	private EntityManager entityManager;
	
	public PolicyRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public List<Policy> getAllPolicy() {
		Session session = entityManager.unwrap(Session.class);
		List<Policy> policies = session.createQuery("from Policy", Policy.class).getResultList();
		return policies;
	}
	
	@Transactional
	public Policy findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Policy policy = session.get(Policy.class, id);
		return policy;
	}
	
	@Transactional
	public void addNewPolicy(Policy newPolicy) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(newPolicy);
	}

	@Transactional
	public void update(Policy foundPolicy) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(foundPolicy);
	}
}

package com.obyleus.policymanagement.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.User;

import jakarta.persistence.EntityManager;

@Repository
public class UserRepository {
	
	private EntityManager entityManager;

	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<User> getAllUser() {
		Session session = entityManager.unwrap(Session.class);
		List<User> users = session.createQuery("from User", User.class).getResultList();
		return users;
	}

	@Transactional
	public User getUserById(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Transactional
	public void addNewUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(user);
	}
	
	@Transactional
	public void updateUserById(User foundUser) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(foundUser);
	}
	
	@Transactional
	public void deleteUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.remove(user);
	}
}

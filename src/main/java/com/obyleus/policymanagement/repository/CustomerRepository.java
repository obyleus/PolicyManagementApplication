package com.obyleus.policymanagement.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.obyleus.policymanagement.entity.Customer;

import jakarta.persistence.EntityManager;

@Repository
public class CustomerRepository  {

	private EntityManager entityManager;

	public CustomerRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Customer> getAllCustomer() {
		Session session = entityManager.unwrap(Session.class);
		List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();
		return customers;
	}

	@Transactional
	public Customer getCustomerById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Transactional
	public void addNewCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(customer);
	}
	
	@Transactional
	public void updateCustomerById(Customer foundCustomer) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(foundCustomer);
	}
	
	@Transactional
	public void deleteCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.remove(customer);
	}
}

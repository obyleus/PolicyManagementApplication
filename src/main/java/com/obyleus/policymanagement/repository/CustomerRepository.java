package com.obyleus.policymanagement.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import com.obyleus.policymanagement.entity.Customer;

import jakarta.persistence.EntityManager;

@Repository
public abstract class CustomerRepository implements ICustomerRepository {
	
	private EntityManager entityManager;
	
	public CustomerRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		Session session = entityManager.unwrap(Session.class);
		List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();
		return customers;
	}
	
	@Override
    @Transactional
    public Customer getCustomerById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class, id);
        return customer;
    }
	
	@Override
	@Transactional
	public void addNewCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(customer);
		
	}
	
	@Override
    @Transactional
    public void updateCustomerById(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(id);
        
 
    }
 
    @Override
    @Transactional
    public void deleteCustomerById(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(customer);
    }
	
}

package com.example.demo.DAO_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.DAOinterface.CustomerDao;

import com.example.demo.entity.Customer;

import jakarta.persistence.EntityManager;


@Repository
public class CustomerDaoImpl implements CustomerDao{

	
	@Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    @Override
    public Customer save(Customer customer) {
        return entityManager.merge(customer);
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }
}

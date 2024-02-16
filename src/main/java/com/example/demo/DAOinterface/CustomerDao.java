package com.example.demo.DAOinterface;


import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;



public interface CustomerDao {
	
	List<Customer> getAll();

    Optional<Customer> getById(Long id);

    Customer save(Customer customer);

    void delete(Customer customer);

}

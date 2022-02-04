package com.manoj.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manoj.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	// used to check uniquness of customer based on email in table
	
	Customer findByEmail(String theEmail);

}

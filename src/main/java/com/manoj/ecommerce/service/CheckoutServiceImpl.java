package com.manoj.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.manoj.ecommerce.dao.CustomerRepository;
import com.manoj.ecommerce.dto.Purchase;
import com.manoj.ecommerce.dto.PurchaseResponse;
import com.manoj.ecommerce.entity.Customer;
import com.manoj.ecommerce.entity.Order;
import com.manoj.ecommerce.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	 private CustomerRepository customerRepository;
	 
	 public CheckoutServiceImpl(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		// retrieve the order info from dto
		   Order order = purchase.getOrder();
		// generate tracking number
	       String orderTrackingNumber = generateOrderTrackingNumber();
	       order.setOrderTrackingNumber(orderTrackingNumber);	   
		
        // populate order with orderItems
	       Set<OrderItem> orderItems = purchase.getOrderItems();
	       orderItems.forEach(item -> order.add(item));
		
        // populate order with billingAddress and shippingAddress
	       order.setBillingAddress(purchase.getBillingAddress());
	       order.setShippingAddress(purchase.getShippingAddress());
		
        // populate customer with order
	       Customer customer = purchase.getCustomer();
	       
	       //Check this email belong to already existing customer
	       String theEmail = customer.getEmail();
	       
	       //get customer from DB based on above get email
	       Customer customerFromDB = customerRepository.findByEmail(theEmail);
	       
	       if(customerFromDB !=null)
	       {
	    	   // if we have already customer with this, no need to create a new customer
	    	   customer = customerFromDB;
	       }
	       
	       customer.add(order);
	       
        // save to the database
	       customerRepository.save(customer);
	       
        // return a response
          return new PurchaseResponse(orderTrackingNumber);

		
	}

	private String generateOrderTrackingNumber() {
		
		// generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
	}

}

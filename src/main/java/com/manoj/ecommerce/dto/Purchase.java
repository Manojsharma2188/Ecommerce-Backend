package com.manoj.ecommerce.dto;

import java.util.Set;

import com.manoj.ecommerce.entity.Address;
import com.manoj.ecommerce.entity.Customer;
import com.manoj.ecommerce.entity.Order;
import com.manoj.ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public Order getOrder() {
		return order;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}

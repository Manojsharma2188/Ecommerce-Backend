package com.manoj.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
//@Getter
//@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="total_quantity")
    private int totalQuantity;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    @Column(name="status")
    private String status;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;

    public void add(OrderItem item) {

        if (item != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }

            orderItems.add(item);
            item.setOrder(this);
        }
    }

	public Long getId() {
		return id;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
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
}










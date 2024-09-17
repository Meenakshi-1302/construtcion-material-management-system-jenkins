package com.cart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_tracking")
public class OrderTracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trackingId;
	
	@OneToOne
	private CustomerOrder customerorder;
	
	@Column(name="status")
	private String status;

	public Long getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Long trackingId) {
		this.trackingId = trackingId;
	}

	public CustomerOrder getCustomerorder() {
		return customerorder;
	}

	public void setCustomerorder(CustomerOrder customerorder) {
		this.customerorder = customerorder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

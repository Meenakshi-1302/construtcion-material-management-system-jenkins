package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.OrderTracking;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Long> {
	
	}




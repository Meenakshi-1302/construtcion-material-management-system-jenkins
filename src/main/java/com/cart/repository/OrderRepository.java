package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
}


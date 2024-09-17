package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.model.OrderTracking;
import com.cart.repository.OrderTrackingRepository;

@Service
public class OrderTrackingService {

    @Autowired
    private OrderTrackingRepository orderTrackingRepository;

    @Autowired
    private com.cart.repository.OrderRepository OrderRepository;

    public OrderTracking getOrderTracking(Long id) {
        return orderTrackingRepository.findById(id).orElse(null);
    }

    public List<OrderTracking> getAllOrderTrackings() {
        return orderTrackingRepository.findAll();
    }

    public OrderTracking createOrderTracking(OrderTracking orderTracking) {
        return orderTrackingRepository.save(orderTracking);
    }

    public OrderTracking updateOrderTracking(Long id, OrderTracking orderTracking) {
        if (orderTrackingRepository.existsById(id)) {
            orderTracking.setTrackingId(id);
            return orderTrackingRepository.save(orderTracking);
        }
        return null;
    }

    public void deleteOrderTracking(Long id) {
        orderTrackingRepository.deleteById(id);
    }
}


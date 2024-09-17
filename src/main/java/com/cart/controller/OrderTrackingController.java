package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cart.model.OrderTracking;
import com.cart.service.OrderTrackingService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/ordertracking")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService orderTrackingService;

    @GetMapping
    public List<OrderTracking> getAllOrders() {
        return orderTrackingService.getAllOrderTrackings();
    }

    @GetMapping("/{id}")
    public OrderTracking getOrderById(@PathVariable Long id) {
        return orderTrackingService.getOrderTracking(id);
    }

    @PostMapping
    public OrderTracking createOrder(@RequestBody OrderTracking orderTracking) {
        return orderTrackingService.createOrderTracking(orderTracking);
    }

    @PutMapping("/{id}")
    public OrderTracking updateOrder(@PathVariable Long id, @RequestBody OrderTracking orderTracking) {
        return orderTrackingService.updateOrderTracking(id, orderTracking);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderTrackingService.deleteOrderTracking(id);
    }
}


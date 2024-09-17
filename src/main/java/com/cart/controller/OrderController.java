package com.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.CustomerOrder;
import com.cart.model.OrderRequest;
import com.cart.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
    private OrderService orderService;

    // Endpoint to create a new order
    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            CustomerOrder order = orderService.createOrder(orderRequest);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CustomerOrder>> getAllOrders() {
        List<CustomerOrder> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> updateOrderStatus(@PathVariable Long id, @RequestBody CustomerOrder updatedOrder) {
        Optional<CustomerOrder> existingOrderOptional = orderService.getOrderById(id);
        if (existingOrderOptional.isPresent()) {
            CustomerOrder existingOrder = existingOrderOptional.get();
            existingOrder.setStatus(updatedOrder.getStatus());
            CustomerOrder updated = orderService.updateOrder(existingOrder);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

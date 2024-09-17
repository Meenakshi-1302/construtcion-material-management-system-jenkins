package com.cart.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.model.CustomerOrder;
import com.cart.model.OrderItem;
import com.cart.model.OrderItemRequest;
import com.cart.model.OrderRequest;
import com.cart.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public CustomerOrder createOrder(OrderRequest orderRequest) {
        // Convert OrderRequest to Order entity
        CustomerOrder order = new CustomerOrder();
        order.setOrderId(orderRequest.getOrderId());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setTimeOfPurchase(orderRequest.getTimeOfPurchase());
        order.setStatus(null);

        // Convert OrderItemRequest list to OrderItem list
        List<OrderItem> items = new ArrayList<>();
        for (OrderItemRequest itemRequest : orderRequest.getItems()) {
            OrderItem item = new OrderItem();
            item.setName(itemRequest.getName());
            item.setDescription(itemRequest.getDescription());
            item.setUnitPrice(itemRequest.getUnitPrice());
            item.setQuantity(itemRequest.getQuantity());
            item.setOrder(order); // Set the order reference
            items.add(item);
        }
        order.setItems(items);
        

        // Save order to database
        return orderRepository.save(order);
        
        
    }
    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
}
    public Optional<CustomerOrder> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    public CustomerOrder updateOrder(CustomerOrder order) {
        return orderRepository.save(order);
}
}



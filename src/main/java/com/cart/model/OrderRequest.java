package com.cart.model;

import java.util.List;

public class OrderRequest {

    private String orderId;
    private double totalAmount;
    private String timeOfPurchase;
    private List<OrderItemRequest> items;

    // Getters and setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(String timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}

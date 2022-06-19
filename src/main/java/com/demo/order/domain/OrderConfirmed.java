package com.demo.order.domain;

import com.demo.order.AbstractEvent;

public class OrderConfirmed extends AbstractEvent{
    
    Long id;
    OrderStatus status;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    
}

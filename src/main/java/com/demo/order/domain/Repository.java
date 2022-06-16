package com.demo.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Order, Long>{
    
}

package com.demo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.order.domain.Order;
import com.demo.order.domain.OrderRepository;
import com.demo.order.domain.OrderStatus;

@SpringBootApplication
public class OrderApplication {

	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(OrderApplication.class, args);

	}

	@Autowired
	OrderRepository orderRepository;

	// 손님이 주문 취소 요청
	@RequestMapping(method = RequestMethod.PUT, path="orders/{id}/cancel")
    public void cancelOrder(@PathVariable("id") Long id){
		Order order = orderRepository.findById(id).get();
		if(order.getStatus() != OrderStatus.조리중){
            order.setStatus(OrderStatus.주문취소됨);
			orderRepository.save(order);
            // 주방에 주문 정보 전송 kafka
        } 
    }

	@RequestMapping(method = RequestMethod.POST, path="orders/order")
	public void order(){
		

	}



}

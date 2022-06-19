package com.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.domain.Order;
import com.demo.order.domain.OrderRepository;
import com.demo.order.domain.OrderStatus;

@RestController
@RequestMapping(value="/orders")
@Transactional
public class OrderController {
    
    @Autowired
    OrderRepository orderRepository;


	// 손님이 주문 취소 요청
	@RequestMapping(method = RequestMethod.PATCH, path="orders/{id}/cancel")
    public void cancelOrder(@PathVariable("id") Long id){
		Order order = orderRepository.findById(id).get();
		if(order.getStatus() == OrderStatus.주문확인중){
            order.setStatus(OrderStatus.주문취소됨);
			orderRepository.save(order);
        }else{
			System.out.println( "조리가 시작되어 취소할 수 없습니다.");
		}
    }

}

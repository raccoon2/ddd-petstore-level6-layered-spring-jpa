package com.demo.order.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


import com.demo.order.OrderApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name="order_table")
public class Order {
    
    @Id @GeneratedValue
    Long id;

    int tableNo;
    int storeId;
    int price;
    Date newDate;
    int holeflag;
    OrderStatus status;
    
    @ElementCollection
    @CollectionTable (
        name="ORDER_ITEM",
        joinColumns = @JoinColumn(name="id")
    )
    List<OrderItem> menus = new ArrayList<OrderItem>();

//     //주문한 다음 주방에 카프카 전송
//     @PostPersist
//     public void onPostPersist(){
//         // view를 위해 send
//         ObjectMapper objectMapper = new ObjectMapper();
//         String json = null;
//         try {
//             json = objectMapper.writeValueAsString(this);
//         } catch (JsonProcessingException e) {
//             throw new RuntimeException("JSON format exception", e);
//         }
// /*         KafkaProcessor processor = ItemApplication.applicationContext.getBean(KafkaProcessor.class);
//         MessageChannel outputChannel = processor.outboundTopic();
//         outputChannel.send(org.springframework.integration.support.MessageBuilder
//                 .withPayload(json)
//                 .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                 .build());
// */
//         System.out.println("@@@@@@@ Ordered to Json @@@@@@@");
//         System.out.println(ttoJson());
//     }


    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateStatus(OrderConfirmed orderConfirmed) {
        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);
        */

        /** Example 2:  finding and process
        */
        
        repository().findById(orderConfirmed.getId()).ifPresent(order->{
            order.setStatus(orderConfirmed.getStatus());
            repository().save(order);
        }); // 주문됨, 주문취소됨
        
    }

    public List<OrderItem> getOrderItems() {
        return menus;
    }
    public void setOrderItems(List<OrderItem> menus) {
        this.menus = menus;
    }
    public int getTableNo() {
        return tableNo;
    }
    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Date getNewDate() {
        return newDate;
    }
    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }
    public int getHoleflag() {
        return holeflag;
    }
    public void setHoleflag(int holeflag) {
        this.holeflag = holeflag;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    


    
}

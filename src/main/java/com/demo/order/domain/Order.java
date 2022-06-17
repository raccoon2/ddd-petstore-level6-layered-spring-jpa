package com.demo.order.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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

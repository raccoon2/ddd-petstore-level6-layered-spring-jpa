package com.demo.order.domain;

import javax.persistence.*;

@Embeddable
public class Menu {

    
    String menuId;
    int quantity;
    

    public String getMenuId() {
        return menuId;1
    }


    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}

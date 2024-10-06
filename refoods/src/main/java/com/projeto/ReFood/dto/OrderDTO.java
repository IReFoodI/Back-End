package com.projeto.ReFood.dto;


import com.projeto.ReFood.model.Address;
import com.projeto.ReFood.model.EnumOrderStatus;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;

import lombok.Data;
import java.util.Date;

@Data
public class OrderDTO {
    
    private int id_order;
    private Date order_date;
    private EnumOrderStatus order_status;
    private float total_value;
    
    private User fkid_userOrder;
    private Restaurant fkid_restaurantOrder;
    private Address fkid_addressOrder;
}

package com.projeto.ReFood.dto;


import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.Product;

import lombok.Data;

@Data
public class ItemsOrdersDTO {
    
    private int id_items_orders;
    private int amount;
    private float unit_value;
    private float subtotal;
    
    private Order fkid_orderItemsOrders;
    private Product fkid_product_itemsOders;

}

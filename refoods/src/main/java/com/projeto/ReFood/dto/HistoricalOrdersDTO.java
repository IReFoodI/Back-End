package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumOrderStatus;
import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;

import lombok.Data;
import java.util.Date;

@Data
public class HistoricalOrdersDTO {

  private int id_history;
  private EnumOrderStatus order_status;
  private Date date_mod;

  private Order fkid_orderHistoricalOrders;
  private Restaurant fkid_restaurantHistoricalOrders;
  private User fkid_userHistoricalOrders;

}

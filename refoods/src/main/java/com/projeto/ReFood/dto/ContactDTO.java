package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurant;
import lombok.Data;

@Data
public class ContactDTO {

  private int id_contact;
  private String description;
  private String phone;

  private Restaurant fkid_restaurant_contact;

}

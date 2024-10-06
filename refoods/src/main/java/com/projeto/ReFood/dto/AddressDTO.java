package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;

import lombok.Data;

@Data
public class AddressDTO {

  private int id_address;
  private String cep;
  private String state;
  private String district;
  private String street;
  private String number;
  private String complement;
  private String address_type;
  private boolean standard; // default = false

  private User fkid_user_address;
  private Restaurant fkid_restaurant_address;

}

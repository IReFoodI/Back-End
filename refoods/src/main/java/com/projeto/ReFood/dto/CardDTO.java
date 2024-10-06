package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Transaction;
import com.projeto.ReFood.model.User;

import lombok.Data;

@Data
public class CardDTO {

  private int id_card;
  private String number;
  private String validity;
  private String cvv;

  private User fkid_user_card;
  private Transaction cardTransaction;
}

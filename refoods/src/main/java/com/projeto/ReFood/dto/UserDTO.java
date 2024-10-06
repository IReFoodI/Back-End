package com.projeto.ReFood.dto;

import lombok.Data;
import java.util.Date;

@Data
public class UserDTO {

  private int id_user;
  private String name;
  private String surname;
  private String cpf;
  private String email;
  private String phone;
  private String password;
  private Date date_creation;
  private Date last_login;

}

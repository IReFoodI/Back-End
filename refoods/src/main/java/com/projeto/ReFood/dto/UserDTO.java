package com.projeto.ReFood.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {

  private int id_user;
  private String name;
  private String surname;
  private String cpf;
  private String email;
  private String phone;
  private String password;
  private LocalDateTime  date_creation;
  private LocalDateTime  last_login;

}

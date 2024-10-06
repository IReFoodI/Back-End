package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;
import lombok.Data;
import java.util.Date;

@Data
public class FavoriteDTO {

  private int id_favorite;
  private Date addition_date;

  private User fkid_user_fav;
  private Restaurant fkid_restaurantFav;

}

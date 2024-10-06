package com.projeto.ReFood.dto;

import lombok.Data;
import java.util.Date;

@Data
public class RestaurantDTO {
    
    private int id_restaurant;
    private String cnpj;
    private String fantasy;
    private String email;
    private String password;
    private Date date_creation;
    private String url_banner;
    private String url_logo;
    private int quantity_evaluations; //default 0
    private int total_evaluations; //default 0
    private float average_rating; //default 0

}

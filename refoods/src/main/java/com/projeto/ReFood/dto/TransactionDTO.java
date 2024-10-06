package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Card;
import com.projeto.ReFood.model.EnumOrderStatus;
import com.projeto.ReFood.model.Order;

import lombok.Data;
import java.util.Date;

@Data
public class TransactionDTO {
    
    private int id_transaction;
    private Date transaction_date;
    private float transaction_value;
    private EnumOrderStatus transaction_status;
    
    private Card fkid_card_transaction;
    private Order fkid_orderTransaction;

}

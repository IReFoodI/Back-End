package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurante;
import lombok.Data;
import java.util.Date;

@Data
public class ProdutoDTO {
    
    private int id_produto;
    private String nome_prod;
    private String descricao_prod;
    private String url_img_prod;
    private float preco_prod;
    private int desc_perc; //% check: descontoPerc >= 0 and descontoPerc <= 100
    private Date data_adicao;
    private boolean ativo;
    
    private Restaurante fk_id_restaurante;

}

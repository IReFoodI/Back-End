package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurante;
import com.projeto.ReFood.model.Usuario;
import lombok.Data;
import java.util.Date;

@Data
public class FavoritoDTO {
    
    private int id_favoritos;
    private Date data_adicao;
    
    private Usuario fk_id_usuarios;
    private Restaurante fk_id_restaurantes;

}

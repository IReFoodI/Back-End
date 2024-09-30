package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Restaurante;
import com.projeto.ReFood.model.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
public class AvaliacaoDTO {

    private int id_avaliacoes;
    private int nota_avaliacao;
    private Date data_avaliacao;
    private String comentario_avaliacao;

//    private Usuario fk_id_usuarios;
//    private Restaurante fk_id_restaurantes;

}

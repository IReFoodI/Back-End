package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.Usuario;
import lombok.Data;
import java.util.Date;

@Data
public class NotificacaoDTO {
    
    private int id_notificacoes;
    private String msg_notificacao;
    private boolean msg_lida;
    private Date data_envio;
    
    private Usuario fk_id_usuarios;

}

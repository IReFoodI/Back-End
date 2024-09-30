package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="notificacoes")
public class Notificacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_notificacoes;
    @Column
    private String msg_notificacao;
    @Column(nullable = false)
    private boolean msg_lida;
    @Column(nullable = false)
    private Date data_envio;
    
    @JoinColumn(name = "fk_id_usuarios", referencedColumnName = "id_usuario")
    private Usuario fk_id_usuarios;

}

package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.NotificacaoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {
    
    @Autowired
    private NotificacaoService notificacaoService;
    
    @GetMapping
    public List<NotificacaoDTO> getAllNotificacoes() {
        return notificacaoService.getAllNotificacoes();
    }
    
    @GetMapping("/{id_notificacao}")
    public ResponseEntity<NotificacaoDTO> getNotificacaoById(@PathVariable int id_notificacao) {
        NotificacaoDTO notificacaoDTO = notificacaoService.getNotificacaoById(id_notificacao);
        
        return notificacaoDTO != null ? ResponseEntity.ok(notificacaoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public NotificacaoDTO createNotificacao(@RequestBody NotificacaoDTO notificacaoDTO) {
        return notificacaoService.createNotificacao(notificacaoDTO);
    }
    
    @PutMapping("/{id_notificacao}")
    public ResponseEntity<NotificacaoDTO> updateNotificacao(@PathVariable int id_notificacao, @RequestBody NotificacaoDTO notificacaoDTO) {
        NotificacaoDTO updateNotificacao = notificacaoService.updateNotificacao(id_notificacao, notificacaoDTO);
        
        return updateNotificacao != null ? ResponseEntity.ok(updateNotificacao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_notificacao}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable int id_notificacao) {
        notificacaoService.deleteNotificacao(id_notificacao);
        
        return ResponseEntity.noContent().build();
    }
}

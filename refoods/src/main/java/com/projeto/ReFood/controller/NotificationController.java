package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.NotificationDTO;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping
    public List<NotificationDTO> getAllNotificacoes() {
        return notificationService.getAllNotificacoes();
    }
    
    @GetMapping("/{id_notificacao}")
    public ResponseEntity<NotificationDTO> getNotificacaoById(@PathVariable int id_notificacao) {
        NotificationDTO notificationDTO = notificationService.getNotificacaoById(id_notificacao);
        
        return notificationDTO != null ? ResponseEntity.ok(notificationDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public NotificationDTO createNotificacao(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.createNotificacao(notificationDTO);
    }
    
    @PutMapping("/{id_notificacao}")
    public ResponseEntity<NotificationDTO> updateNotificacao(@PathVariable int id_notificacao, @RequestBody NotificationDTO notificationDTO) {
        NotificationDTO updateNotificacao = notificationService.updateNotificacao(id_notificacao, notificationDTO);
        
        return updateNotificacao != null ? ResponseEntity.ok(updateNotificacao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_notificacao}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable int id_notificacao) {
        notificationService.deleteNotificacao(id_notificacao);
        
        return ResponseEntity.noContent().build();
    }
}

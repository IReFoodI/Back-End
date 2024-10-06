package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.NotificationDTO;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping
    public List<NotificationDTO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
    
    @GetMapping("/{id_notification}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable int id_notification) {
        NotificationDTO notificationDTO = notificationService.getNotificationById(id_notification);
        
        return notificationDTO != null ? ResponseEntity.ok(notificationDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public NotificationDTO createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.createNotification(notificationDTO);
    }
    
    @PutMapping("/{id_notification}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable int id_notification, @RequestBody NotificationDTO notificationDTO) {
        NotificationDTO updateNotification = notificationService.updateNotification(id_notification, notificationDTO);
        
        return updateNotification != null ? ResponseEntity.ok(updateNotification) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_notification}")
    public ResponseEntity<Void> deleteNotification(@PathVariable int id_notification) {
        notificationService.deleteNotification(id_notification);
        
        return ResponseEntity.noContent().build();
    }
}

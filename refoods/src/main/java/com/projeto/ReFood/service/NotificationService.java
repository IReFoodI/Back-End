package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.NotificationDTO;
import com.projeto.ReFood.model.Notification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public NotificationDTO getNotificationById(int idNotification) {
        Optional<Notification> notification = notificationRepository.findById(idNotification);
        return notification.map(this::convertToDTO).orElse(null);
    }
    
    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        
        notification.setMsg_notification(notificationDTO.getMsg_notification());
        notification.setSend_date(notificationDTO.getSend_date());
        notificationRepository.save(notification);
        return convertToDTO(notification);
    }
    
    public NotificationDTO updateNotification(int idNotification, NotificationDTO notificationDTO) {
        Optional<Notification> notificationOptional = notificationRepository.findById(idNotification);
        
        if (notificationOptional.isPresent()) {
            Notification notification = notificationOptional.get();
            
            notification.setMsg_notification(notificationDTO.getMsg_notification());
            notification.setSend_date(notificationDTO.getSend_date());
            
            notificationRepository.save(notification);
            
            return convertToDTO(notification);
        }
        
        return null;
    }
    
    public void deleteNotification(int idNotification) {
        notificationRepository.deleteById(idNotification);
    }
    
    private NotificationDTO convertToDTO(Notification notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        
        notificationDTO.setId_notification(notification.getId_notification());
        notificationDTO.setMsg_notification(notification.getMsg_notification());
        notificationDTO.setSend_date(notification.getSend_date());
        
        return notificationDTO;
    }
}

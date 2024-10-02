package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="users_notifications")
public class UserNotification {
    
    @EmbeddedId
    private UserNotificationId id_users_notifications;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_user", insertable = false, updatable = false)
    private User fk_id_user;
    @ManyToOne
    @JoinColumn(name = "fk_id_notification", insertable = false, updatable = false)
    private Notification fk_id_notification;
}

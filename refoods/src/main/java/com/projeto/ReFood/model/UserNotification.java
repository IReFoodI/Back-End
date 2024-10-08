package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users_notifications")
public class UserNotification {

  @EmbeddedId
  private UserNotificationId id;

  // @ManyToOne
  // @JoinColumn(name = "fk_id_user", insertable = false, updatable = false)
  // private User user;

  @ManyToOne
  @JoinColumn(name = "fk_id_notification", insertable = false, updatable = false)
  private Notification notification;

}

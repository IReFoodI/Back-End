package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_notifications")
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notification_id") // not blank
  private Long notificationId;

  @NotBlank(message = "A mensagem da notificação não pode estar vazia.")
  @Column(nullable = false)
  private String msgNotification;

  @Column(nullable = false)
  private boolean msgRead = false; // Padrão é não lida

  @NotNull(message = "A data de envio não pode ser nula.")
  @Column(nullable = false)
  private LocalDateTime sendDate;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", nullable = false)
  private Restaurant restaurant;
}

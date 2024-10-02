package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.UserNotification;
import com.projeto.ReFood.model.UserNotificationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotification, UserNotificationId> {}

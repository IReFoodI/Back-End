package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}

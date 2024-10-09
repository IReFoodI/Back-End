package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.UserNotificationIdDTO;
import com.projeto.ReFood.service.UserNotificationIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usernotifications")
public class UserNotificationIdController {

    @Autowired
    private UserNotificationIdService userNotificationIdService;

    @GetMapping
    public List<UserNotificationIdDTO> getAllUserNotifications() {
        return userNotificationIdService.getAllUserNotifications();
    }

    @GetMapping("/{fk_id_user}/{fk_id_notification}")
    public ResponseEntity<UserNotificationIdDTO> getUserNotificationById(@PathVariable int fk_id_user, @PathVariable int fk_id_notification) {
        UserNotificationIdDTO userNotificationIdDTO = userNotificationIdService.getUserNotificationById(fk_id_user, fk_id_notification);
        return userNotificationIdDTO != null ? ResponseEntity.ok(userNotificationIdDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UserNotificationIdDTO createUserNotification(@RequestBody UserNotificationIdDTO userNotificationIdDTO) {
        return userNotificationIdService.createUserNotification(userNotificationIdDTO);
    }

    @PutMapping("/{fk_id_user}/{fk_id_notification}")
    public ResponseEntity<UserNotificationIdDTO> updateUserNotification(
            @PathVariable int fk_id_user,
            @PathVariable int fk_id_notification,
            @RequestBody UserNotificationIdDTO userNotificationIdDTO) {
        UserNotificationIdDTO updatedUserNotification = userNotificationIdService.updateUserNotification(fk_id_user, fk_id_notification, userNotificationIdDTO);
        return updatedUserNotification != null ? ResponseEntity.ok(updatedUserNotification) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{fk_id_user}/{fk_id_notification}")
    public ResponseEntity<Void> deleteUserNotification(@PathVariable int fk_id_user, @PathVariable int fk_id_notification) {
        userNotificationIdService.deleteUserNotification(fk_id_user, fk_id_notification);
        return ResponseEntity.noContent().build();
    }
}

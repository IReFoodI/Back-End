package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.UserNotificationIdDTO;
import com.projeto.ReFood.model.UserNotification;
import com.projeto.ReFood.model.UserNotificationId;
import com.projeto.ReFood.repository.UserNotificationIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserNotificationIdService {
  @Autowired
  private UserNotificationIdRepository userNotificationRepository;

  public List<UserNotificationIdDTO> getAllUserNotifications() {
    return userNotificationRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  public UserNotificationIdDTO getUserNotificationById(int fk_id_user, int fk_id_notification) {
    UserNotificationId userNotificationId = new UserNotificationId(fk_id_user, fk_id_notification);
    Optional<UserNotification> userNotification = userNotificationRepository.findById(userNotificationId);
    return userNotification.map(this::convertToDTO).orElse(null);
  }

  public UserNotificationIdDTO createUserNotification(UserNotificationIdDTO userNotificationIdDTO) {
    UserNotification userNotification = new UserNotification();
    UserNotificationId userNotificationId = new UserNotificationId(
        userNotificationIdDTO.getFk_id_user(),
        userNotificationIdDTO.getFk_id_notification());

    userNotification.setId(userNotificationId);

    userNotificationRepository.save(userNotification);
    return convertToDTO(userNotification);
  }

  public UserNotificationIdDTO updateUserNotification(int fk_id_user, int fk_id_notification,
      UserNotificationIdDTO userNotificationIdDTO) {
    UserNotificationId userNotificationId = new UserNotificationId(fk_id_user, fk_id_notification);
    Optional<UserNotification> userNotificationOptional = userNotificationRepository.findById(userNotificationId);

    if (userNotificationOptional.isPresent()) {
      UserNotification userNotification = userNotificationOptional.get();

      // Atualize os campos necessários
      userNotificationRepository.save(userNotification);

      return convertToDTO(userNotification);
    }

    return null;
  }

  public void deleteUserNotification(int fk_id_user, int fk_id_notification) {
    UserNotificationId userNotificationId = new UserNotificationId(fk_id_user, fk_id_notification);
    userNotificationRepository.deleteById(userNotificationId);
  }

  private UserNotificationIdDTO convertToDTO(UserNotification userNotification) {
    UserNotificationIdDTO userNotificationIdDTO = new UserNotificationIdDTO();
    userNotificationIdDTO.setFk_id_user(userNotification.getId().getFk_id_user());
    userNotificationIdDTO.setFk_id_notification(userNotification.getId().getFk_id_notification());
    return userNotificationIdDTO;
  }
}
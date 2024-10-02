package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.UserNotificationDTO;
import com.projeto.ReFood.model.UserNotification;
import com.projeto.ReFood.repository.UserNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserNotificationService {
    @Autowired
    private UserNotificationRepository userNotificationRepository;
    
    public List<UserNotificationDTO> getAllUserNotifications(){
        return userNotificationRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public UserNotificationDTO getUserNotificationById(int fkid_user, int fkid_notification){
        Optional<UserNotification> userNotification = userNotificationRepository.findById(fkid_user, fkid_notification);
        return userNotification.map(this::convertToDTO).orElse(null);
    }
    
    public UserNotificationDTO createUserNotification(UserNotificationDTO userNotificationDTO){
        UserNotification userNotification = new UserNotification();
        
        avaliacao.setNota_avaliacao(avaliacaoDTO.getNota_avaliacao());
        avaliacao.setData_avaliacao(avaliacaoDTO.getData_avaliacao());
        avaliacao.setComentario_avaliacao(avaliacaoDTO.getComentario_avaliacao());
        
        userNotificationRepository.save(userNotification);
        return convertToDTO(userNotification);
    }
    
    public UserNotificationDTO updateUserNotification(int fkid_user, int fkid_notification, UserNotificationDTO userNotificationDTO){
        Optional<UserNotification> userNotificationOptional = userNotificationRepository.findById(id_avaliacao);
        
        if(userNotificationOptional.isPresent()){
            UserNotification userNotification = userNotificationOptional.get();
            
            avaliacao.setNota_avaliacao(avaliacaoDTO.getNota_avaliacao());
            avaliacao.setData_avaliacao(avaliacaoDTO.getData_avaliacao());
            avaliacao.setComentario_avaliacao(avaliacaoDTO.getComentario_avaliacao());
            userNotificationRepository.save(userNotification);
            
            return convertToDTO(userNotification);
        }
        
        return null;
    }
    
    public void deleteUserNotification(int fkid_user, int fkid_notification){
        userNotificationRepository.deleteById(fkid_user, fkid_notification);
    }
    
    private UserNotificationDTO convertToDTO(UserNotification userNotification){
        UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
        
        avaliacaoDTO.setId_avaliacoes(avaliacao.getId_avaliacoes());
        avaliacaoDTO.setNota_avaliacao(avaliacao.getNota_avaliacao());
        avaliacaoDTO.setData_avaliacao(avaliacao.getData_avaliacao());
        avaliacaoDTO.setComentario_avaliacao(avaliacao.getComentario_avaliacao());
        
        return userNotificationDTO;
    }
}

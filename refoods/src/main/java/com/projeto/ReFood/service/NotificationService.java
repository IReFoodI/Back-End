package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.NotificationDTO;
import com.projeto.ReFood.model.Notificacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    public List<NotificationDTO> getAllNotificacoes() {
        return notificationRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public NotificationDTO getNotificacaoById(int idNotificacao) {
        Optional<Notificacao> notificacao = notificationRepository.findById(idNotificacao);
        return notificacao.map(this::convertToDTO).orElse(null);
    }
    
    public NotificationDTO createNotificacao(NotificationDTO notificationDTO) {
        Notificacao notificacao = new Notificacao();
        
        notificacao.setMensagem(notificationDTO.getMensagem());
        notificacao.setDataEnvio(notificationDTO.getDataEnvio());
        notificationRepository.save(notificacao);
        return convertToDTO(notificacao);
    }
    
    public NotificationDTO updateNotificacao(int idNotificacao, NotificationDTO notificationDTO) {
        Optional<Notificacao> notificacaoOptional = notificationRepository.findById(idNotificacao);
        
        if (notificacaoOptional.isPresent()) {
            Notificacao notificacao = notificacaoOptional.get();
            
            notificacao.setMensagem(notificationDTO.getMensagem());
            notificacao.setDataEnvio(notificationDTO.getDataEnvio());
            
            notificationRepository.save(notificacao);
            
            return convertToDTO(notificacao);
        }
        
        return null;
    }
    
    public void deleteNotificacao(int idNotificacao) {
        notificationRepository.deleteById(idNotificacao);
    }
    
    private NotificationDTO convertToDTO(Notificacao notificacao) {
        NotificationDTO notificationDTO = new NotificationDTO();
        
        notificationDTO.setIdNotificacao(notificacao.getIdNotificacao());
        notificationDTO.setMensagem(notificacao.getMensagem());
        notificationDTO.setDataEnvio(notificacao.getDataEnvio());
        
        return notificationDTO;
    }
}

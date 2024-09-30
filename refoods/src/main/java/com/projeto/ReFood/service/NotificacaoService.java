package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.NotificacaoDTO;
import com.projeto.ReFood.model.Notificacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaoService {
    
    @Autowired
    private NotificacaoRepository notificacaoRepository;
    
    public List<NotificacaoDTO> getAllNotificacoes() {
        return notificacaoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public NotificacaoDTO getNotificacaoById(int idNotificacao) {
        Optional<Notificacao> notificacao = notificacaoRepository.findById(idNotificacao);
        return notificacao.map(this::convertToDTO).orElse(null);
    }
    
    public NotificacaoDTO createNotificacao(NotificacaoDTO notificacaoDTO) {
        Notificacao notificacao = new Notificacao();
        
        notificacao.setMensagem(notificacaoDTO.getMensagem());
        notificacao.setDataEnvio(notificacaoDTO.getDataEnvio());
        notificacaoRepository.save(notificacao);
        return convertToDTO(notificacao);
    }
    
    public NotificacaoDTO updateNotificacao(int idNotificacao, NotificacaoDTO notificacaoDTO) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(idNotificacao);
        
        if (notificacaoOptional.isPresent()) {
            Notificacao notificacao = notificacaoOptional.get();
            
            notificacao.setMensagem(notificacaoDTO.getMensagem());
            notificacao.setDataEnvio(notificacaoDTO.getDataEnvio());
            
            notificacaoRepository.save(notificacao);
            
            return convertToDTO(notificacao);
        }
        
        return null;
    }
    
    public void deleteNotificacao(int idNotificacao) {
        notificacaoRepository.deleteById(idNotificacao);
    }
    
    private NotificacaoDTO convertToDTO(Notificacao notificacao) {
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO();
        
        notificacaoDTO.setIdNotificacao(notificacao.getIdNotificacao());
        notificacaoDTO.setMensagem(notificacao.getMensagem());
        notificacaoDTO.setDataEnvio(notificacao.getDataEnvio());
        
        return notificacaoDTO;
    }
}

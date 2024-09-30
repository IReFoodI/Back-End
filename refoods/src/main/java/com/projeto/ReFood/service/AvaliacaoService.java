package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.AvaliacaoDTO;
import com.projeto.ReFood.model.Avaliacao;
import com.projeto.ReFood.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {
    
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
    public List<AvaliacaoDTO> getAllAvaliacoes(){
        return avaliacaoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public AvaliacaoDTO getAvaliacaoById(int id_avaliacao){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id_avaliacao);
        return avaliacao.map(this::convertToDTO).orElse(null);
    }
    
    public AvaliacaoDTO createAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = new Avaliacao();
        
        avaliacao.setNota_avaliacao(avaliacaoDTO.getNota_avaliacao());
        avaliacao.setData_avaliacao(avaliacaoDTO.getData_avaliacao());
        avaliacao.setComentario_avaliacao(avaliacaoDTO.getComentario_avaliacao());
        avaliacaoRepository.save(avaliacao);
        return convertToDTO(avaliacao);
    }
    
    public AvaliacaoDTO updateAvaliacao(int id_avaliacao, AvaliacaoDTO avaliacaoDTO){
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id_avaliacao);
        
        if(avaliacaoOptional.isPresent()){
            Avaliacao avaliacao = avaliacaoOptional.get();

            avaliacao.setNota_avaliacao(avaliacaoDTO.getNota_avaliacao());
            avaliacao.setData_avaliacao(avaliacaoDTO.getData_avaliacao());
            avaliacao.setComentario_avaliacao(avaliacaoDTO.getComentario_avaliacao());
            avaliacaoRepository.save(avaliacao);
            
            return convertToDTO(avaliacao);
        }
        
        return null;
    }
    
    public void deleteAvaliacao(int id_avaliacao){
        avaliacaoRepository.deleteById(id_avaliacao);
    }
    
    private AvaliacaoDTO convertToDTO(Avaliacao avaliacao){
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        
        avaliacaoDTO.setId_avaliacoes(avaliacao.getId_avaliacoes());
        avaliacaoDTO.setNota_avaliacao(avaliacao.getNota_avaliacao());
        avaliacaoDTO.setData_avaliacao(avaliacao.getData_avaliacao());
        avaliacaoDTO.setComentario_avaliacao(avaliacao.getComentario_avaliacao());
        
        return avaliacaoDTO;
    }
}
package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.ReviewsDTO;
import com.projeto.ReFood.model.Avaliacao;
import com.projeto.ReFood.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewsService {
    
    @Autowired
    private ReviewsRepository reviewsRepository;
    
    public List<ReviewsDTO> getAllAvaliacoes(){
        return reviewsRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ReviewsDTO getAvaliacaoById(int id_avaliacao){
        Optional<Avaliacao> avaliacao = reviewsRepository.findById(id_avaliacao);
        return avaliacao.map(this::convertToDTO).orElse(null);
    }
    
    public ReviewsDTO createAvaliacao(ReviewsDTO reviewsDTO){
        Avaliacao avaliacao = new Avaliacao();
        
        avaliacao.setNota_avaliacao(reviewsDTO.getNota_avaliacao());
        avaliacao.setData_avaliacao(reviewsDTO.getData_avaliacao());
        avaliacao.setComentario_avaliacao(reviewsDTO.getComentario_avaliacao());
        reviewsRepository.save(avaliacao);
        return convertToDTO(avaliacao);
    }
    
    public ReviewsDTO updateAvaliacao(int id_avaliacao, ReviewsDTO reviewsDTO){
        Optional<Avaliacao> avaliacaoOptional = reviewsRepository.findById(id_avaliacao);
        
        if(avaliacaoOptional.isPresent()){
            Avaliacao avaliacao = avaliacaoOptional.get();

            avaliacao.setNota_avaliacao(reviewsDTO.getNota_avaliacao());
            avaliacao.setData_avaliacao(reviewsDTO.getData_avaliacao());
            avaliacao.setComentario_avaliacao(reviewsDTO.getComentario_avaliacao());
            reviewsRepository.save(avaliacao);
            
            return convertToDTO(avaliacao);
        }
        
        return null;
    }
    
    public void deleteAvaliacao(int id_avaliacao){
        reviewsRepository.deleteById(id_avaliacao);
    }
    
    private ReviewsDTO convertToDTO(Avaliacao avaliacao){
        ReviewsDTO reviewsDTO = new ReviewsDTO();
        
        reviewsDTO.setId_avaliacoes(avaliacao.getId_avaliacoes());
        reviewsDTO.setNota_avaliacao(avaliacao.getNota_avaliacao());
        reviewsDTO.setData_avaliacao(avaliacao.getData_avaliacao());
        reviewsDTO.setComentario_avaliacao(avaliacao.getComentario_avaliacao());
        
        return reviewsDTO;
    }
}
package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.FavoriteDTO;
import com.projeto.ReFood.model.Favorito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;
    
    public List<FavoriteDTO> getAllFavoritos() {
        return favoriteRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public FavoriteDTO getFavoritoById(int idFavorito) {
        Optional<Favorito> favorito = favoriteRepository.findById(idFavorito);
        return favorito.map(this::convertToDTO).orElse(null);
    }
    
    public FavoriteDTO createFavorito(FavoriteDTO favoriteDTO) {
        Favorito favorito = new Favorito();
        
        favorito.setNome(favoriteDTO.getNome());
        favorito.setDescricao(favoriteDTO.getDescricao());
        favoriteRepository.save(favorito);
        return convertToDTO(favorito);
    }
    
    public FavoriteDTO updateFavorito(int idFavorito, FavoriteDTO favoriteDTO) {
        Optional<Favorito> favoritoOptional = favoriteRepository.findById(idFavorito);
        
        if (favoritoOptional.isPresent()) {
            Favorito favorito = favoritoOptional.get();
            
            favorito.setNome(favoriteDTO.getNome());
            favorito.setDescricao(favoriteDTO.getDescricao());
            
            favoriteRepository.save(favorito);
            
            return convertToDTO(favorito);
        }
        
        return null;
    }
    
    public void deleteFavorito(int idFavorito) {
        favoriteRepository.deleteById(idFavorito);
    }
    
    private FavoriteDTO convertToDTO(Favorito favorito) {
        FavoriteDTO favoriteDTO = new FavoriteDTO();
        
        favoriteDTO.setIdFavorito(favorito.getIdFavorito());
        favoriteDTO.setNome(favorito.getNome());
        favoriteDTO.setDescricao(favorito.getDescricao());
        
        return favoriteDTO;
    }
}

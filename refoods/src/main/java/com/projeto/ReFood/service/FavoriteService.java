package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.FavoriteDTO;
import com.projeto.ReFood.model.Favorite;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;
    
    public List<FavoriteDTO> getAllFavorites() {
        return favoriteRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public FavoriteDTO getFavoriteById(int idFavorite) {
        Optional<Favorite> favorite = favoriteRepository.findById(idFavorite);
        return favorite.map(this::convertToDTO).orElse(null);
    }
    
    public FavoriteDTO createFavorite(FavoriteDTO favoriteDTO) {
        Favorite favorite = new Favorite();
        
        favorite.setAddition_date(favoriteDTO.getAddition_date());
        favoriteRepository.save(favorite);
        return convertToDTO(favorite);
    }
    
    public FavoriteDTO updateFavorite(int idFavorite, FavoriteDTO favoriteDTO) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(idFavorite);
        
        if (favoriteOptional.isPresent()) {
            Favorite favorite = favoriteOptional.get();
            
            favorite.setAddition_date(favoriteDTO.getAddition_date());
            
            favoriteRepository.save(favorite);
            
            return convertToDTO(favorite);
        }
        
        return null;
    }
    
    public void deleteFavorite(int idFavorite) {
        favoriteRepository.deleteById(idFavorite);
    }
    
    private FavoriteDTO convertToDTO(Favorite favorite) {
        FavoriteDTO favoriteDTO = new FavoriteDTO();
        
        favoriteDTO.setId_favorite(favorite.getId_favorite());
        favoriteDTO.setAddition_date(favorite.getAddition_date());
        
        return favoriteDTO;
    }
}

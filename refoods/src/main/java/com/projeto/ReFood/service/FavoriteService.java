package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.FavoriteRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.projeto.ReFood.dto.FavoriteDTO;
import com.projeto.ReFood.exception.NotFoundException;
import com.projeto.ReFood.model.Favorite;

@Service
@Validated
public class FavoriteService {

  @Autowired
  private FavoriteRepository favoriteRepository;

  @Autowired
  private UtilityService utilityService;

  @Transactional(readOnly = true)
  public FavoriteDTO getFavoriteById(Long favoriteId) {
    return favoriteRepository.findById(favoriteId)
        .map(this::convertToDTO)
        .orElseThrow(() -> new NotFoundException("Favorito não encontrado."));
  }

  @Transactional
  public FavoriteDTO saveFavorite(@Valid FavoriteDTO favoriteDTO) {
    Favorite favorite = convertToEntity(favoriteDTO);
    utilityService.associateUser(favorite::setUser, favoriteDTO.userId());
    utilityService.associateRestaurant(favorite::setRestaurant, favoriteDTO.restaurantId());
    favorite = favoriteRepository.save(favorite);
    return convertToDTO(favorite);
  }

  @Transactional
  public void deleteFavorite(Long favoriteId) {
    if (!favoriteRepository.existsById(favoriteId)) {
      throw new NotFoundException("Favorito não encontrado.");
    }
    favoriteRepository.deleteById(favoriteId);
  }

  private FavoriteDTO convertToDTO(Favorite favorite) {
    return new FavoriteDTO(
        favorite.getFavoriteId(),
        favorite.getAdditionDate(),
        favorite.getUser().getUserId(),
        favorite.getRestaurant().getRestaurantId());
  }

  private Favorite convertToEntity(FavoriteDTO favoriteDTO) {
    Favorite favorite = new Favorite();
    favorite.setFavoriteId(favoriteDTO.favoriteId());
    favorite.setAdditionDate(favoriteDTO.additionDate());

    utilityService.associateUser(favorite::setUser, favoriteDTO.userId());
    utilityService.associateRestaurant(favorite::setRestaurant, favoriteDTO.restaurantId());

    return favorite;
  }
}

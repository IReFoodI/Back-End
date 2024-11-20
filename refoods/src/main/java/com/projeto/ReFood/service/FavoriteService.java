package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.FavoriteRepository;
import com.projeto.ReFood.repository.RestaurantHoursRepository;
import com.projeto.ReFood.security.JwtTokenProvider;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.projeto.ReFood.dto.FavoriteDTO;
import com.projeto.ReFood.dto.FavoriteDetailsDTO;
import com.projeto.ReFood.dto.HourDTO;
import com.projeto.ReFood.dto.RestaurantInfoDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.EnumDayOfWeek;
import com.projeto.ReFood.model.Favorite;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.RestaurantHours;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class FavoriteService {

  @Autowired
  private FavoriteRepository favoriteRepository;

  @Autowired
  private RestaurantHoursRepository restaurantHoursRepository;

  @Autowired
  private UtilityService utilityService;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Transactional(readOnly = true)
  public List<FavoriteDTO> getAllFavorites() {
    return favoriteRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public FavoriteDTO getFavoriteById(Long favoriteId) {
    return favoriteRepository.findById(favoriteId)
        .map(this::convertToDTO)
        .orElseThrow(() -> new NotFoundException());
  }

  @Transactional(readOnly = true)
  public List<FavoriteDetailsDTO> getFavoriteByUserId(String token) {
    Long userId = jwtTokenProvider.extractUserId(token);

    List<Favorite> favorites = favoriteRepository.findByUser_UserId(userId);

    // converte Favorite to FavoriteDetailsDTO
    List<FavoriteDetailsDTO> response = favorites.stream()
        .map(favorite -> {
          Long restaurantId = favorite.getRestaurant().getRestaurantId();

          // Buscando horário do restaurante para o dia de hoje
          DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
          EnumDayOfWeek dayEnum = EnumDayOfWeek.valueOf(currentDay.name());
          RestaurantHours restaurantHour = Optional.ofNullable(
              restaurantHoursRepository.findTodayHoursByRestaurantId(restaurantId, dayEnum))
              .orElseThrow(() -> new NotFoundException());
          // cria objeto HourDTO
          HourDTO timesOfTheDay = new HourDTO(
              restaurantHour.getId(),
              restaurantHour.getDayOfWeek(),
              restaurantHour.getOpeningTime(),
              restaurantHour.getClosingTime());

          // Converte Restaurant para RestaurantInfoDTO
          Restaurant restaurant = favorite.getRestaurant();
          RestaurantInfoDTO restaurantInfoDTO = new RestaurantInfoDTO(
              restaurant.getRestaurantId(),
              restaurant.getFantasy(),
              restaurant.getEmail(),
              restaurant.getDateCreation(),
              restaurant.getCategory(),
              restaurant.getUrlBanner(),
              restaurant.getUrlLogo(),
              restaurant.getQuantityEvaluations(),
              restaurant.getTotalEvaluations(),
              restaurant.getPhone(),
              restaurant.getDescription(),
              restaurant.getAverageRating());

          return new FavoriteDetailsDTO(
              favorite.getFavoriteId(),
              userId,
              timesOfTheDay,
              restaurantInfoDTO);
        })
        .collect(Collectors.toList());

    return response;
  }

  @Transactional
  public FavoriteDTO createFavorite(@Valid Long restaurantId, String token) {
    Favorite favorite = new Favorite();
    Long userID = jwtTokenProvider.extractUserId(token);
    utilityService.associateUser(favorite::setUser, userID);
    utilityService.associateRestaurant(favorite::setRestaurant, restaurantId);

    favorite = favoriteRepository.save(favorite);

    return convertToDTO(favorite);
  }

  @Transactional
  public FavoriteDTO updateFavorite(Long favoriteId, @Valid FavoriteDTO favoriteDTO) {
    Favorite favorite = favoriteRepository.findById(favoriteId)
        .orElseThrow(() -> new NotFoundException());

    utilityService.associateUser(favorite::setUser, favoriteDTO.userId());
    utilityService.associateRestaurant(favorite::setRestaurant, favoriteDTO.restaurantId());

    favorite = favoriteRepository.save(favorite);
    return convertToDTO(favorite);
  }

  @Transactional
  public void deleteFavorite(Long favoriteId) {
    if (!favoriteRepository.existsById(favoriteId)) {
      throw new NotFoundException();
    }
    favoriteRepository.deleteById(favoriteId);
  }

  private FavoriteDTO convertToDTO(Favorite favorite) {
    return new FavoriteDTO(
        favorite.getFavoriteId(),
        favorite.getUser().getUserId(),
        favorite.getRestaurant().getRestaurantId());
  }
}
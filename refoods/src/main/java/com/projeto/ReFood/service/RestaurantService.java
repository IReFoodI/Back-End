package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.RestaurantDTO;
import com.projeto.ReFood.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public RestaurantDTO getRestaurantById(int idRestaurant) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(idRestaurant);
        return restaurant.map(this::convertToDTO).orElse(null);
    }
    
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        
        restaurant.setFantasy(restaurantDTO.getFantasy());
        restaurant.setEmail(restaurantDTO.getEmail());
        restaurantRepository.save(restaurant);
        return convertToDTO(restaurant);
    }
    
    public RestaurantDTO updateRestaurant(int idRestaurant, RestaurantDTO restaurantDTO) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(idRestaurant);
        
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            
            restaurant.setFantasy(restaurantDTO.getFantasy());
            restaurant.setEmail(restaurantDTO.getEmail());
            
            restaurantRepository.save(restaurant);
            
            return convertToDTO(restaurant);
        }
        
        return null;
    }
    
    public void deleteRestaurant(int idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }
    
    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        
        restaurantDTO.setId_restaurant(restaurant.getId_restaurant());
        restaurantDTO.setFantasy(restaurant.getFantasy());
        restaurantDTO.setEmail(restaurant.getEmail());
        
        return restaurantDTO;
    }
}

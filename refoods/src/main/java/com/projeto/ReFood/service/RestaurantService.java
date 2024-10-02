package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.RestaurantDTO;
import com.projeto.ReFood.model.Restaurante;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    public List<RestaurantDTO> getAllRestaurantes() {
        return restaurantRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public RestaurantDTO getRestauranteById(int idRestaurante) {
        Optional<Restaurante> restaurante = restaurantRepository.findById(idRestaurante);
        return restaurante.map(this::convertToDTO).orElse(null);
    }
    
    public RestaurantDTO createRestaurante(RestaurantDTO restaurantDTO) {
        Restaurante restaurante = new Restaurante();
        
        restaurante.setNome(restaurantDTO.getNome());
        restaurante.setEndereco(restaurantDTO.getEndereco());
        restaurantRepository.save(restaurante);
        return convertToDTO(restaurante);
    }
    
    public RestaurantDTO updateRestaurante(int idRestaurante, RestaurantDTO restaurantDTO) {
        Optional<Restaurante> restauranteOptional = restaurantRepository.findById(idRestaurante);
        
        if (restauranteOptional.isPresent()) {
            Restaurante restaurante = restauranteOptional.get();
            
            restaurante.setNome(restaurantDTO.getNome());
            restaurante.setEndereco(restaurantDTO.getEndereco());
            
            restaurantRepository.save(restaurante);
            
            return convertToDTO(restaurante);
        }
        
        return null;
    }
    
    public void deleteRestaurante(int idRestaurante) {
        restaurantRepository.deleteById(idRestaurante);
    }
    
    private RestaurantDTO convertToDTO(Restaurante restaurante) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        
        restaurantDTO.setIdRestaurante(restaurante.getIdRestaurante());
        restaurantDTO.setNome(restaurante.getNome());
        restaurantDTO.setEndereco(restaurante.getEndereco());
        
        return restaurantDTO;
    }
}

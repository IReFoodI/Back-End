package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.RestauranteDTO;
import com.projeto.ReFood.model.Restaurante;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestauranteService {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    public List<RestauranteDTO> getAllRestaurantes() {
        return restauranteRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public RestauranteDTO getRestauranteById(int idRestaurante) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(idRestaurante);
        return restaurante.map(this::convertToDTO).orElse(null);
    }
    
    public RestauranteDTO createRestaurante(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = new Restaurante();
        
        restaurante.setNome(restauranteDTO.getNome());
        restaurante.setEndereco(restauranteDTO.getEndereco());
        restauranteRepository.save(restaurante);
        return convertToDTO(restaurante);
    }
    
    public RestauranteDTO updateRestaurante(int idRestaurante, RestauranteDTO restauranteDTO) {
        Optional<Restaurante> restauranteOptional = restauranteRepository.findById(idRestaurante);
        
        if (restauranteOptional.isPresent()) {
            Restaurante restaurante = restauranteOptional.get();
            
            restaurante.setNome(restauranteDTO.getNome());
            restaurante.setEndereco(restauranteDTO.getEndereco());
            
            restauranteRepository.save(restaurante);
            
            return convertToDTO(restaurante);
        }
        
        return null;
    }
    
    public void deleteRestaurante(int idRestaurante) {
        restauranteRepository.deleteById(idRestaurante);
    }
    
    private RestauranteDTO convertToDTO(Restaurante restaurante) {
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        
        restauranteDTO.setIdRestaurante(restaurante.getIdRestaurante());
        restauranteDTO.setNome(restaurante.getNome());
        restauranteDTO.setEndereco(restaurante.getEndereco());
        
        return restauranteDTO;
    }
}

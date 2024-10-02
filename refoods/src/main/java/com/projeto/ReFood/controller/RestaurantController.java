package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.RestaurantDTO;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestaurantController {
    
    @Autowired
    private RestaurantService restaurantService;
    
    @GetMapping
    public List<RestaurantDTO> getAllRestaurantes() {
        return restaurantService.getAllRestaurantes();
    }
    
    @GetMapping("/{id_restaurante}")
    public ResponseEntity<RestaurantDTO> getRestauranteById(@PathVariable int id_restaurante) {
        RestaurantDTO restaurantDTO = restaurantService.getRestauranteById(id_restaurante);
        
        return restaurantDTO != null ? ResponseEntity.ok(restaurantDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public RestaurantDTO createRestaurante(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.createRestaurante(restaurantDTO);
    }
    
    @PutMapping("/{id_restaurante}")
    public ResponseEntity<RestaurantDTO> updateRestaurante(@PathVariable int id_restaurante, @RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO updateRestaurante = restaurantService.updateRestaurante(id_restaurante, restaurantDTO);
        
        return updateRestaurante != null ? ResponseEntity.ok(updateRestaurante) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_restaurante}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable int id_restaurante) {
        restaurantService.deleteRestaurante(id_restaurante);
        
        return ResponseEntity.noContent().build();
    }
}

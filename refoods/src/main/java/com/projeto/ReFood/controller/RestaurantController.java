package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.RestaurantDTO;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    
    @Autowired
    private RestaurantService restaurantService;
    
    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    
    @GetMapping("/{id_restaurant}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable int id_restaurant) {
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id_restaurant);
        
        return restaurantDTO != null ? ResponseEntity.ok(restaurantDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public RestaurantDTO createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.createRestaurant(restaurantDTO);
    }
    
    @PutMapping("/{id_restaurant}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable int id_restaurant, @RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO updateRestaurant = restaurantService.updateRestaurant(id_restaurant, restaurantDTO);
        
        return updateRestaurant != null ? ResponseEntity.ok(updateRestaurant) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_restaurant}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id_restaurant) {
        restaurantService.deleteRestaurant(id_restaurant);
        
        return ResponseEntity.noContent().build();
    }
}

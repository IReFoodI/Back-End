package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.RestauranteDTO;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {
    
    @Autowired
    private RestauranteService restauranteService;
    
    @GetMapping
    public List<RestauranteDTO> getAllRestaurantes() {
        return restauranteService.getAllRestaurantes();
    }
    
    @GetMapping("/{id_restaurante}")
    public ResponseEntity<RestauranteDTO> getRestauranteById(@PathVariable int id_restaurante) {
        RestauranteDTO restauranteDTO = restauranteService.getRestauranteById(id_restaurante);
        
        return restauranteDTO != null ? ResponseEntity.ok(restauranteDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public RestauranteDTO createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        return restauranteService.createRestaurante(restauranteDTO);
    }
    
    @PutMapping("/{id_restaurante}")
    public ResponseEntity<RestauranteDTO> updateRestaurante(@PathVariable int id_restaurante, @RequestBody RestauranteDTO restauranteDTO) {
        RestauranteDTO updateRestaurante = restauranteService.updateRestaurante(id_restaurante, restauranteDTO);
        
        return updateRestaurante != null ? ResponseEntity.ok(updateRestaurante) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_restaurante}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable int id_restaurante) {
        restauranteService.deleteRestaurante(id_restaurante);
        
        return ResponseEntity.noContent().build();
    }
}

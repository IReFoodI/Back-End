package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.*;
import com.projeto.ReFood.model.EnumDayOfWeek;
import com.projeto.ReFood.service.RestaurantHoursService;
import com.projeto.ReFood.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

  @Autowired
  private RestaurantHoursService restaurantHoursService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @Operation(summary = "Busca restaurante por ID", description = "Retorna os detalhes de um restaurante com base no token de autorização fornecido.")
    @GetMapping
    public ResponseEntity<RestaurantDTO> getRestaurantById(@RequestHeader("Authorization") String token) {
        RestaurantDTO restaurant = restaurantService.getRestaurantById(token);
        return ResponseEntity.ok(restaurant);
    }

    @Operation(summary = "Busca o email do restaurante por ID", description = "Retorna o email de um restaurante com base no token de autorização fornecido.")
    @GetMapping("/email")
    public ResponseEntity<String> getRestaurantEmailById(@RequestHeader("Authorization") String token) {
        String restaurantEmail = restaurantService.getRestaurantEmailById(token);
        return ResponseEntity.ok(restaurantEmail);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> createRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO createdRestaurant = restaurantService.createRestaurant(restaurantDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{restaurantId}")
                .buildAndExpand(createdRestaurant.restaurantId())
                .toUri();
        return ResponseEntity.created(location).body(createdRestaurant);
    }

    @PutMapping
    public ResponseEntity<RestaurantUpdateDTO> updateRestaurant(@RequestHeader("Authorization") String token,
                                                                @Valid @RequestBody RestaurantUpdateDTO restaurantUpdateDTO) {
        RestaurantUpdateDTO updatedRestaurant = restaurantService.updateRestaurant(token, restaurantUpdateDTO);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @PutMapping("/email")
    public ResponseEntity<String> updateRestaurantEmail(@RequestHeader("Authorization") String token,
                                                                     @Valid @RequestBody RestaurantUpdateEmailDTO restaurantUpdateEmailDTO) {
        String updatedRestaurantEmail = restaurantService.updateRestaurantEmail(token, restaurantUpdateEmailDTO);
        return ResponseEntity.ok(updatedRestaurantEmail);
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updateRestaurantPassword(@RequestHeader("Authorization") String token,
                                                           @Valid @RequestBody RestaurantUpdatePasswordDTO restaurantUpdatePasswordDTO) {
         restaurantService.updateRestaurantPassword(token, restaurantUpdatePasswordDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.noContent().build();
    }

  @GetMapping("/today")
  public ResponseEntity<List<Map<String, Object>>> getTodayHours() {
    List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
    EnumDayOfWeek today = EnumDayOfWeek.valueOf(LocalDate.now().getDayOfWeek().name());
    List<RestaurantHoursDTO> hours = restaurantHoursService.getHoursByDay(today);
    List<Map<String, Object>> mergedData = new ArrayList<>();
    for (RestaurantDTO restaurant : restaurants) {
      Map<String, Object> restaurantData = new HashMap<>();
      restaurantData.put("restaurant", restaurant);

      // Filtrar os horários correspondentes ao restaurante
      List<RestaurantHoursDTO> hoursForRestaurant = hours.stream()
              .filter(hour -> hour.restaurantId().equals(restaurant.restaurantId()))
              .collect(Collectors.toList());

      restaurantData.put("hours", hoursForRestaurant);

      mergedData.add(restaurantData);
    }

    return ResponseEntity.ok(mergedData);
  }
}
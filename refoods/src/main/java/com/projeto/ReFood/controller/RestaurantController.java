package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.*;
import com.projeto.ReFood.model.EnumDayOfWeek;
import com.projeto.ReFood.service.RestaurantHoursService;
import com.projeto.ReFood.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

  @Autowired
  private RestaurantService restaurantService;

  @Autowired
  private RestaurantHoursService restaurantHoursService;

  @GetMapping("/allRestaurants")
  public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
    List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
    return ResponseEntity.ok(restaurants);
  }

  @GetMapping("/restaurants")
  public ResponseEntity<PagedModel<EntityModel<Map<String, Object>>>> getRestaurants(
      @PageableDefault(size = 15) Pageable pageable,
      PagedResourcesAssembler<Map<String, Object>> pagedResourcesAssembler) {

    List<RestaurantDTO> allRestaurants = restaurantService.getAllRestaurants();
    List<Map<String, Object>> mergedData = allRestaurants.stream()
        .map(restaurant -> {
          Map<String, Object> restaurantData = new HashMap<>();
          restaurantData.put("restaurant", restaurant);
          return restaurantData;
        })
        .collect(Collectors.toList());

    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), mergedData.size());
    List<Map<String, Object>> paginatedData = mergedData.subList(start, end);
    Page<Map<String, Object>> page = new PageImpl<>(paginatedData, pageable, mergedData.size());

    PagedModel<EntityModel<Map<String, Object>>> pagedModel = pagedResourcesAssembler.toModel(page);
    return ResponseEntity.ok(pagedModel);
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
  public ResponseEntity<RestaurantUpdateEmailResponse> updateRestaurantEmail(
      @RequestHeader("Authorization") String token,
      @Valid @RequestBody RestaurantUpdateEmailDTO restaurantUpdateEmailDTO) {
    RestaurantUpdateEmailResponse updatedRestaurantEmail = restaurantService.updateRestaurantEmail(token,
        restaurantUpdateEmailDTO);
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
  public ResponseEntity<PagedModel<EntityModel<Map<String, Object>>>> getTodayHours(
      @PageableDefault(size = 15) Pageable pageable,
      PagedResourcesAssembler<Map<String, Object>> pagedResourcesAssembler) {

    // Obtém todos os restaurantes e horários de hoje
    List<RestaurantDTO> allRestaurants = restaurantService.getAllRestaurants();
    EnumDayOfWeek today = EnumDayOfWeek.valueOf(LocalDate.now().getDayOfWeek().name());
    List<RestaurantHoursDTO> hours = restaurantHoursService.getHoursByDay(today);

    // Filtra e mapeia apenas os restaurantes com horários disponíveis hoje
    List<Map<String, Object>> mergedData = allRestaurants.stream()
        .map(restaurant -> {
          Map<String, Object> restaurantData = new HashMap<>();
          restaurantData.put("restaurant", restaurant);

          // Filtra os horários correspondentes ao restaurante atual
          List<RestaurantHoursDTO> hoursForRestaurant = hours.stream()
              .filter(hour -> hour.restaurantId().equals(restaurant.restaurantId()))
              .collect(Collectors.toList());

          if (!hoursForRestaurant.isEmpty()) {
            restaurantData.put("hours", hoursForRestaurant);
            return restaurantData;
          }
          return null;
        })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    // Converte para uma página paginada
    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), mergedData.size());
    List<Map<String, Object>> paginatedData = mergedData.subList(start, end);
    Page<Map<String, Object>> page = new PageImpl<>(paginatedData, pageable, mergedData.size());

    // Retorna como PagedModel
    PagedModel<EntityModel<Map<String, Object>>> pagedModel = pagedResourcesAssembler.toModel(page);
    return ResponseEntity.ok(pagedModel);
  }

  @Operation(summary = "Busca informações do restaurante por ID", description = "Retorna os detalhes de um restaurante com base no ID fornecido.")
  @GetMapping("/{restaurantId}")
  public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long restaurantId) {
    RestaurantDTO restaurant = restaurantService.getRestaurantById(restaurantId);
    return ResponseEntity.ok(restaurant);
  }

}

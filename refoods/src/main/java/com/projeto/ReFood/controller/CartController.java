package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.CartDTO;
import com.projeto.ReFood.dto.CartItemDTO;
import com.projeto.ReFood.dto.CartItemsDto;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.repository.CartRepository;
import com.projeto.ReFood.service.CartService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

  @Autowired
  private CartService cartService;
  @Autowired
  private CartRepository cartRepository;

  @PostMapping("/user/{userId}/add-item")
  public ResponseEntity<CartItemDTO> addItemToCart(
      @PathVariable Long userId,
      @RequestParam Long productId,
      @RequestParam int quantity) {
    try {
      boolean cartItemExists = cartRepository.existsByUserIdAndProductId(userId, productId);
      System.out.println("Cart item exists: " + cartItemExists);
      CartItemDTO cartItemDTO = cartService.addItemToUserCart(userId, productId, quantity);
      if (cartItemExists) {
        // Item já existe e foi atualizado, retorna 200 OK
        return ResponseEntity.ok(cartItemDTO);
      } else {
        // Item foi criado, retorna 201 Created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{cartItemId}")
            .buildAndExpand(cartItemDTO.cartItemId())
            .toUri();
        return ResponseEntity.created(location).body(cartItemDTO);
      }

    } catch (NotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }

  }

  @DeleteMapping("/cart/item")
  public ResponseEntity<String> removeItemFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
    cartService.removeItemFromCart(cartId, productId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<CartItemsDto>> getCartDetailsByUserId(@PathVariable Long userId) {
    List<CartItemsDto> cartDetails = cartService.getCartDetailsByUserId(userId);
    return ResponseEntity.ok(cartDetails);
  }

  @DeleteMapping("/{cartId}/clear")
  public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
    cartService.clearCart(cartId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<CartDTO>> listAllCarts() {
    List<CartDTO> carts = cartService.getAllCarts();
    return ResponseEntity.ok(carts);
  }

  @GetMapping("/{cartId}")
  public ResponseEntity<CartDTO> getCartById(@PathVariable Long cartId) {
    CartDTO cartDTO = cartService.getCartById(cartId);
    return ResponseEntity.ok(cartDTO);
  }

  @PostMapping
  public ResponseEntity<CartDTO> createCart(@Valid @RequestBody CartDTO cartDTO) {
    CartDTO createdCart = cartService.createCart(cartDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{cartId}")
        .buildAndExpand(createdCart.cartId())
        .toUri();
    return ResponseEntity.created(location).body(createdCart);
  }

  @PutMapping("/{cartId}")
  public ResponseEntity<CartDTO> updateCart(@PathVariable Long cartId, @Valid @RequestBody CartDTO cartDTO) {
    CartDTO updatedCart = cartService.updateCart(cartId, cartDTO);
    return ResponseEntity.ok(updatedCart);
  }

  @DeleteMapping("/{cartId}")
  public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
    cartService.deleteCart(cartId);
    return ResponseEntity.noContent().build();
  }
}

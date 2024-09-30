package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.CartaoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {
    
    @Autowired
    private CartaoService cartaoService;
    
    @GetMapping
    public List<CartaoDTO> getAllCartoes() {
        return cartaoService.getAllCartoes();
    }
    
    @GetMapping("/{id_cartao}")
    public ResponseEntity<CartaoDTO> getCartaoById(@PathVariable int id_cartao) {
        CartaoDTO cartaoDTO = cartaoService.getCartaoById(id_cartao);
        
        return cartaoDTO != null ? ResponseEntity.ok(cartaoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public CartaoDTO createCartao(@RequestBody CartaoDTO cartaoDTO) {
        return cartaoService.createCartao(cartaoDTO);
    }
    
    @PutMapping("/{id_cartao}")
    public ResponseEntity<CartaoDTO> updateCartao(@PathVariable int id_cartao, @RequestBody CartaoDTO cartaoDTO) {
        CartaoDTO updateCartao = cartaoService.updateCartao(id_cartao, cartaoDTO);
        
        return updateCartao != null ? ResponseEntity.ok(updateCartao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_cartao}")
    public ResponseEntity<Void> deleteCartao(@PathVariable int id_cartao) {
        cartaoService.deleteCartao(id_cartao);
        
        return ResponseEntity.noContent().build();
    }
}

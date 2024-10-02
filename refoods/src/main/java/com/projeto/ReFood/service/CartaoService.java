package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.CartaoDTO;
import com.projeto.ReFood.model.Cartao;
import com.projeto.ReFood.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartaoService {
    
    @Autowired
    private CartaoRepository cartaoRepository;
    
    public List<CartaoDTO> getAllCartoes(){
        return cartaoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public CartaoDTO getCartaoById(int id_cartao){
        Optional<Cartao> cartao = cartaoRepository.findById(id_cartao);
        return cartao.map(this::convertToDTO).orElse(null);
    }
    
    public CartaoDTO createCartao(CartaoDTO cartaoDTO){
        Cartao cartao = new Cartao();
        
        cartao.setNumero(cartaoDTO.getNumero());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartaoRepository.save(cartao);
        return convertToDTO(cartao);
    }
    
    public CartaoDTO updateCartao(int id_cartao, CartaoDTO cartaoDTO){
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id_cartao);
        
        if(cartaoOptional.isPresent()){
            Cartao cartao = cartaoOptional.get();

            cartao.setNumero(cartaoDTO.getNumero());
            cartao.setTipo(cartaoDTO.getTipo());
            cartao.setBandeira(cartaoDTO.getBandeira());
            cartaoRepository.save(cartao);
            
            return convertToDTO(cartao);
        }
        
        return null;
    }
    
    public void deleteCartao(int id_cartao){
        cartaoRepository.deleteById(id_cartao);
    }
    
    private CartaoDTO convertToDTO(Cartao cartao){
        CartaoDTO cartaoDTO = new CartaoDTO();
        
        cartaoDTO.setId_cartao(cartao.getId_cartao());
        cartaoDTO.setNumero(cartao.getNumero());
        cartaoDTO.setTipo(cartao.getTipo());
        cartaoDTO.setBandeira(cartao.getBandeira());
        return cartaoDTO;
    }
}
package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.FavoritoDTO;
import com.projeto.ReFood.model.Favorito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritoService {
    
    @Autowired
    private FavoritoRepository favoritoRepository;
    
    public List<FavoritoDTO> getAllFavoritos() {
        return favoritoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public FavoritoDTO getFavoritoById(int idFavorito) {
        Optional<Favorito> favorito = favoritoRepository.findById(idFavorito);
        return favorito.map(this::convertToDTO).orElse(null);
    }
    
    public FavoritoDTO createFavorito(FavoritoDTO favoritoDTO) {
        Favorito favorito = new Favorito();
        
        favorito.setNome(favoritoDTO.getNome());
        favorito.setDescricao(favoritoDTO.getDescricao());
        favoritoRepository.save(favorito);
        return convertToDTO(favorito);
    }
    
    public FavoritoDTO updateFavorito(int idFavorito, FavoritoDTO favoritoDTO) {
        Optional<Favorito> favoritoOptional = favoritoRepository.findById(idFavorito);
        
        if (favoritoOptional.isPresent()) {
            Favorito favorito = favoritoOptional.get();
            
            favorito.setNome(favoritoDTO.getNome());
            favorito.setDescricao(favoritoDTO.getDescricao());
            
            favoritoRepository.save(favorito);
            
            return convertToDTO(favorito);
        }
        
        return null;
    }
    
    public void deleteFavorito(int idFavorito) {
        favoritoRepository.deleteById(idFavorito);
    }
    
    private FavoritoDTO convertToDTO(Favorito favorito) {
        FavoritoDTO favoritoDTO = new FavoritoDTO();
        
        favoritoDTO.setIdFavorito(favorito.getIdFavorito());
        favoritoDTO.setNome(favorito.getNome());
        favoritoDTO.setDescricao(favorito.getDescricao());
        
        return favoritoDTO;
    }
}

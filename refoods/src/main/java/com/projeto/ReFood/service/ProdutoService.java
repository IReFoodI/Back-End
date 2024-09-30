package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ProdutoDTO;
import com.projeto.ReFood.model.Produto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<ProdutoDTO> getAllProdutos() {
        return produtoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ProdutoDTO getProdutoById(int idProduto) {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        return produto.map(this::convertToDTO).orElse(null);
    }
    
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produtoRepository.save(produto);
        return convertToDTO(produto);
    }
    
    public ProdutoDTO updateProduto(int idProduto, ProdutoDTO produtoDTO) {
        Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);
        
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            
            produto.setNome(produtoDTO.getNome());
            produto.setPreco(produtoDTO.getPreco());
            
            produtoRepository.save(produto);
            
            return convertToDTO(produto);
        }
        
        return null;
    }
    
    public void deleteProduto(int idProduto) {
        produtoRepository.deleteById(idProduto);
    }
    
    private ProdutoDTO convertToDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPreco(produto.getPreco());
        
        return produtoDTO;
    }
}

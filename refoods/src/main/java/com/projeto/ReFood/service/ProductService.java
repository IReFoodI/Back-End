package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ProductDTO;
import com.projeto.ReFood.model.Produto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDTO> getAllProdutos() {
        return productRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ProductDTO getProdutoById(int idProduto) {
        Optional<Produto> produto = productRepository.findById(idProduto);
        return produto.map(this::convertToDTO).orElse(null);
    }
    
    public ProductDTO createProduto(ProductDTO productDTO) {
        Produto produto = new Produto();
        
        produto.setNome(productDTO.getNome());
        produto.setPreco(productDTO.getPreco());
        productRepository.save(produto);
        return convertToDTO(produto);
    }
    
    public ProductDTO updateProduto(int idProduto, ProductDTO productDTO) {
        Optional<Produto> produtoOptional = productRepository.findById(idProduto);
        
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            
            produto.setNome(productDTO.getNome());
            produto.setPreco(productDTO.getPreco());
            
            productRepository.save(produto);
            
            return convertToDTO(produto);
        }
        
        return null;
    }
    
    public void deleteProduto(int idProduto) {
        productRepository.deleteById(idProduto);
    }
    
    private ProductDTO convertToDTO(Produto produto) {
        ProductDTO productDTO = new ProductDTO();
        
        productDTO.setIdProduto(produto.getIdProduto());
        productDTO.setNome(produto.getNome());
        productDTO.setPreco(produto.getPreco());
        
        return productDTO;
    }
}

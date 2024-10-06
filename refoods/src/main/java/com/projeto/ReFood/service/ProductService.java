package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ProductDTO;
import com.projeto.ReFood.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ProductDTO getProductById(int idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        return product.map(this::convertToDTO).orElse(null);
    }
    
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        
        product.setName_prod(productDTO.getName_prod());
        product.setValue_prod(productDTO.getValue_prod());
        productRepository.save(product);
        return convertToDTO(product);
    }
    
    public ProductDTO updateProduct(int idProduct, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(idProduct);
        
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            
            product.setName_prod(productDTO.getName_prod());
            product.setValue_prod(productDTO.getValue_prod());
            
            productRepository.save(product);
            
            return convertToDTO(product);
        }
        
        return null;
    }
    
    public void deleteProduct(int idProduct) {
        productRepository.deleteById(idProduct);
    }
    
    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        
        productDTO.setId_product(product.getId_product());
        productDTO.setName_prod(product.getName_prod());
        productDTO.setValue_prod(product.getValue_prod());
        
        return productDTO;
    }
}

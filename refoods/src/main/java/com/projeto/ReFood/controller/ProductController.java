package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ProductDTO;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id_product}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id_product) {
        ProductDTO productDTO = productService.getProductById(id_product);
        
        return productDTO != null ? ResponseEntity.ok(productDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }
    
    @PutMapping("/{id_product}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id_product, @RequestBody ProductDTO productDTO) {
        ProductDTO updateProduct = productService.updateProduct(id_product, productDTO);
        
        return updateProduct != null ? ResponseEntity.ok(updateProduct) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_product}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id_product) {
        productService.deleteProduct(id_product);
        
        return ResponseEntity.noContent().build();
    }
}
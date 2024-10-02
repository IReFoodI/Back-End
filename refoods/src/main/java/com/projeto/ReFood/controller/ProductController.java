package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ProductDTO;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<ProductDTO> getAllProdutos() {
        return productService.getAllProdutos();
    }
    
    @GetMapping("/{id_produto}")
    public ResponseEntity<ProductDTO> getProdutoById(@PathVariable int id_produto) {
        ProductDTO productDTO = productService.getProdutoById(id_produto);
        
        return productDTO != null ? ResponseEntity.ok(productDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ProductDTO createProduto(@RequestBody ProductDTO productDTO) {
        return productService.createProduto(productDTO);
    }
    
    @PutMapping("/{id_produto}")
    public ResponseEntity<ProductDTO> updateProduto(@PathVariable int id_produto, @RequestBody ProductDTO productDTO) {
        ProductDTO updateProduto = productService.updateProduto(id_produto, productDTO);
        
        return updateProduto != null ? ResponseEntity.ok(updateProduto) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_produto}")
    public ResponseEntity<Void> deleteProduto(@PathVariable int id_produto) {
        productService.deleteProduto(id_produto);
        
        return ResponseEntity.noContent().build();
    }
}
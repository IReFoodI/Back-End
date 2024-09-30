package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ProdutoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<ProdutoDTO> getAllProdutos() {
        return produtoService.getAllProdutos();
    }
    
    @GetMapping("/{id_produto}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable int id_produto) {
        ProdutoDTO produtoDTO = produtoService.getProdutoById(id_produto);
        
        return produtoDTO != null ? ResponseEntity.ok(produtoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ProdutoDTO createProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.createProduto(produtoDTO);
    }
    
    @PutMapping("/{id_produto}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable int id_produto, @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO updateProduto = produtoService.updateProduto(id_produto, produtoDTO);
        
        return updateProduto != null ? ResponseEntity.ok(updateProduto) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_produto}")
    public ResponseEntity<Void> deleteProduto(@PathVariable int id_produto) {
        produtoService.deleteProduto(id_produto);
        
        return ResponseEntity.noContent().build();
    }
}
package com.projeto.ReFood.controller;


import com.projeto.ReFood.dto.ProductPartialUpdateDTO;
import com.projeto.ReFood.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.projeto.ReFood.dto.ProductDTO;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> listAllProducts() {
    List<ProductDTO> products = productService.getAllProducts();
    return ResponseEntity.ok(products);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
    ProductDTO productDTO = productService.getProductById(productId);
    return ResponseEntity.ok(productDTO);
  }

  @PostMapping
  public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
    ProductDTO createdProduct = productService.createProduct(productDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{productId}")
            .buildAndExpand(createdProduct.productId())
            .toUri();
    return ResponseEntity.created(location).body(createdProduct);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductDTO> updateProduct(
          @PathVariable Long productId,
          @Valid @RequestBody ProductDTO productDTO) {

    ProductDTO updatedProduct = productService.updateProduct(productId, productDTO);
    return ResponseEntity.ok(updatedProduct);
  }

  @PatchMapping("/{productId}")
  public ResponseEntity<ProductDTO> partialUpdateProduct(
          @PathVariable Long productId,
          @Valid @RequestBody ProductPartialUpdateDTO productPartialUpdateDTO) {

    ProductDTO updatedProduct = productService.partialUpdateProduct(productId, productPartialUpdateDTO);
    return ResponseEntity.ok(updatedProduct);
  }


  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
    productService.deleteProduct(productId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
    try {
      // Defina o caminho de destino para a imagem
      String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
      Path path = Paths.get("uploads2/" + fileName);
      Files.copy(file.getInputStream(), path);

      // Retorne a URL para salvar no banco de dados
      String imageUrl = "http://localhost:8080/uploads/" + fileName;
      return ResponseEntity.ok(imageUrl);
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao fazer upload da imagem.");
    }
  }
}

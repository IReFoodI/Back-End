package com.projeto.ReFood.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.projeto.ReFood.dto.FileUploadRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.io.IOException;

@RestController
@RequestMapping("/api/firebase")
public class FirebaseController {

  @Autowired
  private FirebaseService firebaseService;

  @GetMapping("/image/{imageName}")
  public ResponseEntity<String> getImageUrl(@PathVariable String imageName) {
    String imageUrl = firebaseService.getImageUrl(imageName);
    if (imageUrl != null) {
      return ResponseEntity.ok(imageUrl);
    }
    return ResponseEntity.notFound().build();
  }


  // @PostMapping(value = "/upload", consumes = "multipart/form-data")
  // public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
  //   try {
  //     String imageUrl = firebaseService.upload(file);
  //     return new ResponseEntity<>(imageUrl, HttpStatus.OK);
  //   } catch (IOException e) {
  //     return new ResponseEntity<>("Error uploading image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  //   }
  // }

  @PostMapping(value = "/upload", consumes = "multipart/form-data")
  @Operation(
      summary = "Faz o upload de uma imagem", 
      description = "Este endpoint aceita o upload de arquivos de imagem em formato multipart/form-data.",
      requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
          content = @Content(
              mediaType = "multipart/form-data",
              schema = @Schema(implementation = FileUploadRequest.class) 
          )
      ),
      responses = {
          @ApiResponse(responseCode = "200", description = "Upload realizado com sucesso"),
          @ApiResponse(responseCode = "500", description = "Erro ao realizar upload")
      }
  )
  public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
      try {
          String imageUrl = firebaseService.upload(file);
          return new ResponseEntity<>(imageUrl, HttpStatus.OK);
      } catch (IOException e) {
          return new ResponseEntity<>("Error uploading image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  // @DeleteMapping("/image/{imageName}")
  // public ResponseEntity<Void> deleteImage(@PathVariable String imageName) {
  // firebaseService.deleteImage(imageName);
  // return ResponseEntity.noContent().build(); // 204 No Content em todos os
  // casos
  // }

}

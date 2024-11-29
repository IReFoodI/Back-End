package com.projeto.ReFood.dto;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;

public class FileUploadRequest {
  @Schema(type = "string", format = "binary", description = "Arquivo de imagem a ser enviado")
  private MultipartFile file;

  // Getters and Setters
  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }
}

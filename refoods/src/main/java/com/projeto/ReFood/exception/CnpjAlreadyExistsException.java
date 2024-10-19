package com.projeto.ReFood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CnpjAlreadyExistsException extends RuntimeException {
  public CnpjAlreadyExistsException(String message) {
      super(message);
  }
}

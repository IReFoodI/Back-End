package com.projeto.ReFood.exception;

public class CnpjAlreadyExistsException extends RuntimeException {
  public CnpjAlreadyExistsException(String message) {
      super(message);
  }
}
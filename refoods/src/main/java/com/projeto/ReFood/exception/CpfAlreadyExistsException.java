package com.projeto.ReFood.exception;

public class CpfAlreadyExistsException extends RuntimeException {
  public CpfAlreadyExistsException(String message) {
      super(message);
  }
}

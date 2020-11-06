package com.twuc.shopping.exception;


public class RequestNotValidException extends RuntimeException {
  private String error;

  public RequestNotValidException(String error) {
    this.error = error;
  }

  @Override
  public String getMessage() {
    return error;
  }
}

package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MessageResponse {
  private String message;

  public MessageResponse(String message) {
    this.message = message;
  }


}
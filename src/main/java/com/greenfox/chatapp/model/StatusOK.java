package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class StatusOK {
  private String status = "ok";

  public StatusOK() {
  }

  public StatusOK(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

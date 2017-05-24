package com.greenfox.chatapp.model;

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

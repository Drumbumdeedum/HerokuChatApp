package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class MainUser {
  String name;

  public MainUser() {

  }

  public MainUser(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

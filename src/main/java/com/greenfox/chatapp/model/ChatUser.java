package com.greenfox.chatapp.model;

import javax.persistence.*;

@Entity
public class ChatUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  String name;

  public ChatUser() {

  }

  public ChatUser(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

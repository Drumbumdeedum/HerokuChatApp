package com.greenfox.chatapp.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChatMessage {
  @Id
  private long id;
  private String username, message;
  private Timestamp timestamp;

  public ChatMessage() {
  }

  public ChatMessage(String userName, String messageText) {
    this.id = (long)(Math.random()* 8999999 + 1000000);
    this.username = userName;
    this.message = messageText;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public long getId(){
    return this.id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}

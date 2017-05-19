package com.greenfox.chatapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String username, message;
  private String timestamp = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss.SSS", Locale.ENGLISH).format(new Date());


  public ChatMessage() {
  }

  public ChatMessage(String userName, String messageText) {
    this.username = userName;
    this.message = messageText;
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

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}

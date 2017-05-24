package com.greenfox.chatapp.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
  @Id
  private long id;
  private String username, text;
  private Timestamp timestamp;

  public Message() {
  }

  public Message(String userName, String messageText) {
    this.id = generateID();
    this.username = userName;
    this.text = messageText;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public long generateID() {
    return (long)(Math.random()* 8999999) + 1000000;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
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

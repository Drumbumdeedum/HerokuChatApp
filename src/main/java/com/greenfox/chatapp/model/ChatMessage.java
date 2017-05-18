package com.greenfox.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String userName, messageText;

  public ChatMessage() {
  }

  public ChatMessage(String userName, String messageText) {
    this.userName = userName;
    this.messageText = messageText;
  }

  public long getId(){
    return this.id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }
}

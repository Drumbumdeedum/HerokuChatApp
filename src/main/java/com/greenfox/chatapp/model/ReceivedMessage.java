package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class ReceivedMessage {

  Message message;
  Client client;

  public ReceivedMessage() {
  }

  public ReceivedMessage(Message incomingMessage, Client client) {
    this.message = incomingMessage;
    this.client = client;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

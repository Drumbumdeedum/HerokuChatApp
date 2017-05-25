package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class JSONMessage {

  Message message;
  Client client;

  public JSONMessage() {
  }

  public JSONMessage(Message incomingMessage, Client client) {
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

package com.greenfox.chatapp.model;

public class ReceivedMessage {

  ChatMessage incomingMessage;
  Client client;

  public ReceivedMessage() {
  }

  public ReceivedMessage(ChatMessage incomingMessage, Client client) {
    this.incomingMessage = incomingMessage;
    this.client = client;
  }

  public ChatMessage getIncomingMessage() {
    return incomingMessage;
  }

  public void setIncomingMessage(ChatMessage incomingMessage) {
    this.incomingMessage = incomingMessage;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

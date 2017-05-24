package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repository.ChatMessageRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ChatRestController {

  @Autowired
  ChatMessageRepo messageRepo;

  @Autowired
  StatusOK statusOK;

  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public StatusOK receiveMessage(@RequestBody ReceivedMessage receivedMessage) {
    messageRepo.save(receivedMessage.getMessage());
    return new StatusOK();
  }
}

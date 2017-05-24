package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.ChatAppSettings;
import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repository.ChatMessageRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatRestController {

  @Autowired
  ChatMessageRepo messageRepo;

  @Autowired
  StatusOK statusOK;

  RestTemplate restTemplate;

  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public StatusOK receiveMessage(@RequestBody ReceivedMessage receivedMessage) {
    messageRepo.save(receivedMessage.getMessage());
/*
    StatusOK statusOKTemp = restTemplate.postForObject(ChatAppSettings.getChatAppPeerAddresss(), receivedMessage, StatusOK.class);
*/
    return new StatusOK();
  }
}

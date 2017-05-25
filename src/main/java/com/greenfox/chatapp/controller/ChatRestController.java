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

  @CrossOrigin("*")
  @PostMapping("/api/message/receive")
  public StatusOK receiveMessage(@RequestBody JSONMessage receivedMessage) {
    if (!receivedMessage.getMessage().getUsername().equals("Dani")) {
      messageRepo.save(receivedMessage.getMessage());
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.postForObject(ChatAppSettings.getChatAppPeerAddresss(), receivedMessage, StatusOK.class);
    }
    return new StatusOK();
  }
}

package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.ChatAppSettings;
import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Controller
public class ChatController {

  private int buffer = 0;

  @Autowired
  LogRepository logRepository;

  @Autowired
  MainUser mainUser;

  @Autowired
  ChatMessageRepo messageRepo;

  @Autowired
  ReceivedMessage receivedMessage;

  RestTemplate restTemplate = new RestTemplate();

  @RequestMapping("/")
  public String redirectToIndex() {
    return "redirect:/index/";
  }

  @RequestMapping("/index")
  public String index(Model model) {
    logRepository.save(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/", "GET", "no_parameters"));
    System.out.println(logRepository.getFirstByOrderByIdDesc());

    if (buffer == 0) {
      messageRepo.save(new Message("App", "Hi there! Submit your message using the send message button!"));
      buffer++;
    }

    if(mainUser.getName() == null || mainUser.getName().equals("")) {
      return "redirect:/enter/";
    } else {
      model.addAttribute("mainuser", mainUser);
      model.addAttribute("messages", messageRepo.findAllByOrderByTimestampDesc());
      return "index";
    }
  }

  @RequestMapping("/enter")
  public String enterNewUser(Model model) {
    model.addAttribute("mainuser", mainUser);
    return "enter";
  }

  @RequestMapping("/createUser")
  public String addNewUser(String newUser) {
    mainUser.setName(newUser);
    return "redirect:/index/";
  }

  @GetMapping("/sendmessage")
  public String sendMessage(@RequestParam("text") String messageText) {
    if (!messageText.isEmpty()) {
      messageRepo.save(new Message(mainUser.getName(), messageText));
      receivedMessage.setMessage(new Message(mainUser.getName(), messageText));
      receivedMessage.setClient(new Client(ChatAppSettings.getChatAppPeerAddresss()));
      restTemplate.postForObject(ChatAppSettings.getChatAppPeerAddresss(), receivedMessage, ReceivedMessage.class);
    }
    return "redirect:/index";
  }
}

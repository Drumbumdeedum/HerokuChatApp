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
  MainUser mainUser;

  @Autowired
  ChatMessageRepo messageRepo;

  @Autowired
  JSONMessage sendMessage;

  public MainUser getMainUser() {
    return mainUser;
  }

  @RequestMapping("/")
  public String redirectToIndex() {
    System.out.println(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/", "GET", "no_parameters"));
    return "redirect:/index/";
  }

  @RequestMapping("/index")
  public String index(Model model) {
    System.out.println(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/index", "GET", "no_parameters"));
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
    System.out.println(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/enter", "GET", "no_parameters"));
    model.addAttribute("mainuser", mainUser);
    return "enter";
  }

  @RequestMapping("/createUser")
  public String addNewUser(String newUser) {
    System.out.println(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/createUser", "GET", newUser));
    mainUser.setName(newUser);
    ChatAppSettings.setMainUser(newUser);
    return "redirect:/index/";
  }

  @GetMapping("/sendmessage")
  public String sendMessage(@RequestParam("text") String messageText) {
    System.out.println(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/sendmessage", "GET", messageText));
    if (!messageText.isEmpty()) {
      messageRepo.save(new Message(mainUser.getName(), messageText));
      sendMessage.setMessage(new Message(mainUser.getName(), messageText));
      sendMessage.setClient(new Client(ChatAppSettings.getChatAppUniqueId()));
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.postForObject(ChatAppSettings.getChatAppPeerAddresss(), sendMessage, StatusOK.class);
    }
    return "redirect:/index";
  }
}
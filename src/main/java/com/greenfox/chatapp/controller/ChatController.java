package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.ChatAppSettings;
import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ChatController {

  private int buffer = 0;

  @Autowired
  LogRepository logRepository;

  @Autowired
  MainUser mainUser;

  @Autowired
  ChatMessageRepo messageRepo;

  @RequestMapping("/")
  public String redirectToIndex() {
    return "redirect:/index/";
  }

  @RequestMapping("/index")
  public String index(Model model) {
    logRepository.save(new LogEntry(ChatAppSettings.getChatAppLoglevel(), "/", "GET", "no_parameters"));
    System.out.println(logRepository.getFirstByOrderByIdDesc());

    if (buffer == 0) {
      messageRepo.save(new ChatMessage("App", "Hi there! Submit your message using the send message button!"));
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

  @PostMapping("/sendmessage")
  public String sendMessage(String message) {
    if (!message.isEmpty()) {
      messageRepo.save(new ChatMessage(mainUser.getName(), message));
      buffer++;
    }
    return "redirect:/index";
  }
}

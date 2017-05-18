package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.ChatMessage;
import com.greenfox.chatapp.model.LogEntry;
import com.greenfox.chatapp.model.MainUser;
import com.greenfox.chatapp.repository.LogRepository;
import com.greenfox.chatapp.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

  private static final String CHAT_APP_LOGLEVEL = "INFO";
  private static final String CHAT_APP_UNIQUE_ID = "Drumbumdeedum";
  private static final String CHAT_APP_PEER_ADDRESS = "";
  private int buffer = 0;

  @Autowired
  LogRepository logRepository;

  @Autowired
  MainUser mainUser;

  @Autowired
  MessageRepo messageRepo;

  @RequestMapping("/")
  public String redirectToIndex() {
    return "redirect:/index/";
  }

  @RequestMapping("/index")
  public String index(Model model) {
    logRepository.save(new LogEntry(CHAT_APP_LOGLEVEL, "/", "GET", "no_parameters"));
    System.out.println(logRepository.getFirstByOrderByIdDesc());

    if (buffer == 0) {
      messageRepo.save(new ChatMessage("App", "Hi there! Submit your message using the send message button!"));
      buffer++;
    }

    if(mainUser.getName() == null) {
      return "redirect:/enter/";
    } else {
      model.addAttribute("mainuser", mainUser);
      model.addAttribute("messages", messageRepo.findAll());
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

  @RequestMapping("/sendmessage")
  public String sendMessage(String message) {
    messageRepo.save(new ChatMessage(mainUser.getName(), message));
    return "redirect:/index";
  }
}

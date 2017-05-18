package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.LogEntry;
import com.greenfox.chatapp.repository.LogRepository;
import com.greenfox.chatapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

  private static final String CHAT_APP_LOGLEVEL = "INFO";
  private static final String CHAT_APP_UNIQUE_ID = "Drumbumdeedum";
  private static final String CHAT_APP_PEER_ADDRESS = "";

  @Autowired
  LogRepository logRepository;

  @Autowired
  UserRepo tempUserRepository;

  @RequestMapping("/index")
  public String index(@RequestParam(value = "parameters", defaultValue = "no_parameters") String params, Model model) {
    logRepository.save(new LogEntry(CHAT_APP_LOGLEVEL, "/", "GET", params));
    model.addAttribute("userrepo", tempUserRepository.findAll());
    System.out.println(logRepository.getFirstByOrderByIdDesc());
    if(tempUserRepository.findOne(1l) == null) {
      return "redirect:/enter";
    } else {
      return "index";
    }
  }

  @RequestMapping("/enter")
  public String enterNewUser(Model model) {
    model.addAttribute("repo", tempUserRepository.findAll());
    return "enter";
  }

  @RequestMapping("/createUser")
  public String addNewUser(String newUser) {
    tempUserRepository.save(new ChatUser(newUser));
    return "redirect:/index/";
  }
}

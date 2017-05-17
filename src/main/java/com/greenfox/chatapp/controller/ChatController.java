package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.LogEntry;
import com.greenfox.chatapp.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

  @Autowired
  LogRepository repository;

  @GetMapping("/")
  public String index(@RequestParam(value = "parameters", defaultValue = "no_parameters") String params) {
    repository.save(new LogEntry("INFO Request", "/", "GET", params));
    System.out.println(repository.getFirstByOrderByIdDesc());
    return "index";
  }
}

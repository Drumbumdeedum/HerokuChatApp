package com.greenfox.chatapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {

  @GetMapping("/")
  public String index() {
    return "FUCKING WORK ALREADY!!!";
  }
}

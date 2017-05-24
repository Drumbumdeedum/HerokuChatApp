package com.greenfox.chatapp;

public class ChatAppSettings {
  private static final String CHAT_APP_LOGLEVEL = "INFO";
  private static final String CHAT_APP_UNIQUE_ID = "Drumbumdeedum";
  private static final String CHAT_APP_PEER_ADDRESS = "";

  public static String getChatAppLoglevel() {
    return CHAT_APP_LOGLEVEL;
  }

  public static String getChatAppUniqueId() {
    return CHAT_APP_UNIQUE_ID;
  }

  public static String getChatAppPeerAddresss() {
    return CHAT_APP_PEER_ADDRESS;
  }
}

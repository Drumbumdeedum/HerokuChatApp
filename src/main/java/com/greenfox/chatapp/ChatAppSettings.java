package com.greenfox.chatapp;

public class ChatAppSettings {
  private static final String CHAT_APP_LOGLEVEL = "INFO";
  private static final String CHAT_APP_UNIQUE_ID = "Drumbumdeedum";
  private static final String CHAT_APP_PEER_ADDRESS = "https://p2p-chat-seed0forever.herokuapp.com/api/message/receive";
  private static String mainUser = "";

  // Marci: "https://p2p-chat-seed0forever.herokuapp.com/api/message/receive"
  // Ramin: "https://greenfox-chat-app.herokuapp.com/api/message/receive"
  // Gabor: "https://limitless-journey-84827.herokuapp.com/api/message/receive"

  public static String getChatAppLoglevel() {
    return CHAT_APP_LOGLEVEL;
  }

  public static String getChatAppUniqueId() {
    return CHAT_APP_UNIQUE_ID;
  }

  public static String getChatAppPeerAddresss() {
    return CHAT_APP_PEER_ADDRESS;
  }

  public static String getMainUser() { return mainUser;}

  public static void setMainUser(String name) { mainUser = name;}
}

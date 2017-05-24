package com.greenfox.chatapp;

public class ChatAppSettings {
  private static final String CHAT_APP_LOGLEVEL = "INFO";
  private static final String CHAT_APP_UNIQUE_ID = "https://fackingawesomechatapp.herokuapp.com/api/message/receive";
  private static final String CHAT_APP_PEER_ADDRESS = "https://greenfox-chat-app.herokuapp.com/api/message/receive";

  /*"https://greenfox-chat-app.herokuapp.com/api/message/receive"*/
  /*"https://limitless-journey-84827.herokuapp.com/api/message/receive"*/

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

package com.greenfox.chatapp.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class LogEntry {
  private String date = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss.SSS", Locale.ENGLISH).format(new Date());
  private String path, method, logLevel, parameters;

  public LogEntry() {
  }

  public LogEntry(String logLevel, String path, String method, String parameters) {
    this.path = path;
    this.method = method;
    this.logLevel = logLevel;
    this.parameters = parameters;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getParameters() {
    return parameters;
  }

  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  @Override
  public String toString() {
   return date + " " + logLevel + " " + path + " " + method + " " + parameters;
  }
}

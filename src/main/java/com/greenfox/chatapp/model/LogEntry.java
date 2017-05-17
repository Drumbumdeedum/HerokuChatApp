package com.greenfox.chatapp.model;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class LogEntry {
  String path, method, logLevel, params;
  Date date;

  public LogEntry(String path, String method, Date date, String logLevel, String params) {
    this.path = path;
    this.method = method;
    this.date = date;
    this.logLevel = logLevel;
    this.params = params;
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

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}

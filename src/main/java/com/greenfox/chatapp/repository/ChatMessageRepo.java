package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.ChatMessage;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {
  List<ChatMessage> findAllByOrderByTimestampDesc();
}

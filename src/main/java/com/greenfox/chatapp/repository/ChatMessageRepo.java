package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.Message;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepo extends CrudRepository<Message, Long> {
  List<Message> findAllByOrderByTimestampDesc();
}

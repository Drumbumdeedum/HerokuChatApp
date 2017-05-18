package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.ChatUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<ChatUser, Long> {
  List<ChatUser> getFirstByOrderByIdAsc();
}

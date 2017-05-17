package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.LogEntry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogEntry, Long> {
  List<LogEntry> getFirstByOrderByIdDesc();
}

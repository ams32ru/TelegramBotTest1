package com.Social.TelegramBotTest1.repository;

import com.Social.TelegramBotTest1.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}

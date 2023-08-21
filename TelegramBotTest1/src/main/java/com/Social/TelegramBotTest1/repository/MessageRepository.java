package com.Social.TelegramBotTest1.repository;

import com.Social.TelegramBotTest1.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}

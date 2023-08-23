package com.Social.TelegramBotTest1.repository;

import com.Social.TelegramBotTest1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.telegram.telegrambots.meta.api.objects.Message;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByChatId(Long id);
}

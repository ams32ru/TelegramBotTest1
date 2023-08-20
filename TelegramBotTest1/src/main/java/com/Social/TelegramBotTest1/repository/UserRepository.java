package com.Social.TelegramBotTest1.repository;

import com.Social.TelegramBotTest1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}

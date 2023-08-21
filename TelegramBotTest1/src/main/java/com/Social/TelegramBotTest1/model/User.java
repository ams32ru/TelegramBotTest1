package com.Social.TelegramBotTest1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "users_data")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long chatId;
    /*
    Решил не добавлять много полей для пользователя, так как не влияет на тз
     */
    private String firstName;

    private LocalDateTime registerAt;

    private String lastMessageAt;

    @OneToMany(mappedBy = "user")
    private Collection<Message> messages;
}

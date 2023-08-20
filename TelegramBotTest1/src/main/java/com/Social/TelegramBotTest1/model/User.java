package com.Social.TelegramBotTest1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
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
    Решил не перегружать таблицу данными пильзователя, оставил только имя, так как в телеграм оно вроде обязательно
     */
    private String firstName;

    private LocalDateTime registerAt;

    private String lastMessageAt;

    @OneToMany(mappedBy = "user")
    private Collection<Message> messages;
}

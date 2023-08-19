package com.Social.TelegramBotTest1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "users_data")
@Getter
@Setter
public class User {
    @Id
    private Long chatId;
    /*
    Решил не перегружать таблицу данными пильзователя, оставил только имя, так как в телеграм оно вроде обязательно
     */
    private String firstName;

    private LocalDateTime registerAt;

    private String lastMessageAt;
}

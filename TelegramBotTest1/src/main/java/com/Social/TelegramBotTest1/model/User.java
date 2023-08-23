package com.Social.TelegramBotTest1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "users_data")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;
    /*
    Решил не добавлять много полей для пользователя, так как не влияет на тз
     */
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "register_at")
    private LocalDateTime registerAt;

    @Column(name = "last_message_at")
    private String lastMessageAt;

    @OneToMany(mappedBy = "user")
    private Collection<Message> messages;
}

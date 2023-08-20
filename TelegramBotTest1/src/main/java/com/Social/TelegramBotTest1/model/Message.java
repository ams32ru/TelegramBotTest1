package com.Social.TelegramBotTest1.model;

import jakarta.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "text_messages")
    private String textMessages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

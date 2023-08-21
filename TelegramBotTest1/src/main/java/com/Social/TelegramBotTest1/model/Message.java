package com.Social.TelegramBotTest1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_messages")
    private String textMessages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

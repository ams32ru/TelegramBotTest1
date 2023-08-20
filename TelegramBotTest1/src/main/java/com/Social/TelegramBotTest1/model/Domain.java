package com.Social.TelegramBotTest1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "daily_domains" )
@Getter
@Setter
public class Domain {
    @Id
    @GeneratedValue
    @Column(name = "domains_id")
    private Long domainsId;
    @Column(name = "domainname")
    private String domainName;
    @Column(name = "hotness")
    private int hotness;
    @Column(name = "price")
    private int price;
    @Column(name = "x_value")
    private int xValue;
    @Column(name = "yandex_tic")
    private int yandexTic;
    @Column(name = "links")
    private int links;
    @Column(name = "visitors")
    private int visitors;
    @Column(name = "registrar")
    private String registrar;
    @Column(name = "old")
    private int old;
    @Column(name = "delete_date")
    private LocalDateTime deleteDate;
    @Column(name = "rkn")
    private boolean rkn;
    @Column(name = "judicial")
    private boolean judicial;
    @Column(name = "block")
    private boolean block;
}

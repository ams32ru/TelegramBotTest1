package com.Social.TelegramBotTest1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "daily_domains" )
@Getter
@Setter
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate deleteDate;
    @Column(name = "rkn")
    private boolean rkn;
    @Column(name = "judicial")
    private boolean judicial;
    @Column(name = "block")
    private boolean block;
}

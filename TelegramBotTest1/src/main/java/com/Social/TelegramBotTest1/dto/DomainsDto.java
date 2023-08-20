package com.Social.TelegramBotTest1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DomainsDto {
    private Long domainsId;
    private String domainName;
    private int hotness;
    private int price;
    private int xValue;
    private int yandexTic;
    private int links;
    private int visitors;
    private String registrar;
    private int old;
    private LocalDateTime deleteDate;
    private boolean rkn;
    private boolean judicial;
    private boolean block;
}

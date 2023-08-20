package com.Social.TelegramBotTest1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DomainsDto {
    @JsonProperty("domainname")
    private String domainName;
    private int hotness;
    private int price;
    @JsonProperty("x_value")
    private int xValue;
    @JsonProperty("yandex_tic")
    private int yandexTic;
    private int links;
    private int visitors;
    private String registrar;
    private int old;
    @JsonProperty("delete_date")
    private LocalDateTime deleteDate;
    private boolean rkn;
    private boolean judicial;
    private boolean block;
}

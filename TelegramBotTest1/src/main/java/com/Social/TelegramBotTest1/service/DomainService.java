package com.Social.TelegramBotTest1.service;

import com.Social.TelegramBotTest1.model.Domains;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class DomainService {

    String url = "https://backorder.ru/json/?order=desc&expired=1&by=hotness&page=1&items=50";



}

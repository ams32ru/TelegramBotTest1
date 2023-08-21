package com.Social.TelegramBotTest1.service;

import com.Social.TelegramBotTest1.dto.DomainDto;
import com.Social.TelegramBotTest1.mappers.DomainMapper;
import com.Social.TelegramBotTest1.model.Message;
import com.Social.TelegramBotTest1.model.User;
import com.Social.TelegramBotTest1.repository.DomainRepository;
import com.Social.TelegramBotTest1.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
@Slf4j
@EnableScheduling
public class DomainService {
    private DomainRepository domainsRepository;
    private ObjectMapper objectMapper;
    private UserRepository userRepository;
    private static final String url = "https://backorder.ru/json/?order=desc&expired=1&by=hotness&page=1&items=50";


    @Scheduled(cron = "0 * * * * *")
    public void getDomain() {
        List<DomainDto> domainsDtos;
        {
            try {
                domainsDtos = objectMapper.readValue(new URL(url), new TypeReference<List<DomainDto>>() {

                });
                domainsRepository.save(DomainMapper.INSTANCE.toEntity(domainsDtos));
            } catch (IOException e) {
                log.error("File not found");
            }
        }
    }
}

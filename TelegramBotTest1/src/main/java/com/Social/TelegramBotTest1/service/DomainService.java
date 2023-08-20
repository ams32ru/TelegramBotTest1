package com.Social.TelegramBotTest1.service;

import com.Social.TelegramBotTest1.dto.DomainsDto;
import com.Social.TelegramBotTest1.mappers.DomainsMapper;
import com.Social.TelegramBotTest1.repository.DomainsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
@Slf4j
@EnableScheduling
public class DomainService {
    private DomainsRepository domainsRepository;
    private ObjectMapper objectMapper;
    private static final String url = "https://backorder.ru/json/?order=desc&expired=1&by=hotness&page=1&items=50";


    @Scheduled(cron = "@daily")
    public void getDomain() {
        List<DomainsDto> domainsDtos;
        {
            try {
                domainsDtos = objectMapper.readValue(new URL(url), new TypeReference<List<DomainsDto>>() {

                });

                domainsRepository.save(DomainsMapper.INSTANCE.toEntity(domainsDtos));
            } catch (IOException e) {
                log.error("File not found");
            }
        }
    }
}

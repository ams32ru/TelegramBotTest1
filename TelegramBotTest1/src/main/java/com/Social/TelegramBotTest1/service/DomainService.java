package com.Social.TelegramBotTest1.service;

import com.Social.TelegramBotTest1.dto.DomainDto;
import com.Social.TelegramBotTest1.mappers.DomainMapper;
import com.Social.TelegramBotTest1.repository.DomainRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final DomainRepository domainsRepository;
    private final static String URL = "https://backorder.ru/json/?order=desc&expired=1&by=hotness&page=1&items=50";

    public DomainService(DomainRepository domainsRepository) {
        this.domainsRepository = domainsRepository;
    }

    @Scheduled(cron = "@daily")
    public void getDomain() {
        List<DomainDto> domainsDtos;
        {
            try {
                domainsDtos = objectMapper.readValue(new URL(URL), new TypeReference<List<DomainDto>>() {
                });
                domainsRepository.save(DomainMapper.INSTANCE.toEntity(domainsDtos));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}

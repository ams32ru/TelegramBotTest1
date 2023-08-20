package com.Social.TelegramBotTest1.service;

import com.Social.TelegramBotTest1.dto.DomainsDto;
import com.Social.TelegramBotTest1.repository.DomainsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.dynalink.linker.LinkerServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

@Component
@Slf4j
public class DomainService {
    DomainsRepository domainsRepository;
    String url = "https://backorder.ru/json/?order=desc&expired=1&by=hotness&page=1&items=50";
    ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(cron = "@daily")
    public void getDomain() {
        List<DomainsDto> domainsDtos;
        {
            try {
                domainsDtos = objectMapper.readValue(new URL(url), new TypeReference<List<DomainsDto>>() {

                });
                domainsRepository.save(domainsDtos);
            } catch (IOException e) {
                log.error("File not found");
            }
        }
    }
}

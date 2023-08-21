package com.Social.TelegramBotTest1.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Data
@PropertySource("application.properties")
public class BotConfiguration {
    @Value("${telegramBot.name}")
    String botName;
    @Value("${telegramBot.token}")
    String token;
}

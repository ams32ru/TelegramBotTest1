package com.Social.TelegramBotTest1.service;

import com.Social.TelegramBotTest1.configuration.BotConfiguration;
import com.Social.TelegramBotTest1.model.User;
import com.Social.TelegramBotTest1.repository.MessageRepository;
import com.Social.TelegramBotTest1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class BotService extends TelegramLongPollingBot {

    private UserRepository userRepository;
    private MessageRepository messageRepository;
    final BotConfiguration config;


    public BotService(UserRepository userRepository, BotConfiguration config, DomainService domainService, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.config = config;
        this.messageRepository = messageRepository;
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "Запустить бота"));
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error setting  bot command list: " + e);
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/start":
                    registerUsers(update.getMessage());
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                default:
                    registerUsers(update.getMessage());
                    sendMessage(chatId, "Изивини, не понял команду");
                    log.info("Неизвестная команда, но пользователя сохраняем");
            }
        }
    }

    private Collection<com.Social.TelegramBotTest1.model.Message> adMessage(Message msg) {
        var chatId = msg.getChatId();
        var chat = msg.getChat();

        com.Social.TelegramBotTest1.model.Message message = new com.Social.TelegramBotTest1.model.Message();
        messageRepository.save(message);
        return null;
    }

    private void registerUsers(Message msg) {
        var chatId = msg.getChatId();
        var chat = msg.getChat();

        User user = new User();

        user.setChatId(chatId);
        user.setFirstName(chat.getFirstName());
        user.setLastMessageAt(msg.getText());
        user.setRegisterAt(LocalDateTime.now());
        user.setMessages(adMessage(msg));
        userRepository.save(user);
        log.info("user saved: " + user);

    }

    private void startCommandReceived(Long chatId, String name) {

        String answer = "Привет, " + name;
        log.info("Приветствие пользователя " + name);
        sendMessage(chatId, answer);

    }

    private void sendMessage(Long chatId, String testToSent) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(testToSent);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
    }
}

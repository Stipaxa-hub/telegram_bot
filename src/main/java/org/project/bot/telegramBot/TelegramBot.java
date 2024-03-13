package org.project.bot.telegramBot;

import org.project.bot.entity.User;
import org.project.bot.repository.UserRepository;
import org.project.bot.service.MessageBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    private static final String START_WORK_STRING = "/start";
    private static final String END_WORK_STRING = "/end";
    private static final boolean BOT_IS_ACTIVE = true;
    private static final boolean BOT_IS_DEACTIVATED = false;

    private final String botName;

    @Autowired
    private MessageBuilderService messageBuilderService;
    @Autowired
    private UserRepository userRepository;

    public TelegramBot(String botToken, String botName) {
        super(botToken);
        this.botName = botName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        String userName = update.getMessage().getChat().getUserName();

        if (update.getMessage().getText().equals(START_WORK_STRING)) {
            User user = new User(chatId, userName, BOT_IS_ACTIVE);
            userRepository.save(user);
        } else if (update.getMessage().getText().equals(END_WORK_STRING)) {
            User user = new User(chatId, userName, BOT_IS_DEACTIVATED);
            userRepository.save(user);
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Scheduled(cron = "0 0 9 * * *")
    private void showMessagePercent() {
        userRepository.findAllByIsStartedIsTrue()
                .forEach(user -> {
                    try {
                        sendApiMethod(new SendMessage(String.valueOf(user.getId()),
                                messageBuilderService.messageBuilder()));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

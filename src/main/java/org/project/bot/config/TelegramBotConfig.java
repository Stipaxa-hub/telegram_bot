package org.project.bot.config;

import lombok.RequiredArgsConstructor;
import org.project.bot.props.TelegramProps;
import org.project.bot.telegramBot.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@RequiredArgsConstructor
public class TelegramBotConfig {
    private final TelegramProps telegramProps;

    @Bean
    public TelegramBot telegramBot() throws TelegramApiException {
        TelegramBot telegramBot = new TelegramBot(telegramProps.token(), telegramProps.name());

        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(telegramBot);

        return telegramBot;
    }
}

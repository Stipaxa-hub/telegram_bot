package org.project.bot.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bot")
public record TelegramProps(
        String token,
        String name
) {
}

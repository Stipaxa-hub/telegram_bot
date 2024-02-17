package org.project.bot.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.bot.service.DataCalculateService;
import org.project.bot.service.MessageBuilderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageBuilderServiceImpl implements MessageBuilderService {
    private final DataCalculateService dataCalculateService;

    @Override
    public String messageBuilder() {
        return String.format("%s%% of days of the year have already passed.", dataCalculateService.calculatePercent());
    }
}

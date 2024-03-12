package org.project.bot.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageBuilderServiceImplTest {
    @Mock
    private DataCalculateServiceImpl dataCalculateService;
    @InjectMocks
    private MessageBuilderServiceImpl messageBuilderService;

    @Test
    void messageBuilder_returnCorrectMessage() {
        String exceptedMessage = "100,00% of days of the year have already passed.";

        when(dataCalculateService.calculatePercent(any(LocalDate.class))).thenReturn("100,00");

        String actualMessage = messageBuilderService.messageBuilder();

        assertEquals(exceptedMessage, actualMessage);
    }
}
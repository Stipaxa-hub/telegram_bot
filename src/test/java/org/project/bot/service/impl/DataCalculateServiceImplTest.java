package org.project.bot.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DataCalculateServiceImplTest {
    @InjectMocks
    private DataCalculateServiceImpl dataCalculateService;

    @ParameterizedTest
    @CsvSource(
            {
                    "2024-01-01, 0.27",
                    "2024-05-05, 34.43",
                    "2024-10-28, 82.51",
                    "2024-07-01, 50.00",
                    "2024-12-31, 100.00"
            }
    )
    @DisplayName("Calculate percent for the random day in year")
    void calculatePercent_randomDayInYear(LocalDate date, String expectedResult) {
        String actual = dataCalculateService.calculatePercent(date);

        assertEquals(expectedResult, actual);
    }
}
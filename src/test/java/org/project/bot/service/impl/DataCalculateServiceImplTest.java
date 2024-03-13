package org.project.bot.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DataCalculateServiceImplTest {
    @InjectMocks
    private DataCalculateServiceImpl dataCalculateService;

    @Test
    @DisplayName("Calculate percent for the first day in year")
    void calculatePercent_firstDayInYear() {
        LocalDate firstYearDay = LocalDate.of(2024, Month.JANUARY, 1);

        String expected = "0.27";
        String actual = dataCalculateService.calculatePercent(firstYearDay);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calculate percent for the last day in year")
    void calculatePercent_lastDayInYear() {
        LocalDate lastYearDay = LocalDate.of(2024, Month.DECEMBER, 31);

        String expected = "100.00";
        String actual = dataCalculateService.calculatePercent(lastYearDay);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calculate percent for the middle day in year")
    void calculatePercent_middleDayInYear() {
        LocalDate middleYearDay = LocalDate.of(2024, Month.JULY, 1);

        String expected = "50.00";
        String actual = dataCalculateService.calculatePercent(middleYearDay);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "2024-01-01, 0.27",
                    "2024-05-05, 34.43",
                    "2024-10-28, 82.51"
            }
    )
    @DisplayName("Calculate percent for the random day in year")
    void calculatePercent_randomDayInYear(LocalDate date, String expectedResult) {
        String actual = dataCalculateService.calculatePercent(date);

        assertEquals(expectedResult, actual);
    }
}
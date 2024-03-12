package org.project.bot.service.impl;

import jakarta.inject.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    @Named("Calculate percent for the first day in year")
    void calculatePercent_firstDayInYear() {
        LocalDate firstYearDay = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);

        String excepted = "0,27";
        String actual = dataCalculateService.calculatePercent(firstYearDay);

        assertEquals(excepted, actual);
    }

    @Test
    @Named("Calculate percent for the last day in year")
    void calculatePercent_lastDayInYear() {
        LocalDate lastYearDay = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 31);

        String excepted = "100,00";
        String actual = dataCalculateService.calculatePercent(lastYearDay);

        assertEquals(excepted, actual);
    }

    @Test
    @Named("Calculate percent for the middle day in year")
    void calculatePercent_middleDayInYear() {
        LocalDate middleYearDay = LocalDate.of(LocalDate.now().getYear(), Month.JULY, 1);

        String excepted = "50,00";
        String actual = dataCalculateService.calculatePercent(middleYearDay);

        assertEquals(excepted, actual);
    }

    @Test
    @Named("Calculate percent for the random day in year")
    void calculatePercent_randomDayInYear() {
        LocalDate day = LocalDate.of(LocalDate.now().getYear(), Month.OCTOBER, 28);

        String excepted = "82,51";
        String actual = dataCalculateService.calculatePercent(day);

        assertEquals(excepted, actual);
    }
}
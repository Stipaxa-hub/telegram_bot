package org.project.bot.service.impl;

import org.project.bot.service.DataCalculateService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

@Service
public class DataCalculateServiceImpl implements DataCalculateService {
    private static final int DAY_IN_YEAR = Year.now().length();
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00",  DecimalFormatSymbols.getInstance(Locale.US));

    @Override
    public String calculatePercent(LocalDate date) {
        double dayWentPercent = date.getDayOfYear() * 100.00 / DAY_IN_YEAR;
        return DECIMAL_FORMAT.format(dayWentPercent);
    }
}

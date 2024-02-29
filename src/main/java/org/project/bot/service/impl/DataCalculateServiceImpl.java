package org.project.bot.service.impl;

import org.project.bot.service.DataCalculateService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;

@Service
public class DataCalculateServiceImpl implements DataCalculateService {
    private static final int DAY_IN_YEAR = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    @Override
    public String calculatePercent() {
        int today = LocalDate.now().getDayOfYear();
        double dayWentPercent = today * 100.0 / DAY_IN_YEAR;
        DECIMAL_FORMAT.format(dayWentPercent);
        return DECIMAL_FORMAT.format(dayWentPercent);
    }
}

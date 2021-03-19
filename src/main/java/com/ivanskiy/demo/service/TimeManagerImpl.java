package com.ivanskiy.demo.service;

import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeManagerImpl implements TimeManager {

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date getDateFromString(String dateInString) {
        Date date = null;
        try {
            date = timeFormat.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public int getTimeBeetwenStartAndEndFlight(Date startDate, Date endDate) {
        long timePeriod = endDate.getTime() - startDate.getTime();
        return getMinuteFromMillisecond((timePeriod));
    }

    @Override
    public int getMinuteFromMillisecond(long millisecond) {
        return (int) ((millisecond / 1000) / 60);
    }

    @Override
    public String getCurrentTimeinString() {
        return timeFormat.format(new Date().getTime());
    }
}

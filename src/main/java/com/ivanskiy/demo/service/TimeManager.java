package com.ivanskiy.demo.service;

import java.util.Date;

public interface TimeManager {

    Date getDateFromString(String dateInString);

    int getTimeBeetwenStartAndEndFlight(Date startDate, Date endDate);

    int getMinuteFromMillisecond(long millisecond);

    String getCurrentTimeinString();
}

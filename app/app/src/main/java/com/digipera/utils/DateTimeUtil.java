package com.digipera.utils;

import com.digipera.commons.Formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeUtil {

    public static String getSystemDate() {
        LocalDate date = LocalDate.now();
        String month = Formatter.toFirstCharUpperCase(date.getMonth().toString());
        int year = date.getYear();
        int day = date.getDayOfMonth();
        return String.format("%s %d, %d",month, day, year);
    }

    public static String toDateString(String createdOn) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(createdOn, formatter);
        //System.out.println(date);
        String month = Formatter.toFirstCharUpperCase(dateTime.getMonth().toString());
        int year = dateTime.getYear();
        int day = dateTime.getDayOfMonth();
        return String.format("%s %d, %d",month, day, year);

    }
}

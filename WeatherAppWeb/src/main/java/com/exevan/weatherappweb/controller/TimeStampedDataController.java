/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.controller;

import com.exevan.weatherappweb.domain.IService;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.inject.Inject;

/**
 *
 * @author Exevan
 */
public class TimeStampedDataController {
    
    public static final String DATE_DELIM = "-";
    public static final String TIME_DELIM = ":";
    
    @Inject
    protected IService service;

    protected LocalDate parseDate(String dateString) {
        String[] s = dateString.split(DATE_DELIM);
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        return LocalDate.of(year, month, day);
    }

    protected LocalTime parseTime(String timeString) {
        String[] s = timeString.split(TIME_DELIM);
        int hour = Integer.parseInt(s[0]);
        int min = Integer.parseInt(s[1]);
        int sec = Integer.parseInt(s[2]);
        return LocalTime.of(hour, min, sec);
    }
    
    
}

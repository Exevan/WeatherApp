/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.database;

import com.exevan.weatherappweb.domain.TimeStampedData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Exevan
 * @param <T>
 */
public interface ITimeStampedDataRepository<T extends TimeStampedData> {
    
    public T get(LocalDate date, LocalTime time);
    
    public List<T> getAll();
    
    public List<T> getAllOnDate(LocalDate date);
    
    public List<T> getAllAfter(LocalDate date, LocalTime time);
    
    public void remove(LocalDate date, LocalTime time);
    
    public void store(T data);

}

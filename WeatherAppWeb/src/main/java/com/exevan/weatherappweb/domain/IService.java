/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Exevan
 */
public interface IService {
    
    public List<Temperature> getAllTemp();
    public List<Humidity> getAllHum();
    
    public List<Temperature> getAllTempOnDate(LocalDate date);
    public List<Humidity> getAllHumOnDate(LocalDate date);
    
    public List<Temperature> getAllTempAfter(LocalDate date, LocalTime time);
    public List<Humidity> getAllHumAfter(LocalDate date, LocalTime time);
    
    public void removeTemp(LocalDate date, LocalTime time);
    public void removeHum(LocalDate date, LocalTime time);
    
    public void storeTemp(Temperature temp);
    public void storeHum(Humidity hum);
    
}

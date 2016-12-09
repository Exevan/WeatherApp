/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.domain;

import com.exevan.weatherappweb.database.ITimeStampedDataRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Exevan
 */
@Dependent
public class Service implements IService {

    @EJB(name="HumidityRepository", beanName = "humRepo")
    private ITimeStampedDataRepository<Humidity> humidityRepository;
    @EJB(name="TemperatureRepository", beanName = "tempRepo")
    private ITimeStampedDataRepository<Temperature> temperatureRepository;

    @Override
    public List<Temperature> getAllTemp() {
        return temperatureRepository.getAll();
    }

    @Override
    public List<Humidity> getAllHum() {
        return humidityRepository.getAll();
    }

    @Override
    public List<Temperature> getAllTempOnDate(LocalDate date) {
        return temperatureRepository.getAllOnDate(date);
    }

    @Override
    public List<Humidity> getAllHumOnDate(LocalDate date) {
        return humidityRepository.getAllOnDate(date);
    }

    @Override
    public List<Temperature> getAllTempAfter(LocalDate date, LocalTime time) {
        return temperatureRepository.getAllAfter(date, time);
    }

    @Override
    public List<Humidity> getAllHumAfter(LocalDate date, LocalTime time) {
        return humidityRepository.getAllAfter(date, time);
    }

    @Override
    public void removeTemp(LocalDate date, LocalTime time) {
        System.out.println("removeTemp - service");
        temperatureRepository.remove(date, time);
    }

    @Override
    public void removeHum(LocalDate date, LocalTime time) {
        humidityRepository.remove(date, time);
    }

    @Override
    public void storeTemp(Temperature temp) {
        temperatureRepository.store(temp);
    }

    @Override
    public void storeHum(Humidity hum) {
        humidityRepository.store(hum);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.database;

import com.exevan.weatherappweb.domain.Humidity;
import com.exevan.weatherappweb.domain.Temperature;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Exevan
 */
@Stateless(name="tempRepo")
@Remote(ITimeStampedDataRepository.class)
public class TemperatureRepository extends TimeStampedDataRepository<Humidity>{

    public TemperatureRepository() {
        super.className = Temperature.class.getSimpleName();
    }
    
}

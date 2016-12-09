/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.database;

import com.exevan.weatherappweb.domain.Humidity;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Exevan
 */
@Stateless(name="humRepo")
@Remote(ITimeStampedDataRepository.class)
public class HumidityRepository extends TimeStampedDataRepository<Humidity>{

    public HumidityRepository() {
        super.className = Humidity.class.getSimpleName();
    }
    
}

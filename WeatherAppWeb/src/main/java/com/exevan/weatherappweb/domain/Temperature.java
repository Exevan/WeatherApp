/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.json.JSONObject;

/**
 *
 * @author Exevan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getTemperature",
            query = "SELECT x FROM Temperature x Where x.date = :date AND x.time = :time"),
    @NamedQuery(name="allTemperature",
        query="SELECT x FROM Temperature x"),
    @NamedQuery(name="onDateTemperature",
        query="SELECT x FROM Temperature x WHERE x.date = :date"),
    @NamedQuery(name="afterTemperature",
        query="SELECT x FROM Temperature x WHERE x.date >= :date AND x.time >= :time")
})
public class Temperature extends TimeStampedData implements Serializable {
    
    public Temperature() {}
    
    public Temperature(JSONObject data) {
        this.temperature = data.getDouble("temp");
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }
    
    @Column(name = "TEMP")
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
   
}

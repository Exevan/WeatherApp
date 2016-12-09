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
    @NamedQuery(name = "getHumidity",
            query = "SELECT x FROM Humidity x Where x.date = :date AND x.time = :time"),
    @NamedQuery(name="allHumidity",
        query="SELECT x FROM Humidity x"),
    @NamedQuery(name="onDateHumidity",
        query="SELECT x FROM Humidity x WHERE x.date = :date"),
    @NamedQuery(name="afterHumidity",
        query="SELECT x FROM Humidity x WHERE x.date >= :date AND x.time >= :time")
})
public class Humidity extends TimeStampedData implements Serializable {
    
    public Humidity() {}
    
    public Humidity(JSONObject data) {
        this.humidity = data.getDouble("hum");
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }
    
    @Column(name = "HUM")
    private double humidity;

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}

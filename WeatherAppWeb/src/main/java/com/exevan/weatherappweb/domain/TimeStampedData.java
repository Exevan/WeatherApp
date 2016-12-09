/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.domain;

import com.exevan.weatherappweb.database.converter.LocalDateConverter;
import com.exevan.weatherappweb.database.converter.LocalTimeConverter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Exevan
 */
@MappedSuperclass
public class TimeStampedData {
    
    @Id
    @GeneratedValue
    long id;
    
    @Column(name = "TIME_")
    @Convert(converter = LocalTimeConverter.class)
    protected LocalTime time;
    
    @Column(name = "DATE_")
    @Convert(converter = LocalDateConverter.class)
    protected LocalDate date;

    public TimeStampedData() {
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeStampedData other = (TimeStampedData) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
  
}

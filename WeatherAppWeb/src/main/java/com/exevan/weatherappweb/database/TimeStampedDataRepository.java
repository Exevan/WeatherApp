/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.database;

import com.exevan.weatherappweb.domain.TimeStampedData;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Exevan
 * @param <T>
 */
public class TimeStampedDataRepository<T extends TimeStampedData> implements ITimeStampedDataRepository<T>, Serializable {  
    
    protected String className;
    
    @PersistenceContext(unitName = "WeatherPU")
    private EntityManager em;    
    
    @Override
    public T get(LocalDate date, LocalTime time) {
        System.out.println("Retrieving first " + className.toLowerCase() + " result on " + date.toString() + " " + time.toString());
        Query q = em.createNamedQuery("get" + className)
                .setParameter("date", date)
                .setParameter("time", time);
        List<T> resultList = q.getResultList();
        T result = resultList.get(0);
        return result;        
    }

    @Override
    public List<T> getAll() {
        System.out.println("Retrieving all " + className.toLowerCase() + " data");        
        Query q = em.createNamedQuery("all" + className);
        System.out.println(q.getResultList());
        List<T> result = q.getResultList();
        return result;
    }

    @Override
    public List<T> getAllOnDate(LocalDate date) {
        System.out.println("Retrieving all " + className.toLowerCase() + " data on date " + date.toString());
        Query q = em.createNamedQuery("onDate" + className)
                .setParameter("date", date);
        System.out.println(q.getResultList());
        List<T> result = q.getResultList();
        System.out.println(result);
        return result;
    }

    @Override
    public List<T> getAllAfter(LocalDate date, LocalTime time) {
        System.out.println("Retrieving all " + className.toLowerCase() + " data after " + date.toString() + " " + time.toString());
        Query q = em.createNamedQuery("after" + className)
                .setParameter("date", date)
                .setParameter("time", time);
        List<T> result = q.getResultList();
        return result;
    }

    @Override
    public void remove(LocalDate date, LocalTime time) {
        System.out.println("Removing first " + className.toLowerCase() + " data on " + date.toString() + " " + time.toString());
        T data = get(date, time);
        em.remove(data);
    }

    @Override
    public void store(T data) {
        em.persist(data);
    }

}

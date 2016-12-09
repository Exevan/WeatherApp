/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappdata.controller;

import com.exevan.weatherappdata.domain.IService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.json.JSONObject;

/**
 *
 * @author Exevan
 */
@Stateless
@Path("/data")
public class DataController {

    @EJB
    private IService service;

    @Path("/temp")
    @GET
    @Produces("application/json")
    public String getTemperature() {
        System.out.println("retrieving temperature data from sensor");
        JSONObject data = service.getData();
        data.remove("hum");
        return data.toString();
    }
    
    @Path("/hum")
    @GET
    @Produces("application/json")
    public String getHumidity() {
        System.out.println("retrieving humidity data from sensor");
        JSONObject data = service.getData();
        data.remove("temp");       
        return data.toString();
    }
}

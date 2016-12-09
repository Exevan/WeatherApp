/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappweb.controller;

import com.exevan.weatherappweb.domain.Temperature;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Exevan
 */
@Stateless
@Path("/temp")
public class TemperatureController extends TimeStampedDataController {

    @Path("/fetch")
    @GET
    @Produces("application/json")
    public String fetchTemp() {
        System.out.println("fetching latest temperature data");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(TARGET_URL);
        JSONObject data = null;
        try {
            data = new JSONObject(target.request(MediaType.APPLICATION_JSON).get(String.class));
            System.out.println("fetching data successful: " + data.toString());
            service.storeTemp(new Temperature(data));
            return data.toString();
        } catch (RuntimeException e) {
            System.out.println("fetching data successful failed,\n cause: " + e.getMessage());
            return "fetching data successful failed,\n cause: " + e.getMessage();
        }

    }

    @Path("/all")
    @GET
    @Produces("application/json")
    public String getAllTemp() {
        JSONArray data = new JSONArray(service.getAllTemp());
        return data.toString();
    }

    @Path("/onDate/{date}")
    @GET
    @Produces("application/json")
    public String getAllTempOnDate(@PathParam("date") String dateString) {
        LocalDate date = parseDate(dateString);
        System.out.println(date);
        JSONArray data = new JSONArray(service.getAllTempOnDate(date));
        return data.toString();
    }

    @Path("/after/{date}/{time}")
    @GET
    @Produces("application/json")
    public String getAllTempAfter(@PathParam("date") String dateString, @PathParam("time") String timeString) {
        LocalDate date = parseDate(dateString);
        LocalTime time = parseTime(timeString);
        JSONArray data = new JSONArray(service.getAllTempAfter(date, time));
        return data.toString();
    }
    
    @Path("/remove/{date}/{time}")
    @DELETE
    public void removeTemp(@PathParam("date") String dateString, @PathParam("time") String timeString) {
        System.out.println("removeTemp - controller");
        LocalDate date = parseDate(dateString);
        LocalTime time = parseTime(timeString);
        service.removeTemp(date, time);
    }

    public static final String TARGET_URL = "http://localhost:8080/WeatherAppData/data/temp";
}

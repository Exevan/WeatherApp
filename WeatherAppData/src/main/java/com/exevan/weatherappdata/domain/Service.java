/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappdata.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.json.JSONObject;

/**
 *
 * @author Exevan
 */
@Stateless
public class Service implements IService {

    @Override
    public JSONObject getData() {
        //return getSensorData();
        return getDummyData();
    }
    
    private JSONObject getSensorData() {
        String cmd = "python //projects//readDHT22.py";
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            System.out.println("an error has occured while executing the sensor script");
        }

        BufferedReader reader = null;
        String dataString = "";

        try {
            reader = new BufferedReader(new FileReader("//projects//sensordata.json"));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }
            dataString = sb.toString();
            reader.close();

        } catch (IOException e) {
            System.out.println("an error has occurred while reading data from the sensor");
            try {
                reader.close();
            } catch (IOException ex) {}
        }

        return new JSONObject(dataString);
    }

    private JSONObject getDummyData() {
        Random r = new Random();
        double temp = (r.nextDouble() * 80) - 40;
        double hum = r.nextDouble() * 100;
        return new JSONObject("{temp: " + temp + ", hum: " + hum + "}");
    }

}

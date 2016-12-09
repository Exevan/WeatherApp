/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exevan.weatherappdata.domain;

import java.util.Random;
import javax.enterprise.context.Dependent;
import org.json.JSONObject;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Exevan
 */
@Dependent
public class Service implements IService {
    
    @Override
    public JSONObject getData() {
        
        //PythonInterpreter interpreter = new PythonInterpreter();
        //interpreter.execfile("readDHT22.py");
        
        Random r = new Random();
        double temp = (r.nextDouble() * 80) - 40;
        double hum = r.nextDouble() * 100;
        return new JSONObject("{temp: " + temp + ", hum: " + hum + "}");
    }
    
}

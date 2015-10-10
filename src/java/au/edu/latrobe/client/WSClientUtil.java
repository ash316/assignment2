/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.latrobe.client;

import au.edu.latrobe.ws.client.ext.Weather;
import au.edu.latrobe.ws.client.ext.WeatherSoap;

/**
 *
 */
public class WSClientUtil {
    
    public static WeatherSoap getWeatherClient() {
        return new Weather().getWeatherSoap();
    }
}

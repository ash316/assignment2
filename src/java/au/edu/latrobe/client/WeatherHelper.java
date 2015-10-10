package au.edu.latrobe.client;

import au.edu.latrobe.ws.client.ext.ForecastReturn;
import au.edu.latrobe.ws.client.ext.WeatherReturn;
import au.edu.latrobe.ws.client.ext.WeatherSoap;

/**
 * Helper Class for calling the Weather web service and displaying the result.
 */
public class WeatherHelper {
 
    private WeatherSoap weatherSoapClient;
    
    public WeatherHelper() {
        weatherSoapClient = WSClientUtil.getWeatherClient();
    }
    private ForecastReturn getWeatherForecast(String zip) {
         return  weatherSoapClient.getCityForecastByZIP(zip);
    }
    
    private WeatherReturn getWeather(String zip) {
        return  weatherSoapClient.getCityWeatherByZIP(zip);
    }
    
    public void printCityWeather(String zip) {
        WeatherReturn result = getWeather(zip);
        System.out.println("****** Weather Details Start *******");
        System.out.println("City  : " + result.getCity());
        System.out.println("State : " + result.getState());
        System.out.println("Temp : " + result.getTemperature());
        System.out.println("Desc : " + result.getDescription());
        System.out.println("Pressure : " + result.getPressure());
        
        System.out.println("****** Weather Details End   *******");
        
    }
    
    public void printCityForecast(String zip) {
        ForecastReturn result = getWeatherForecast(zip);
        System.out.println("****** Weather Forecast Start *******");
        System.out.println("City  : " + result.getCity());
        System.out.println("State : " + result.getState());
        System.out.println("Temp : " + result.getForecastResult().getForecast().get(0).getTemperatures().getDaytimeHigh());
        System.out.println("Desc : " + result.getForecastResult().getForecast().get(0).getDesciption());
               
        System.out.println("****** Weather Forecast End   *******");
    }
}

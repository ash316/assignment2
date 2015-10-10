package au.edu.latrobe.client;

/**
 * Standalone Client for calling Public Weather Service hosted at:
 * 
 * http://wsf.cdyne.com/WeatherWS/Weather.asmx
 * 
 */
public class WeatherClient {

    //Change the zip code for any other city.
    private final static String ZIP_CODE  = "12345";
    private final WeatherHelper weatherHelper;
    
    //Initialize WeatherSOAP inside constructor
    public WeatherClient() {
        weatherHelper = new WeatherHelper();
    }
    
    private void printWeather() {
        weatherHelper.printCityWeather(ZIP_CODE);
    }
    
    private void printWeatherForecast() {
        weatherHelper.printCityForecast(ZIP_CODE);
    }
    
    public static void main(String args[]) {
        new WeatherClient().printWeather();
        new WeatherClient().printWeatherForecast();
    }
}

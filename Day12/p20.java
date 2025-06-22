package Day12;

import java.util.HashMap;
import java.util.Map;

/*
 13. Weather Forecast System
Description: A weather forecast system that allows users to check the 
weather for different cities.
 */
//Interface for Weather Operations
interface WeatherOperations {
 void addCity(String city);
 void displayWeather(String city);
}

//Class representing a Weather Forecast
class WeatherForecast implements WeatherOperations {
 private Map<String, String> weatherData = new HashMap<>();

 @Override
 public void addCity(String city) {
     // Simulate adding weather data for the city
     weatherData.put(city, "Sunny, 25°C");
     System.out.println("Added weather data for: " + city);
 }

 @Override
 public void displayWeather(String city) {
     String weather = weatherData.get(city);
     if (weather != null) {
         System.out.println("Weather in " + city + ": " + weather);
     } else {
         System.out.println("Weather data not available for " + city);
     }
 }
}

//Main class to test the Weather Forecast System
public class p20 {
 public static void main(String[] args) {
     WeatherForecast forecast = new WeatherForecast();
     forecast.addCity("New York");
     forecast.displayWeather("New York");
     forecast.displayWeather("Los Angeles");
 }
}

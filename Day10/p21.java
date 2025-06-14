package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Weather Forecast Application: 
Design classes for Weather, Location, and Forecast. 
Implement methods to display current weather and forecasts.
*/

// Class representing Weather data
class Weather {
    private double temperature; // in Celsius
    private double humidity; // in percentage
    private String condition; // e.g., Sunny, Rainy, Cloudy

    public Weather(double temperature, double humidity, String condition) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void displayWeather() {
        System.out.println("Current Weather:");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Condition: " + condition);
    }
}

// Class representing a Location
class Location {
    private String name;
    private String country;

    public Location(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void displayLocation() {
        System.out.println("Location: " + name + ", " + country);
    }
}

// Class representing a Forecast
class Forecast {
    private List<Weather> dailyForecasts;

    public Forecast() {
        dailyForecasts = new ArrayList<>();
    }

    public void addDailyForecast(Weather weather) {
        dailyForecasts.add(weather);
    }

    public void displayForecast() {
        System.out.println("7-Day Forecast:");
        for (int i = 0; i < dailyForecasts.size(); i++) {
            Weather weather = dailyForecasts.get(i);
            System.out.println("Day " + (i + 1) + ": " + weather.getCondition() + 
                               ", " + weather.getTemperature() + "°C, " + 
                               weather.getHumidity() + "% humidity");
        }
    }
}

// Class simulating a Weather Service
class WeatherService {
    public Weather getCurrentWeather(Location location) {
        // Simulating fetching current weather data
        return new Weather(25.0, 60.0, "Sunny"); // Example data
    }

    public Forecast getWeeklyForecast(Location location) {
        // Simulating fetching weekly forecast data
        Forecast forecast = new Forecast();
        forecast.addDailyForecast(new Weather(25.0, 60.0, "Sunny"));
        forecast.addDailyForecast(new Weather(22.0, 70.0, "Cloudy"));
        forecast.addDailyForecast(new Weather(20.0, 80.0, "Rainy"));
        forecast.addDailyForecast(new Weather(24.0, 65.0, "Sunny"));
        forecast.addDailyForecast(new Weather(26.0, 55.0, "Sunny"));
        forecast.addDailyForecast(new Weather(23.0, 75.0, "Cloudy"));
        forecast.addDailyForecast(new Weather(21.0, 85.0, "Rainy"));
        return forecast;
    }
}

// Main class representing the Weather Application
public class p21 {
    public static void main(String[] args) {
        // Create a location
        Location location = new Location("New York", "USA");

        // Create a weather service
        WeatherService weatherService = new WeatherService();

        // Get current weather
        Weather currentWeather = weatherService.getCurrentWeather(location);
        location.displayLocation();
        currentWeather.displayWeather();

        // Get weekly forecast
        Forecast weeklyForecast = weatherService.getWeeklyForecast(location);
        weeklyForecast.displayForecast();
    }
}

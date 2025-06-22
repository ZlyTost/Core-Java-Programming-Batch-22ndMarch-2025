package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 25. Travel Booking System
Description: A travel booking system that allows users to book flights, 
view available flights, and check booking details.
 */
//Interface for Travel Operations
interface TravelOperations {
 void bookFlight(String flightNumber);
 void viewAvailableFlights();
}

//Class representing a Travel Booking Manager
class TravelBookingManager implements TravelOperations {
 private List<String> availableFlights = new ArrayList<>();
 private List<String> bookedFlights = new ArrayList<>();

 public TravelBookingManager() {
     availableFlights.add("Flight 101");
     availableFlights.add("Flight 202");
     availableFlights.add("Flight 303");
 }

 @Override
 public void bookFlight(String flightNumber) {
     if (availableFlights.contains(flightNumber)) {
         bookedFlights.add(flightNumber);
         availableFlights.remove(flightNumber);
         System.out.println("Booked flight: " + flightNumber);
     } else {
         System.out.println("Flight not available.");
     }
 }

 @Override
 public void viewAvailableFlights() {
     System.out.println("Available Flights: " + availableFlights);
 }
}

//Main class to test the Travel Booking System
public class p9 {
 public static void main(String[] args) {
     TravelBookingManager manager = new TravelBookingManager();
     manager.viewAvailableFlights();
     manager.bookFlight("Flight 101");
     manager.viewAvailableFlights();
 }
}

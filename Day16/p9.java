//Example 3: Airline Booking System

package Day16;

import java.util.*;

// Abstract Class
abstract class AirlineService {
    abstract void displayDetails();
}

// Parent Class
class Flight extends AirlineService {
    protected String flightNumber;
    protected String airlineName;
    protected String source;
    protected String destination;
    protected double fare;

    // Constructor
    public Flight(String flightNumber, String airlineName, String source, String destination, double fare) {
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    // Display Method
    public void displayDetails() {
        System.out.println("\nFlight Info:");
        System.out.println("Flight No: " + flightNumber);
        System.out.println("Airline: " + airlineName);
        System.out.println("Route: " + source + " to " + destination);
        System.out.println("Fare: ₹" + fare);
    }

    public double getFare() {
        return fare;
    }
}

// Child Class: Domestic Flight
class DomesticFlight extends Flight {
    private final double gstRate = 0.05;

    public DomesticFlight(String flightNumber, String airlineName, String source, String destination, double fare) {
        super(flightNumber, airlineName, source, destination, fare);
    }

    public double calculateTotalFare() {
        return fare + (fare * gstRate);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("GST Included Fare: ₹" + calculateTotalFare());
    }
}

// Child Class: International Flight
class InternationalFlight extends Flight {
    private final double gstRate = 0.18;

    public InternationalFlight(String flightNumber, String airlineName, String source, String destination, double fare) {
        super(flightNumber, airlineName, source, destination, fare);
    }

    public double calculateTotalFare() {
        return fare + (fare * gstRate);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("GST Included Fare: ₹" + calculateTotalFare());
    }
}

// Booking class using encapsulation
class Booking {
    private String passengerName;
    private int age;
    private String passportNumber;
    private String seatNumber;

    public static int bookingCounter = 0;

    // Constructor
    public Booking(String passengerName, int age, String passportNumber, String seatNumber) {
        this.passengerName = passengerName;
        this.age = age;
        this.passportNumber = passportNumber;
        this.seatNumber = seatNumber;
        bookingCounter++;
    }

    public void displayBooking() {
        System.out.println("\nBooking #" + bookingCounter);
        System.out.println("Passenger: " + passengerName);
        System.out.println("Age: " + age);
        System.out.println("Passport No: " + passportNumber);
        System.out.println("Seat No: " + seatNumber);
    }
}

// Main Class
public class p9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create flight list using arrays
        Flight[] flights = new Flight[2];
        flights[0] = new DomesticFlight("AI101", "Air India", "Delhi", "Mumbai", 4500);
        flights[1] = new InternationalFlight("BA202", "British Airways", "Delhi", "London", 55000);

        System.out.println("----- Available Flights -----");
        for (Flight f : flights) {
            f.displayDetails();
        }

        // Booking a Flight
        System.out.println("\n--- Book a Flight ---");
        System.out.print("Enter Flight No: ");
        String selectedFlight = sc.nextLine();

        Flight chosenFlight = null;
        for (Flight f : flights) {
            if (f.flightNumber.equalsIgnoreCase(selectedFlight)) {
                chosenFlight = f;
                break;
            }
        }

        if (chosenFlight != null) {
            System.out.print("Enter Passenger Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Passport Number: ");
            String passport = sc.nextLine();
            System.out.print("Enter Seat Number: ");
            String seat = sc.nextLine();

            Booking booking = new Booking(name, age, passport, seat);
            booking.displayBooking();

            System.out.println("Total Fare to be Paid: ₹" +
                (chosenFlight instanceof DomesticFlight
                        ? ((DomesticFlight) chosenFlight).calculateTotalFare()
                        : ((InternationalFlight) chosenFlight).calculateTotalFare()));
        } else {
            System.out.println("Flight Not Found!");
        }

        sc.close();
    }
}

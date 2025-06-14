package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Bike Rental System: 
Create classes for Vehicle1, Car1, and Bike. 
Use inheritance to define common properties and methods, 
and implement polymorphism for rental pricing.
*/

// Base class representing a Vehicle1
abstract class Vehicle1 {
    protected String make;
    protected String model;
    protected int year;
    protected String licensePlate;

    public Vehicle1(String make, String model, int year, String licensePlate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    public abstract double calculateRentalPrice(int days);

    public void displayDetails() {
        System.out.println("Vehicle1 Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("License Plate: " + licensePlate);
    }
}

// Class representing a Car1
class Car1 extends Vehicle1 {
    private double dailyRentalRate;

    public Car1(String make, String model, int year, String licensePlate, double dailyRentalRate) {
        super(make, model, year, licensePlate);
        this.dailyRentalRate = dailyRentalRate;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return dailyRentalRate * days; // Car1 rental price calculation
    }
}

// Class representing a Bike
class Bike extends Vehicle1 {
    private double dailyRentalRate;

    public Bike(String make, String model, int year, String licensePlate, double dailyRentalRate) {
        super(make, model, year, licensePlate);
        this.dailyRentalRate = dailyRentalRate;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return dailyRentalRate * days; // Bike rental price calculation
    }
}

// Class representing a Customer1
class Customer1 {
    private String name;
    private String Customer1Id;

    public Customer1(String name, String Customer1Id) {
        this.name = name;
        this.Customer1Id = Customer1Id;
    }

    public String getName() {
        return name;
    }

    public String getCustomer1Id() {
        return Customer1Id;
    }
}

// Class representing the Rental Service
class RentalService {
    private List<Vehicle1> Vehicle1s;

    public RentalService() {
        Vehicle1s = new ArrayList<>();
    }

    public void addVehicle1(Vehicle1 Vehicle1) {
        Vehicle1s.add(Vehicle1);
        System.out.println("Vehicle1 added: " + Vehicle1.licensePlate);
    }

    public void rentVehicle1(Customer1 Customer1, Vehicle1 Vehicle1, int days) {
        double rentalPrice = Vehicle1.calculateRentalPrice(days);
        System.out.println(Customer1.getName() + " rented " + Vehicle1.model + " for " + days + " days.");
        System.out.println("Total Rental Price: $" + rentalPrice);
    }

    public void displayAvailableVehicle1s() {
        System.out.println("Available Vehicle1s:");
        for (Vehicle1 Vehicle1 : Vehicle1s) {
            Vehicle1.displayDetails();
            System.out.println();
        }
    }
}

// Main class to run the Bike Rental System
public class p15 {
    public static void main(String[] args) {
        // Create a rental service
        RentalService rentalService = new RentalService();

        // Create Vehicle1s
        Car1 Car1 = new Car1("Toyota", "Camry", 2020, "Car1123", 50.0);
        Bike bike = new Bike("Yamaha", "MT-07", 2021, "BIKE456", 20.0);

        // Add Vehicle1s to the rental service
        rentalService.addVehicle1(Car1);
        rentalService.addVehicle1(bike);

        // Create a Customer1
        Customer1 Customer1 = new Customer1("John Doe", "C001");

        // Display available Vehicle1s
        rentalService.displayAvailableVehicle1s();

        // Rent a Vehicle1
        rentalService.rentVehicle1(Customer1, Car1, 3); // Rent Car1 for 3 days
        rentalService.rentVehicle1(Customer1, bike, 2); // Rent bike for 2 days
    }
}

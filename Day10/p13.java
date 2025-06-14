package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Vehicle Management System: 
Develop classes for Vehicle, Car, Truck, and Motorcycle. 
Use inheritance to share common attributes and methods, 
and demonstrate polymorphism with different vehicle types.
*/

// Base class representing a Vehicle
abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String licensePlate;

    public Vehicle(String make, String model, int year, String licensePlate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    public abstract void displayDetails();

    public String getLicensePlate() {
        return licensePlate;
    }
}

// Class representing a Car
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String make, String model, int year, String licensePlate, int numberOfDoors) {
        super(make, model, year, licensePlate);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// Class representing a Truck
class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String make, String model, int year, String licensePlate, double payloadCapacity) {
        super(make, model, year, licensePlate);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Truck Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Payload Capacity: " + payloadCapacity + " kg");
    }
}

// Class representing a Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, String licensePlate, boolean hasSidecar) {
        super(make, model, year, licensePlate);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// Class representing the Vehicle Management System
class VehicleManagementSystem {
    private List<Vehicle> vehicles;

    public VehicleManagementSystem() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getLicensePlate());
    }

    public void displayAllVehicles() {
        System.out.println("All Vehicles:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println();
        }
    }
}

// Main class to run the Vehicle Management System
public class p13 {
    public static void main(String[] args) {
        // Create the Vehicle Management System
        VehicleManagementSystem vms = new VehicleManagementSystem();

        // Create vehicles
        Car car = new Car("Toyota", "Camry", 2020, "ABC123", 4);
        Truck truck = new Truck("Ford", "F-150", 2019, "XYZ789", 1000);
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2021, "MOTO456", false);

        // Add vehicles to the system
        vms.addVehicle(car);
        vms.addVehicle(truck);
        vms.addVehicle(motorcycle);

        // Display all vehicles
        vms.displayAllVehicles();
    }
}

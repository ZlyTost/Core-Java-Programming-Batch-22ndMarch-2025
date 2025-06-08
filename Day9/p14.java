package Day9;

// Vehicle Ownership System using Inheritance demonstrating complex logic

/*
This implementation has a base class Vehicle and derived classes Car, Truck, Motorcycle.
Each derived class implements:
- Complex registration fee calculation based on vehicle specifics.
- Maintenance scheduling logic dependent on vehicle type and usage.
- Constructors, methods, and properties demonstrating inheritance and polymorphism.
*/

abstract class Vehicle {
    protected String owner;
    protected String registrationNumber;
    protected double weightKg;
    protected int registrationYear;

    public Vehicle(String owner, String registrationNumber, double weightKg, int registrationYear) {
        this.owner = owner;
        this.registrationNumber = registrationNumber;
        this.weightKg = weightKg;
        this.registrationYear = registrationYear;
    }

    // Abstract method to calculate registration fee (differs per vehicle type)
    public abstract double calculateRegistrationFee();

    // Abstract method to get maintenance schedule description
    public abstract String getMaintenanceSchedule();

    // Get age of vehicle based on current year (assumed 2024)
    public int getAge() {
        return 2024 - registrationYear;
    }

    // Display base vehicle info
    public void displayInfo() {
        System.out.println("Owner: " + owner);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Registration Year: " + registrationYear);
        System.out.println("Vehicle Age: " + getAge() + " years");
    }
}

// Car inherits Vehicle
class Car extends Vehicle {
    private int doorCount;
    private boolean isElectric;

    public Car(String owner, String registrationNumber, double weightKg, int registrationYear, int doorCount, boolean isElectric) {
        super(owner, registrationNumber, weightKg, registrationYear);
        this.doorCount = doorCount;
        this.isElectric = isElectric;
    }

    @Override
    public double calculateRegistrationFee() {
        double baseFee = 5000;
        double weightSurcharge = weightKg * 25;
        double electricDiscount = isElectric ? 0.5 : 1.0;
        return (baseFee + weightSurcharge) * electricDiscount;
    }

    @Override
    public String getMaintenanceSchedule() {
        int age = getAge();
        if (age <=2) return "Annual servicing recommended.";
        else if (age <=5) return "Servicing every 6 months recommended.";
        else return "Servicing every 3 months recommended.";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Car Information ===");
        super.displayInfo();
        System.out.println("Door Count: " + doorCount);
        System.out.println("Electric: " + (isElectric ? "Yes" : "No"));
        System.out.printf("Registration Fee: ₹%.2f\n", calculateRegistrationFee());
        System.out.println("Maintenance: " + getMaintenanceSchedule());
        System.out.println("----------------------------");
    }
}

// Truck inherits Vehicle
class Truck extends Vehicle {
    private double loadCapacityTonnes;
    private int axles;

    public Truck(String owner, String registrationNumber, double weightKg, int registrationYear, double loadCapacityTonnes, int axles) {
        super(owner, registrationNumber, weightKg, registrationYear);
        this.loadCapacityTonnes = loadCapacityTonnes;
        this.axles = axles;
    }

    @Override
    public double calculateRegistrationFee() {
        double baseFee = 8000;
        double weightSurcharge = weightKg * 40;
        double axleFee = axles * 3000;
        return baseFee + weightSurcharge + axleFee;
    }

    @Override
    public String getMaintenanceSchedule() {
        int age = getAge();
        if (age <= 3) return "Maintenance every 6 months or 20,000 km.";
        else if (age <= 7) return "Maintenance every 4 months or 15,000 km.";
        else return "Maintenance every 2 months or 10,000 km.";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Truck Information ===");
        super.displayInfo();
        System.out.printf("Load Capacity: %.2f tonnes\n", loadCapacityTonnes);
        System.out.println("Number of Axles: " + axles);
        System.out.printf("Registration Fee: ₹%.2f\n", calculateRegistrationFee());
        System.out.println("Maintenance: " + getMaintenanceSchedule());
        System.out.println("----------------------------");
    }
}

// Motorcycle inherits Vehicle
class Motorcycle extends Vehicle {
    private boolean hasCarrier;
    private boolean isSportsBike;

    public Motorcycle(String owner, String registrationNumber, double weightKg, int registrationYear, boolean hasCarrier, boolean isSportsBike) {
        super(owner, registrationNumber, weightKg, registrationYear);
        this.hasCarrier = hasCarrier;
        this.isSportsBike = isSportsBike;
    }

    @Override
    public double calculateRegistrationFee() {
        double baseFee = 2000;
        double weightSurcharge = weightKg * 15;
        double sportsBikeSurcharge = isSportsBike ? 1500 : 0;
        double carrierDiscount = hasCarrier ? -300 : 0;
        return baseFee + weightSurcharge + sportsBikeSurcharge + carrierDiscount;
    }

    @Override
    public String getMaintenanceSchedule() {
        int age = getAge();
        if (isSportsBike) return "Service every 3 months or 3,000 km.";
        else if (age <= 3) return "Service every 6 months or 6,000 km.";
        else return "Service every 4 months or 4,000 km.";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Motorcycle Information ===");
        super.displayInfo();
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
        System.out.println("Sports Bike: " + (isSportsBike ? "Yes" : "No"));
        System.out.printf("Registration Fee: ₹%.2f\n", calculateRegistrationFee());
        System.out.println("Maintenance: " + getMaintenanceSchedule());
        System.out.println("----------------------------");
    }
}

public class p14 {
    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Ownership System\n");

        Vehicle car = new Car("John Doe", "MH12AB1234", 1400.0, 2020, 4, true);
        car.displayInfo();

        Vehicle truck = new Truck("Transports Inc.", "DL01ZX9876", 9000.0, 2015, 18.0, 5);
        truck.displayInfo();

        Vehicle bike = new Motorcycle("Jane Smith", "KA05XY4567", 180.0, 2018, true, false);
        bike.displayInfo();

        Vehicle sportsBike = new Motorcycle("Mike Speed", "TN10SP2024", 190.0, 2021, false, true);
        sportsBike.displayInfo();
    }
}


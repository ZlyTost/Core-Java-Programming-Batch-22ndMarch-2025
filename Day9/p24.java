package Day9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Base class representing a generic transportation ticket
abstract class Ticket {
    protected String ticketId;
    protected String passengerName;
    protected LocalDate travelDate;
    protected String seatPreference; // e.g., Window, Aisle, Middle
    protected double baseFare;
    protected int luggageKg;

    public Ticket(String ticketId, String passengerName, LocalDate travelDate, String seatPreference, double baseFare, int luggageKg) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.travelDate = travelDate;
        this.seatPreference = seatPreference;
        this.baseFare = baseFare;
        this.luggageKg = luggageKg;
    }

    // Abstract method to calculate final fare, including luggage and seat preference charges
    public abstract double calculateFare();

    // Abstract method for cancellation fee calculation based on time before travel
    public abstract double cancellationFee(LocalDate cancelDate);

    // Abstract method for displaying ticket details
    public abstract void displayTicketDetails();

    // Utility method to calculate days between two dates
    protected long daysUntilTravel(LocalDate currentDate) {
        return ChronoUnit.DAYS.between(currentDate, travelDate);
    }
}

// BusTicket subclass
class BusTicket extends Ticket {
    private String busType; // E.g., "Sleeper", "Seater", "AC"

    public BusTicket(String ticketId, String passengerName, LocalDate travelDate, String seatPreference, double baseFare, int luggageKg, String busType) {
        super(ticketId, passengerName, travelDate, seatPreference, baseFare, luggageKg);
        this.busType = busType;
    }

    @Override
    public double calculateFare() {
        double fare = baseFare;

        // Extra charge for AC buses
        if (busType.equalsIgnoreCase("AC")) {
            fare += baseFare * 0.3; // 30% more for AC
        }

        // Extra charge for sleeper buses
        if (busType.equalsIgnoreCase("Sleeper")) {
            fare += baseFare * 0.2; // 20% more for sleeper
        }

        // Luggage charge: first 20kg free, ₹15/kg thereafter
        int freeLuggage = 20;
        if (luggageKg > freeLuggage) {
            fare += (luggageKg - freeLuggage) * 15;
        }

        // Seat preference surcharge (window +₹20, aisle +₹10, middle none)
        if (seatPreference.equalsIgnoreCase("Window")) {
            fare += 20;
        } else if (seatPreference.equalsIgnoreCase("Aisle")) {
            fare += 10;
        }

        return fare;
    }

    @Override
    public double cancellationFee(LocalDate cancelDate) {
        long daysLeft = daysUntilTravel(cancelDate);
        if (daysLeft >= 7) {
            // 10% cancellation fee if 7 or more days left
            return baseFare * 0.10;
        } else if (daysLeft >= 1) {
            // 50% cancellation fee if 1 to 6 days left
            return baseFare * 0.50;
        } else {
            // No refund on day of travel or after
            return baseFare;
        }
    }

    @Override
    public void displayTicketDetails() {
        System.out.println("=== Bus Ticket ===");
        System.out.println("Ticket ID       : " + ticketId);
        System.out.println("Passenger Name  : " + passengerName);
        System.out.println("Travel Date     : " + travelDate);
        System.out.println("Bus Type        : " + busType);
        System.out.println("Seat Preference : " + seatPreference);
        System.out.println("Luggage (kg)    : " + luggageKg);
        System.out.printf("Calculated Fare : ₹%.2f%n", calculateFare());
        System.out.println("----------------------------");
    }
}

// TrainTicket subclass
class TrainTicket extends Ticket {
    private String travelClass; // E.g., "Sleeper", "AC 3-tier", "AC 2-tier"
    private boolean isTatkal;

    public TrainTicket(String ticketId, String passengerName, LocalDate travelDate, String seatPreference, double baseFare, int luggageKg, String travelClass, boolean isTatkal) {
        super(ticketId, passengerName, travelDate, seatPreference, baseFare, luggageKg);
        this.travelClass = travelClass;
        this.isTatkal = isTatkal;
    }

    @Override
    public double calculateFare() {
        double fare = baseFare;

        // Class surcharge
        switch (travelClass.toLowerCase()) {
            case "ac 2-tier":
                fare += baseFare * 0.50;
                break;
            case "ac 3-tier":
                fare += baseFare * 0.30;
                break;
            case "sleeper":
            default:
                break;
        }

        // Tatkal ticket surcharge 30%
        if (isTatkal) {
            fare += baseFare * 0.30;
        }

        // Luggage charge: free first 25 kg, ₹20/kg after
        int freeLuggage = 25;
        if (luggageKg > freeLuggage) {
            fare += (luggageKg - freeLuggage) * 20;
        }

        // Seat preference surcharge: side lower/upper/other no charge, window +₹25
        if (seatPreference.equalsIgnoreCase("Window")) {
            fare += 25;
        }

        return fare;
    }

    @Override
    public double cancellationFee(LocalDate cancelDate) {
        long daysLeft = daysUntilTravel(cancelDate);
        if (daysLeft >= 10) {
            // 5% cancellation fee if 10 or more days left
            return baseFare * 0.05;
        } else if (daysLeft >= 3) {
            // 25% cancellation fee if 3 to 9 days left
            return baseFare * 0.25;
        } else if (daysLeft >= 1) {
            // 50% cancellation fee if 1 to 2 days left
            return baseFare * 0.50;
        } else {
            // No refund on/after travel day
            return baseFare;
        }
    }

    @Override
    public void displayTicketDetails() {
        System.out.println("=== Train Ticket ===");
        System.out.println("Ticket ID       : " + ticketId);
        System.out.println("Passenger Name  : " + passengerName);
        System.out.println("Travel Date     : " + travelDate);
        System.out.println("Travel Class    : " + travelClass);
        System.out.println("Tatkal Ticket   : " + (isTatkal ? "Yes" : "No"));
        System.out.println("Seat Preference : " + seatPreference);
        System.out.println("Luggage (kg)    : " + luggageKg);
        System.out.printf("Calculated Fare : ₹%.2f%n", calculateFare());
        System.out.println("----------------------------");
    }
}

// FlightTicket subclass
class FlightTicket extends Ticket {
    private String cabinClass; // Economy, Business, First
    private boolean extraBaggage; // If passenger opted for extra baggage
    private double baseBaggageAllowance; // kg
    private double extraBaggageChargePerKg;

    public FlightTicket(String ticketId, String passengerName, LocalDate travelDate, String seatPreference, double baseFare,
                        int luggageKg, String cabinClass, boolean extraBaggage) {
        super(ticketId, passengerName, travelDate, seatPreference, baseFare, luggageKg);
        this.cabinClass = cabinClass;
        this.extraBaggage = extraBaggage;
        this.baseBaggageAllowance = getBaseBaggageAllowance();
        this.extraBaggageChargePerKg = 500; // ₹500 per kg for extra baggage
    }

    private double getBaseBaggageAllowance() {
        switch (cabinClass.toLowerCase()) {
            case "first":
                return 50.0;
            case "business":
                return 40.0;
            case "economy":
            default:
                return 25.0;
        }
    }

    @Override
    public double calculateFare() {
        double fare = baseFare;

        // Cabin class surcharge
        switch (cabinClass.toLowerCase()) {
            case "first":
                fare += baseFare * 1.0; // 100% more
                break;
            case "business":
                fare += baseFare * 0.5; // 50% more
                break;
            case "economy":
            default:
                break;
        }

        // Seat preference surcharge: window +₹500, extra legroom +₹1000
        if (seatPreference.equalsIgnoreCase("Window")) {
            fare += 500;
        } else if (seatPreference.equalsIgnoreCase("Extra Legroom")) {
            fare += 1000;
        }

        // Luggage surcharge: charge if luggage > base allowance and extra baggage opted
        if (extraBaggage && luggageKg > baseBaggageAllowance) {
            fare += (luggageKg - baseBaggageAllowance) * extraBaggageChargePerKg;
        }

        return fare;
    }

    @Override
    public double cancellationFee(LocalDate cancelDate) {
        long daysLeft = daysUntilTravel(cancelDate);
        if (daysLeft >= 30) {
            // 10% cancellation fee if 30 or more days left
            return baseFare * 0.10;
        } else if (daysLeft >= 7) {
            // 50% cancellation fee if 7 to 29 days left
            return baseFare * 0.50;
        } else {
            // No refund if less than 7 days
            return baseFare;
        }
    }

    @Override
    public void displayTicketDetails() {
        System.out.println("=== Flight Ticket ===");
        System.out.println("Ticket ID        : " + ticketId);
        System.out.println("Passenger Name   : " + passengerName);
        System.out.println("Travel Date      : " + travelDate);
        System.out.println("Cabin Class      : " + cabinClass);
        System.out.println("Seat Preference  : " + seatPreference);
        System.out.println("Luggage (kg)     : " + luggageKg);
        System.out.println("Extra Baggage    : " + (extraBaggage ? "Yes" : "No"));
        System.out.printf("Calculated Fare  : ₹%.2f%n", calculateFare());
        System.out.println("----------------------------");
    }
}

public class p24 {
    public static void main(String[] args) {
        System.out.println("=== Transportation Ticket Booking System ===\n");

        BusTicket busTicket = new BusTicket("B001", "John Doe", LocalDate.of(2024, 12, 15),
                "Window", 1000.0, 25, "AC");
        busTicket.displayTicketDetails();
        System.out.printf("Cancellation Fee if cancelled 5 days before: ₹%.2f%n", busTicket.cancellationFee(LocalDate.of(2024, 12, 10)));

        System.out.println();

        TrainTicket trainTicket = new TrainTicket("T001", "Mary Jane", LocalDate.of(2024, 11, 20),
                "Aisle", 1500.0, 30, "AC 3-tier", true);
        trainTicket.displayTicketDetails();
        System.out.printf("Cancellation Fee if cancelled 4 days before: ₹%.2f%n", trainTicket.cancellationFee(LocalDate.of(2024, 11, 16)));

        System.out.println();

        FlightTicket flightTicket = new FlightTicket("F001", "Peter Parker", LocalDate.of(2025, 1, 5),
                "Extra Legroom", 10000.0, 60, "Business", true);
        flightTicket.displayTicketDetails();
        System.out.printf("Cancellation Fee if cancelled 10 days before: ₹%.2f%n", flightTicket.cancellationFee(LocalDate.of(2024, 12, 26)));
    }
}

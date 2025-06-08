package Day9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Base Room class
abstract class Room {
    protected int roomNumber;
    protected boolean isBooked;
    protected LocalDate checkInDate;
    protected LocalDate checkOutDate;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.checkInDate = null;
        this.checkOutDate = null;
    }

    // Abstract method to get base price per night
    public abstract double getBasePrice();

    // Calculate total price based on duration and dynamic pricing factor
    public double calculatePrice(LocalDate checkIn, LocalDate checkOut) {
        int nights = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
        if (nights <= 0) throw new IllegalArgumentException("Check-out date must be after check-in date");
        
        double dynamicFactor = getDynamicPricingFactor(checkIn, checkOut);
        return getBasePrice() * nights * dynamicFactor;
    }

    // Dynamic pricing factor based on season or occupancy or weekends (1.0 default)
    protected double getDynamicPricingFactor(LocalDate checkIn, LocalDate checkOut) {
        double factor = 1.0;
        // Increase price during peak season (Dec-Feb)
        if (isPeakSeason(checkIn, checkOut)) {
            factor += 0.25;  // +25%
        }
        // Increase price for weekend stays (+10% per weekend night)
        int weekendNights = countWeekendNights(checkIn, checkOut);
        factor += weekendNights * 0.10;
        // If occupancy is high, could add more factors here (not implemented)
        return factor;
    }

    private boolean isPeakSeason(LocalDate start, LocalDate end) {
        // Simple check for peak months Dec, Jan, Feb
        LocalDate current = start;
        while (!current.isAfter(end.minusDays(1))) {
            int month = current.getMonthValue();
            if (month == 12 || month == 1 || month == 2) return true;
            current = current.plusDays(1);
        }
        return false;
    }

    private int countWeekendNights(LocalDate start, LocalDate end) {
        int count = 0;
        LocalDate current = start;
        while (!current.isAfter(end.minusDays(1))) {
            switch (current.getDayOfWeek()) {
                case SATURDAY:
                case SUNDAY:
                    count++;
                    break;
                default:
                    break;
            }
            current = current.plusDays(1);
        }
        return count;
    }

    // Book the room if available
    public boolean bookRoom(LocalDate checkIn, LocalDate checkOut) {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " is already booked.");
            return false;
        }
        if (!isAvailableForPeriod(checkIn, checkOut)) {
            System.out.println("Room " + roomNumber + " is not available for the selected dates.");
            return false;
        }
        isBooked = true;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        System.out.println("Room " + roomNumber + " booked from " + checkIn + " to " + checkOut);
        return true;
    }

    // Check if the room is available for the booking period
    public boolean isAvailableForPeriod(LocalDate checkIn, LocalDate checkOut) {
        // If not booked, it is available
        if (!isBooked) return true;
        // Otherwise check for date overlap
        return checkOut.isBefore(checkInDate) || checkIn.isAfter(checkOutDate);
    }

    // Check out from room
    public void checkOut() {
        if (!isBooked) {
            System.out.println("Room " + roomNumber + " is currently not booked.");
            return;
        }
        System.out.println("Checking out from room " + roomNumber + ". Stayed from "
                + checkInDate + " to " + checkOutDate);
        isBooked = false;
        checkInDate = null;
        checkOutDate = null;
    }

    // Room details display including booking status
    public void displayDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type  : " + getClass().getSimpleName());
        System.out.printf("Base Price : ₹%.2f per night%n", getBasePrice());
        System.out.println("Booked     : " + (isBooked ? "Yes" : "No"));
        if (isBooked) {
            System.out.println("Check-in   : " + checkInDate);
            System.out.println("Check-out  : " + checkOutDate);
            System.out.printf("Price for stay: ₹%.2f%n", calculatePrice(checkInDate, checkOutDate));
        }
        System.out.println("----------------------------------");
    }
}

// Single room subclass
class SingleRoom extends Room {
    private boolean hasBalcony;

    public SingleRoom(int roomNumber, boolean hasBalcony) {
        super(roomNumber);
        this.hasBalcony = hasBalcony;
    }

    @Override
    public double getBasePrice() {
        return hasBalcony ? 3000 : 2500;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Balcony: " + (hasBalcony ? "Yes" : "No"));
    }
}

// Double room subclass
class DoubleRoom extends Room {
    private boolean hasSeaView;

    public DoubleRoom(int roomNumber, boolean hasSeaView) {
        super(roomNumber);
        this.hasSeaView = hasSeaView;
    }

    @Override
    public double getBasePrice() {
        return hasSeaView ? 4500 : 4000;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sea View: " + (hasSeaView ? "Yes" : "No"));
    }
}

// Suite subclass
class Suite extends Room {
    private int numBedrooms;
    private boolean hasJacuzzi;

    public Suite(int roomNumber, int numBedrooms, boolean hasJacuzzi) {
        super(roomNumber);
        this.numBedrooms = numBedrooms;
        this.hasJacuzzi = hasJacuzzi;
    }

    @Override
    public double getBasePrice() {
        // Price depends on bedrooms + jacuzzi premium
        double base = 8000 + (numBedrooms - 1) * 2500;
        if (hasJacuzzi) base += 1200;
        return base;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bedrooms: " + numBedrooms);
        System.out.println("Jacuzzi : " + (hasJacuzzi ? "Yes" : "No"));
    }
}

// Hotel class managing collection of rooms and bookings
class Hotel {
    private String name;
    List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Find available room by type and criteria
    public Room findAvailableRoom(Class<? extends Room> roomType) {
        for (Room room : rooms) {
            if (room.getClass() == roomType && !room.isBooked) {
                return room;
            }
        }
        return null;
    }

    // Book a room of specified type for given dates
    public boolean bookRoom(Class<? extends Room> roomType, LocalDate checkIn, LocalDate checkOut) {
        Room availableRoom = findAvailableRoom(roomType);
        if (availableRoom == null) {
            System.out.println("No available " + roomType.getSimpleName() + " found.");
            return false;
        }
        return availableRoom.bookRoom(checkIn, checkOut);
    }

    // Display all room statuses
    public void displayAllRooms() {
        System.out.println("Hotel: " + name);
        System.out.println("Room Status:");
        for (Room room : rooms) {
            room.displayDetails();
        }
    }
}

// Main class for Hotel Reservation System
public class p20 {

    public static void main(String[] args) {
        Hotel hotelParadise = new Hotel("Paradise Hotel");

        // Adding rooms to the hotel
        hotelParadise.addRoom(new SingleRoom(101, true));
        hotelParadise.addRoom(new SingleRoom(102, false));
        hotelParadise.addRoom(new DoubleRoom(201, true));
        hotelParadise.addRoom(new DoubleRoom(202, false));
        hotelParadise.addRoom(new Suite(301, 2, true));
        hotelParadise.addRoom(new Suite(302, 3, false));

        // Display initial room status
        hotelParadise.displayAllRooms();

        System.out.println("\n-- Booking Rooms --");
        // Book Single Room with Balcony
        hotelParadise.bookRoom(SingleRoom.class, LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 25));

        // Book Double Room without Sea View
        hotelParadise.bookRoom(DoubleRoom.class, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 20));

        // Book Suite
        hotelParadise.bookRoom(Suite.class, LocalDate.of(2024, 12, 24), LocalDate.of(2024, 12, 30));

        // Attempt to book another SingleRoom (should book the second one)
        hotelParadise.bookRoom(SingleRoom.class, LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 23));

        // Attempt to book unavailable Suite (should fail if none left)
        boolean success = hotelParadise.bookRoom(Suite.class, LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 23));
        if(!success) System.out.println("No suites available for requested dates.");

        // Display updated room status
        System.out.println("\n-- Updated Room Status --");
        hotelParadise.displayAllRooms();

        System.out.println("\n-- Checking Out Room 101 --");
        // Check out room 101
        for (Room room : hotelParadise.rooms) {
            if (room.roomNumber == 101) {
                room.checkOut();
            }
        }

        // Display final room status
        System.out.println("\n-- Final Room Status --");
        hotelParadise.displayAllRooms();
    }

}

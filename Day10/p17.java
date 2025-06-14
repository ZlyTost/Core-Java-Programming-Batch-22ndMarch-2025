package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Hotel Reservation System: 
Create classes for Room, Reservation, and Customer2. 
Implement methods for booking rooms and checking availability.
*/

// Class representing a Room
class Room {
    private int roomNumber;
    private String roomType; // e.g., Single, Double, Suite
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true; // Room is available by default
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false; // Mark room as booked
    }

    public void releaseRoom() {
        isAvailable = true; // Mark room as available
    }
}

// Class representing a Customer2
class Customer2 {
    private String name;
    private String contactNumber;

    public Customer2(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

// Class representing a Reservation
class Reservation {
    private Room room;
    private Customer2 Customer2;
    private int numberOfNights;

    public Reservation(Room room, Customer2 Customer2, int numberOfNights) {
        this.room = room;
        this.Customer2 = Customer2;
        this.numberOfNights = numberOfNights;
    }

    public double calculateTotalPrice() {
        return room.getPrice() * numberOfNights; // Calculate total price for the reservation
    }

    public Room getRoom() {
        return room;
    }

    public Customer2 getCustomer2() {
        return Customer2;
    }
}

// Class representing a Hotel
class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findAvailableRoom(String roomType) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomType().equalsIgnoreCase(roomType)) {
                return room; // Return the first available room of the specified type
            }
        }
        return null; // No available room found
    }
}

// Class representing the Booking System
class BookingSystem {
    private Hotel hotel;

    public BookingSystem(Hotel hotel) {
        this.hotel = hotel;
    }

    public void bookRoom(Customer2 Customer2, String roomType, int numberOfNights) {
        Room availableRoom = hotel.findAvailableRoom(roomType);
        if (availableRoom != null) {
            availableRoom.bookRoom(); // Book the room
            Reservation reservation = new Reservation(availableRoom, Customer2, numberOfNights);
            System.out.println("Room booked successfully!");
            System.out.println("Room Number: " + availableRoom.getRoomNumber());
            System.out.println("Total Price: $" + reservation.calculateTotalPrice());
        } else {
            System.out.println("No available rooms of type " + roomType + " found.");
        }
    }
}

// Main class to run the Hotel Reservation System
public class p17 {
    public static void main(String[] args) {
        // Create a hotel
        Hotel hotel = new Hotel();

        // Add rooms to the hotel
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(201, "Suite", 250.0));

        // Create a booking system
        BookingSystem bookingSystem = new BookingSystem(hotel);

        // Create a Customer2
        Customer2 Customer2 = new Customer2("Alice", "123-456-7890");

        // Book a room
        bookingSystem.bookRoom(Customer2, "Double", 3); // Book a double room for 3 nights
        bookingSystem.bookRoom(Customer2, "Single", 2); // Book a single room for 2 nights
    }
}

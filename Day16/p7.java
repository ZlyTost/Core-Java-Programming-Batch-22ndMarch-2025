package Day16;
//Hotel Management System
import java.util.Scanner;

//----------------------------- Abstract Class -----------------------------
abstract class HotelOperations {
    public abstract void bookRoom(String name, String roomType);
    public abstract void checkout(String name);
}

//----------------------------- Parent Class -----------------------------
class Hotel extends HotelOperations {
    // Static and Final
    private static int roomCounter = 100;
    public static final int MAX_ROOMS = 5;

    // Variables
    protected String[] guestNames = new String[MAX_ROOMS];
    protected String[] roomTypes = new String[MAX_ROOMS];
    protected boolean[] roomStatus = new boolean[MAX_ROOMS]; // true = booked
    protected double[] roomRates = new double[MAX_ROOMS];

    // Constructor
    public Hotel() {
        for (int i = 0; i < MAX_ROOMS; i++) {
            guestNames[i] = "";
            roomTypes[i] = "";
            roomStatus[i] = false;
            roomRates[i] = 0.0;
        }
    }

    // Encapsulation: Getters and Setters
    public String getGuest(int index) {
        return guestNames[index];
    }

    public void setGuest(int index, String name) {
        guestNames[index] = name;
    }

    public boolean isBooked(int index) {
        return roomStatus[index];
    }

    public void setBooked(int index, boolean status) {
        roomStatus[index] = status;
    }

    // Room Pricing (Polymorphism via Overloading)
    public double calculatePrice(String roomType) {
        if (roomType.equalsIgnoreCase("Deluxe")) return 3000;
        else if (roomType.equalsIgnoreCase("AC")) return 2000;
        else return 1000;
    }

    public double calculatePrice(String roomType, int nights) {
        return calculatePrice(roomType) * nights;
    }

    // Method to view all guests
    public void viewGuests() {
        System.out.println("\n--- Current Guests List ---");
        for (int i = 0; i < MAX_ROOMS; i++) {
            if (roomStatus[i]) {
                System.out.println("Room " + (i + 1) + ": " + guestNames[i] + " (" + roomTypes[i] + ")");
            }
        }
    }

    // Final Method
    public final void hotelInfo() {
        System.out.println("\nWelcome to Elite Stay Hotel - Total Rooms: " + MAX_ROOMS);
    }

    // Implementation of abstract methods
    @Override
    public void bookRoom(String name, String type) {
        for (int i = 0; i < MAX_ROOMS; i++) {
            if (!roomStatus[i]) {
                setGuest(i, name);
                roomTypes[i] = type;
                roomRates[i] = calculatePrice(type);
                setBooked(i, true);
                System.out.println("Room booked for " + name + ". Room No: " + (i + 1));
                return;
            }
        }
        System.out.println("Sorry! All rooms are currently booked.");
    }

    @Override
    public void checkout(String name) {
        for (int i = 0; i < MAX_ROOMS; i++) {
            if (roomStatus[i] && guestNames[i].equalsIgnoreCase(name)) {
                setBooked(i, false);
                System.out.println(name + " has checked out. Bill: ₹" + roomRates[i]);
                guestNames[i] = "";
                roomTypes[i] = "";
                roomRates[i] = 0.0;
                return;
            }
        }
        System.out.println("No booking found under the name: " + name);
    }
}

//----------------------------- Child Class -----------------------------
class EliteHotel extends Hotel {
    // Constructor
    public EliteHotel() {
        super(); // Call parent constructor
    }

    // Method Overriding (Polymorphism)
    @Override
    public void bookRoom(String name, String roomType) {
        System.out.println("\n[Elite Hotel Booking]");
        super.bookRoom(name, roomType); // Call parent method
    }

    // Display available rooms
    public void showAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (int i = 0; i < MAX_ROOMS; i++) {
            if (!isBooked(i)) {
                System.out.println("Room " + (i + 1) + " is available");
            }
        }
    }
}

//----------------------------- Main Class -----------------------------
public class p7{
    public static void main(String[] args) {
        EliteHotel hotel = new EliteHotel();
        Scanner sc = new Scanner(System.in);
        hotel.hotelInfo();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Book Room");
            System.out.println("2. View Guests");
            System.out.println("3. Checkout");
            System.out.println("4. Show Available Rooms");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room type (Deluxe/AC/Normal): ");
                    String type = sc.nextLine();
                    hotel.bookRoom(name, type);
                    break;

                case 2:
                    hotel.viewGuests();
                    break;

                case 3:
                    System.out.print("Enter guest name for checkout: ");
                    String guest = sc.nextLine();
                    hotel.checkout(guest);
                    break;

                case 4:
                    hotel.showAvailableRooms();
                    break;

                case 5:
                    System.out.println("Thank you for visiting Elite Stay Hotel!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

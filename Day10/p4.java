package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Movie Ticket Booking System: 
Develop classes for Movie, Theater, and Booking. 
Implement methods for booking tickets and checking availability.
*/

// Class representing a Movie
class Movie {
    private String title;
    private String genre;
    private int duration; // Duration in minutes

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }
}

// Class representing a Seat
class Seat {
    private String seatNumber;
    private boolean isBooked;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false; // Initially, the seat is not booked
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat() {
        isBooked = true;
    }

    @Override
    public String toString() {
        return seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}

// Class representing a Theater
class Theater {
    private String name;
    private String location;
    private List<Seat> seats;

    public Theater(String name, String location, int numberOfSeats) {
        this.name = name;
        this.location = location;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat("Seat " + i));
        }
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean checkAvailability() {
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                return true; // At least one seat is available
            }
        }
        return false; // No seats available
    }

    public void displaySeats() {
        System.out.println("Available seats in " + name + ":");
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }
}

// Class representing a Booking
class Booking {
    private Movie movie;
    private Theater theater;
    private List<Seat> bookedSeats;

    public Booking(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
        this.bookedSeats = new ArrayList<>();
    }

    public boolean bookTicket(String seatNumber) {
        for (Seat seat : theater.getSeats()) {
            if (seat.getSeatNumber().equals(seatNumber) && !seat.isBooked()) {
                seat.bookSeat();
                bookedSeats.add(seat);
                System.out.println("Ticket booked for " + movie.getTitle() + " at " + theater.getName() + " for " + seatNumber);
                return true;
            }
        }
        System.out.println("Seat " + seatNumber + " is not available.");
        return false;
    }

    public void showBookedSeats() {
        System.out.println("Booked seats for " + movie.getTitle() + ":");
        for (Seat seat : bookedSeats) {
            System.out.println(seat.getSeatNumber());
        }
    }
}

// Class representing a User9
class User9 {
    private String User9name;

    public User9(String User9name) {
        this.User9name = User9name;
    }

    public String getUser9name() {
        return User9name;
    }

    public void bookTicket(Movie movie, Theater theater, String seatNumber) {
        Booking booking = new Booking(movie, theater);
        booking.bookTicket(seatNumber);
        booking.showBookedSeats();
    }
}

// Main class to run the Movie Ticket Booking System
public class p4 {
    public static void main(String[] args) {
        // Create a movie
        Movie movie = new Movie("Inception", "Sci-Fi", 148);

        // Create a theater
        Theater theater = new Theater("Cineplex", "Downtown", 10);

        // Create a User9
        User9 User9 = new User9("Alice");

        // Display available seats
        theater.displaySeats();

        // Check availability
        if (theater.checkAvailability()) {
            // User9 books a ticket
            User9.bookTicket(movie, theater, "Seat 1");
        }

        // Display available seats after booking
        theater.displaySeats();

        // Attempt to book the same seat again
        User9.bookTicket(movie, theater, "Seat 1");
    }
}

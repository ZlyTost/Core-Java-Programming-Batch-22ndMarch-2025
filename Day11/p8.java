package Day11;
//A system to manage hotel bookings.

//Class representing a hotel room
class Room {
 private int roomNumber;
 private boolean isBooked;

 // Constructor
 public Room(int roomNumber) {
     this.roomNumber = roomNumber;
     this.isBooked = false; // Room is initially not booked
 }

 // Method to book the room
 public void book() {
     if (!isBooked) {
         isBooked = true;
         System.out.println("Room " + roomNumber + " booked successfully.");
     } else {
         System.out.println("Room " + roomNumber + " is already booked.");
     }
 }

 // Method to check booking status
 public boolean isBooked() {
     return isBooked;
 }
}

public class p8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

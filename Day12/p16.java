package Day12;
/*
 8. Hotel Management System
Description: A hotel management system that allows booking rooms, 
checking availability, and displaying booking details.
 */
//Abstract class representing a Room
abstract class Room {
 protected String roomNumber;
 protected boolean isAvailable;

 public Room(String roomNumber) {
     this.roomNumber = roomNumber;
     this.isAvailable = true;
 }

 public abstract void bookRoom();
 public abstract void displayRoomDetails();
}

//Class representing a Deluxe Room
class DeluxeRoom extends Room {
 public DeluxeRoom(String roomNumber) {
     super(roomNumber);
 }

 @Override
 public void bookRoom() {
     if (isAvailable) {
         isAvailable = false;
         System.out.println("Room " + roomNumber + " booked successfully.");
     } else {
         System.out.println("Room " + roomNumber + " is already booked.");
     }
 }

 @Override
 public void displayRoomDetails() {
     System.out.println("Deluxe Room Number: " + roomNumber + ", Available: " + isAvailable);
 }
}

//Main class to test the Hotel Management System
public class p16 {
 public static void main(String[] args) {
     Room room = new DeluxeRoom("101");
     room.displayRoomDetails();
     room.bookRoom();
     room.displayRoomDetails();
 }
}

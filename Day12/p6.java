package Day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 22. Event Management System
Description: An event management system that allows users to create events, 
register attendees, and view event details.
 */
//Interface for Event Operations
interface EventOperations {
 void createEvent(String eventName);
 void registerAttendee(String eventName, String attendeeName);
 void viewEventDetails(String eventName);
}

//Class representing an Event Manager
class EventManager implements EventOperations {
 private Map<String, List<String>> events = new HashMap<>();

 @Override
 public void createEvent(String eventName) {
     events.put(eventName, new ArrayList<>());
     System.out.println("Created event: " + eventName);
 }

 @Override
 public void registerAttendee(String eventName, String attendeeName) {
     List<String> attendees = events.get(eventName);
     if (attendees != null) {
         attendees.add(attendeeName);
         System.out.println("Registered " + attendeeName + " for event: " + eventName);
     } else {
         System.out.println("Event not found.");
     }
 }

 @Override
 public void viewEventDetails(String eventName) {
     List<String> attendees = events.get(eventName);
     if (attendees != null) {
         System.out.println("Event: " + eventName + ", Attendees: " + attendees);
     } else {
         System.out.println("Event not found.");
     }
 }
}

//Main class to test the Event Management System
public class p6 {
 public static void main(String[] args) {
     EventManager manager = new EventManager();
     manager.createEvent("Tech Conference");
     manager.registerAttendee("Tech Conference", "Alice");
     manager.registerAttendee("Tech Conference", "Bob");
     manager.viewEventDetails("Tech Conference");
 }
}

package Day12;

import java.util.HashMap;
import java.util.Map;

/*
 17. Contact Management System
Description: A contact management system that allows users to add 
contacts, search for them, and display contact details.
 */
//Interface for Contact Operations
interface ContactOperations {
 void addContact(String name, String phone);
 void searchContact(String name);
}

//Class representing a Contact Manager
class ContactManager implements ContactOperations {
 private Map<String, String> contacts = new HashMap<>();

 @Override
 public void addContact(String name, String phone) {
     contacts.put(name, phone);
     System.out.println("Added contact: " + name);
 }

 @Override
 public void searchContact(String name) {
     String phone = contacts.get(name);
     if (phone != null) {
         System.out.println("Contact found: " + name + ", Phone: " + phone);
     } else {
         System.out.println("Contact not found.");
     }
 }
}

//Main class to test the Contact Management System
public class p24 {
 public static void main(String[] args) {
     ContactManager manager = new ContactManager();
     manager.addContact("Alice", "123-456-7890");
     manager.addContact("Bob", "987-654-3210");
     manager.searchContact("Alice");
     manager.searchContact("Charlie");
 }
}

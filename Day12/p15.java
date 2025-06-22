package Day12;

import java.util.HashMap;
import java.util.Map;

/*
7. Inventory Management System
Description: An inventory management system that allows adding items, 
updating stock, and checking stock levels.
 */
//Interface for Inventory Operations
interface InventoryOperations {
 void addItem(String itemName, int quantity);
 void updateStock(String itemName, int quantity);
 int checkStock(String itemName);
}

//Class representing an Inventory
class Inventory implements InventoryOperations {
 private Map<String, Integer> items = new HashMap<>();

 @Override
 public void addItem(String itemName, int quantity) {
     items.put(itemName, quantity);
     System.out.println("Added item: " + itemName + " with quantity: " + quantity);
 }

 @Override
 public void updateStock(String itemName, int quantity) {
     if (items.containsKey(itemName)) {
         items.put(itemName, items.get(itemName) + quantity);
         System.out.println("Updated stock for: " + itemName + " to " + items.get(itemName));
     } else {
         System.out.println("Item not found.");
     }
 }

 @Override
 public int checkStock(String itemName) {
     return items.getOrDefault(itemName, 0);
 }
}

//Main class to test the Inventory Management System
public class p15 {
 public static void main(String[] args) {
     Inventory inventory = new Inventory();
     inventory.addItem("Laptop", 10);
     inventory.updateStock("Laptop", 5);
     System.out.println("Current stock of Laptop: " + inventory.checkStock("Laptop"));
 }
}

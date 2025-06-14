package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Inventory Management System: 
Develop classes for Product1, Inventory, and Supplier. 
Implement methods for adding/removing Product1s and tracking stock levels.
*/

// Class representing a Product1
class Product1 {
    private String name;
    private double price;
    private int quantity;

    public Product1(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addStock(int amount) {
        quantity += amount; // Increase stock quantity
    }

    public void removeStock(int amount) {
        if (amount <= quantity) {
            quantity -= amount; // Decrease stock quantity
        } else {
            System.out.println("Insufficient stock for " + name);
        }
    }
}

// Class representing a Supplier
class Supplier {
    private String name;
    private String contactInfo;

    public Supplier(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}

// Class representing the Inventory
class Inventory {
    private List<Product1> Product1s;

    public Inventory() {
        Product1s = new ArrayList<>();
    }

    public void addProduct1(Product1 Product1) {
        Product1s.add(Product1);
        System.out.println("Product1 added: " + Product1.getName());
    }

    public void removeProduct1(Product1 Product1) {
        if (Product1s.remove(Product1)) {
            System.out.println("Product1 removed: " + Product1.getName());
        } else {
            System.out.println("Product1 not found: " + Product1.getName());
        }
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Product1 Product1 : Product1s) {
            System.out.println(" - " + Product1.getName() + ": $" + Product1.getPrice() + ", Quantity: " + Product1.getQuantity());
        }
    }

    public Product1 findProduct1(String Product1Name) {
        for (Product1 Product1 : Product1s) {
            if (Product1.getName().equalsIgnoreCase(Product1Name)) {
                return Product1; // Return the Product1 if found
            }
        }
        return null; // Product1 not found
    }
}

// Class representing the Inventory Management System
class InventoryManagementSystem {
    private Inventory inventory;

    public InventoryManagementSystem() {
        inventory = new Inventory();
    }

    public void addProduct1ToInventory(Product1 Product1) {
        inventory.addProduct1(Product1);
    }

    public void removeProduct1FromInventory(String Product1Name) {
        Product1 Product1 = inventory.findProduct1(Product1Name);
        if (Product1 != null) {
            inventory.removeProduct1(Product1);
        } else {
            System.out.println("Product1 not found: " + Product1Name);
        }
    }

    public void addStockToProduct1(String Product1Name, int amount) {
        Product1 Product1 = inventory.findProduct1(Product1Name);
        if (Product1 != null) {
            Product1.addStock(amount);
            System.out.println("Added " + amount + " to " + Product1Name);
        } else {
            System.out.println("Product1 not found: " + Product1Name);
        }
    }

    public void removeStockFromProduct1(String Product1Name, int amount) {
        Product1 Product1 = inventory.findProduct1(Product1Name);
        if (Product1 != null) {
            Product1.removeStock(amount);
            System.out.println("Removed " + amount + " from " + Product1Name);
        } else {
            System.out.println("Product1 not found: " + Product1Name);
        }
    }

    public void displayInventory() {
        inventory.displayInventory();
    }
}

// Main class to run the Inventory Management System
public class p18 {
    public static void main(String[] args) {
        // Create an inventory management system
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Create Product1s
        Product1 Product11 = new Product1("Laptop", 1200.00, 10);
        Product1 Product12 = new Product1("Smartphone", 800.00, 20);
        Product1 Product13 = new Product1("Headphones", 150.00, 30);

        // Add Product1s to inventory
        ims.addProduct1ToInventory(Product11);
        ims.addProduct1ToInventory(Product12);
        ims.addProduct1ToInventory(Product13);

        // Display current inventory
        ims.displayInventory();

        // Add stock to a Product1
        ims.addStockToProduct1("Laptop", 5);

        // Remove stock from a Product1
        ims.removeStockFromProduct1("Smartphone", 3);

        // Remove a Product1 from inventory
        ims.removeProduct1FromInventory("Headphones");

        // Display current inventory again
        ims.displayInventory();
    }
}

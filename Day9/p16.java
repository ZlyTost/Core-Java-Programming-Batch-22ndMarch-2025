package Day9;

// E-commerce Product Catalog demonstrating inheritance, polymorphism, and complex logic

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Base Product class
abstract class Product {
    protected String productId;
    protected String name;
    protected double basePrice;
    protected int stockQty;

    public Product(String productId, String name, double basePrice, int stockQty) {
        this.productId = productId;
        this.name = name;
        this.basePrice = basePrice;
        this.stockQty = stockQty;
    }

    // Calculate final price including taxes and discounts (defined in derived)
    public abstract double calculatePrice();

    // Reduce stock by quantity, return true if successful
    public boolean purchase(int quantity) {
        if (quantity <= stockQty) {
            stockQty -= quantity;
            System.out.println(quantity + " units of " + name + " purchased successfully.");
            return true;
        } else {
            System.out.println("Insufficient stock for " + name);
            return false;
        }
    }

    // Display product information
    public void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name      : " + name);
        System.out.println("Base Price: ₹" + basePrice);
        System.out.println("Stock Qty : " + stockQty);
        System.out.printf("Final Price after taxes/discount: ₹%.2f%n", calculatePrice());
        System.out.println("------------------------------------");
    }
}

// Electronic product subclass with warranty and eco discount
class ElectronicProduct extends Product {
    private int warrantyMonths;
    private boolean ecoFriendly;

    public ElectronicProduct(String productId, String name, double basePrice, int stockQty,
                             int warrantyMonths, boolean ecoFriendly) {
        super(productId, name, basePrice, stockQty);
        this.warrantyMonths = warrantyMonths;
        this.ecoFriendly = ecoFriendly;
    }

    // Electronics have 18% GST, possible eco discount of 5%
    @Override
    public double calculatePrice() {
        double gst = basePrice * 0.18;
        double discount = ecoFriendly ? basePrice * 0.05 : 0;
        return basePrice + gst - discount;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Electronics]");
        super.displayInfo();
        System.out.println("Warranty     : " + warrantyMonths + " months");
        System.out.println("Eco Friendly : " + (ecoFriendly ? "Yes" : "No"));
        System.out.println();
    }
}

// Clothing product subclass with size, fabric, seasonal discount
class ClothingProduct extends Product {
    private String size;
    private String fabricMaterial;
    private String season; // E.g., Summer, Winter

    public ClothingProduct(String productId, String name, double basePrice, int stockQty,
                           String size, String fabricMaterial, String season) {
        super(productId, name, basePrice, stockQty);
        this.size = size;
        this.fabricMaterial = fabricMaterial;
        this.season = season;
    }

    // Clothing GST is 12%, with seasonal discount if off-season
    @Override
    public double calculatePrice() {
        double gst = basePrice * 0.12;
        double discount = 0;

        // If it is off-season, apply 20% discount
        if (isOffSeason()) {
            discount = (basePrice + gst) * 0.20;
        }

        return basePrice + gst - discount;
    }

    private boolean isOffSeason() {
        // Assume current month as October (10) for demo
        int currentMonth = 10;
        if (season.equalsIgnoreCase("Summer") && (currentMonth < 4 || currentMonth > 6)) {
            return true;
        } else if (season.equalsIgnoreCase("Winter") && (currentMonth < 11 && currentMonth > 2)) {
            return true;
        } 
        return false;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Clothing]");
        super.displayInfo();
        System.out.println("Size          : " + size);
        System.out.println("Fabric        : " + fabricMaterial);
        System.out.println("Season        : " + season);
        System.out.printf("Off Season Sale: %s%n", isOffSeason() ? "Yes - 20% Discount" : "No");
        System.out.println();
    }
}

// Grocery product subclass with expiry and bulk discount
class GroceryProduct extends Product {
    private LocalDate expiryDate;
    private boolean isOrganic;

    public GroceryProduct(String productId, String name, double basePrice, int stockQty,
                          LocalDate expiryDate, boolean isOrganic) {
        super(productId, name, basePrice, stockQty);
        this.expiryDate = expiryDate;
        this.isOrganic = isOrganic;
    }

    // Grocery GST is 5%, with bulk discount and price increases closer to expiry
    @Override
    public double calculatePrice() {
        double gst = basePrice * 0.05;
        double price = basePrice + gst;

        long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);

        // Increase price if expiry is more than 10 days away for organic products
        if (isOrganic && daysToExpiry > 10) {
            price *= 1.10; // 10% premium for organic fresh produce
        }

        // Bulk purchase discount not applied here because this is final price per unit
        return price;
    }

    // Provide info about expiry and freshness
    public void displayExpiryInfo() {
        long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        System.out.println("Expiry Date     : " + expiryDate);
        System.out.println("Days to Expiry  : " + daysLeft);
        System.out.println("Organic        : " + (isOrganic ? "Yes" : "No"));
        if (daysLeft < 5) {
            System.out.println("Alert: Product nearing expiry!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("[Grocery]");
        super.displayInfo();
        displayExpiryInfo();
        System.out.println();
    }
}

// Main class: E-commerce Catalog showcasing Products
public class p16 {
    public static void main(String[] args) {
        System.out.println("======= E-commerce Product Catalog =======\n");

        ElectronicProduct laptop = new ElectronicProduct("E1001", "Laptop Pro 15\"", 85000, 25, 24, true);
        laptop.displayInfo();

        ClothingProduct tshirt = new ClothingProduct("C2001", "Men's Casual T-shirt", 799, 100, "L", "Cotton", "Summer");
        tshirt.displayInfo();

        GroceryProduct apple = new GroceryProduct("G3001", "Fresh Red Apples (1kg)", 150, 200, LocalDate.now().plusDays(12), true);
        apple.displayInfo();

        GroceryProduct milk = new GroceryProduct("G3002", "Organic Milk 1L", 75, 500, LocalDate.now().plusDays(3), true);
        milk.displayInfo();

        // Demonstrate purchase and stock update
        System.out.println("Purchasing 3 laptops:");
        laptop.purchase(3);
        laptop.displayInfo();

        System.out.println("Purchasing 120 T-shirts:");
        tshirt.purchase(120);  // Should show insufficient stock

        System.out.println("Purchasing 50 apples:");
        apple.purchase(50);
        apple.displayInfo();
    }
}


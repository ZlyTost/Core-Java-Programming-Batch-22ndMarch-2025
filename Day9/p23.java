package Day9;

import java.util.*;

// Base class representing an item on the restaurant menu
abstract class MenuItem {
    protected String itemId;
    protected String name;
    protected double price;
    protected List<String> ingredients;

    public MenuItem(String itemId, String name, double price, List<String> ingredients) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(ingredients);
    }

    // Calculate price including tax and any discounts (category specific)
    public abstract double calculateFinalPrice();

    // Display basic info about the item
    public void displayInfo() {
        System.out.println("Item ID     : " + itemId);
        System.out.println("Name        : " + name);
        System.out.println("Base Price  : ₹" + price);
        System.out.println("Ingredients : " + String.join(", ", ingredients));
        System.out.printf("Final Price : ₹%.2f%n", calculateFinalPrice());
    }
}

// Food item subclass includes calorie information and discount logic
class FoodItem extends MenuItem {
    private int calories;
    private static final double GST_RATE = 0.05;  // 5% GST on food

    public FoodItem(String itemId, String name, double price, List<String> ingredients, int calories) {
        super(itemId, name, price, ingredients);
        this.calories = calories;
    }

    @Override
    public double calculateFinalPrice() {
        double tax = price * GST_RATE;
        double discount = 0.0;
        // Example: 10% discount on vegetarian food
        if (isVegetarian()) {
            discount = price * 0.10;
        }
        return price + tax - discount;
    }

    private boolean isVegetarian() {
        // Simplified check: if no meat/fish in ingredients, consider vegetarian
        List<String> nonVegItems = Arrays.asList("chicken", "beef", "pork", "fish", "mutton", "egg");
        for (String ingredient : ingredients) {
            if (nonVegItems.stream().anyMatch(ingredient.toLowerCase()::contains)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Food Item ===");
        super.displayInfo();
        System.out.println("Calories    : " + calories + " kcal");
        System.out.println("---------------------------");
    }
}

// Beverage item subclass includes size and alcohol content
class BeverageItem extends MenuItem {
    private String size;  // e.g., Small, Medium, Large
    private boolean isAlcoholic;
    private static final double GST_RATE_ALCOHOL = 0.18;
    private static final double GST_RATE_NON_ALCOHOL = 0.12;

    public BeverageItem(String itemId, String name, double price, List<String> ingredients, String size, boolean isAlcoholic) {
        super(itemId, name, price, ingredients);
        this.size = size;
        this.isAlcoholic = isAlcoholic;
    }

    @Override
    public double calculateFinalPrice() {
        double gstRate = isAlcoholic ? GST_RATE_ALCOHOL : GST_RATE_NON_ALCOHOL;
        double tax = price * gstRate;

        // Example discount: 5% discount on Large non-alcoholic beverages
        double discount = 0.0;
        if (!isAlcoholic && "Large".equalsIgnoreCase(size)) {
            discount = price * 0.05;
        }
        return price + tax - discount;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Beverage Item ===");
        super.displayInfo();
        System.out.println("Size         : " + size);
        System.out.println("Alcoholic    : " + (isAlcoholic ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
}

// Dessert item subclass includes sugar content and a special tax exemption
class DessertItem extends MenuItem {
    private int sugarContentGrams;
    private static final double GST_RATE = 0.05; // 5% GST on desserts

    public DessertItem(String itemId, String name, double price, List<String> ingredients, int sugarContentGrams) {
        super(itemId, name, price, ingredients);
        this.sugarContentGrams = sugarContentGrams;
    }

    @Override
    public double calculateFinalPrice() {
        // Desserts with more than 30g sugar have an extra surcharge of ₹10
        double tax = price * GST_RATE;
        double surcharge = (sugarContentGrams > 30) ? 10.0 : 0.0;
        return price + tax + surcharge;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Dessert Item ===");
        super.displayInfo();
        System.out.println("Sugar Content : " + sugarContentGrams + "g");
        System.out.println("---------------------------");
    }
}

// Order class to manage multiple menu items and calculate total
class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private List<MenuItem> items;
    private boolean isPaid;

    public Order() {
        this.orderId = nextOrderId++;
        this.items = new ArrayList<>();
        this.isPaid = false;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println(item.name + " added to order.");
    }

    public void removeItem(String itemId) {
        items.removeIf(item -> item.itemId.equals(itemId));
        System.out.println("Item with ID " + itemId + " removed from order.");
    }

    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.calculateFinalPrice();
        }
        return total;
    }

    public void payOrder() {
        if (items.isEmpty()) {
            System.out.println("Order is empty. Cannot process payment.");
            return;
        }
        if (isPaid) {
            System.out.println("Order is already paid.");
            return;
        }
        double amount = calculateTotal();
        System.out.printf("Processing payment of ₹%.2f for Order ID: %d%n", amount, orderId);
        isPaid = true;
        System.out.println("Payment successful. Thank you!");
    }

    public void displayOrderDetails() {
        System.out.println("=== Order ID: " + orderId + " ===");
        if (items.isEmpty()) {
            System.out.println("Order is empty.");
        } else {
            for (MenuItem item : items) {
                item.displayInfo();
            }
            System.out.printf("Order Total: ₹%.2f%n", calculateTotal());
            System.out.println("Order Paid : " + (isPaid ? "Yes" : "No"));
        }
        System.out.println("---------------------");
    }
}

public class p23 {
    public static void main(String[] args) {
        System.out.println("=== Restaurant Menu and Ordering System ===\n");

        // Create some menu items
        FoodItem pasta = new FoodItem("F101", "Veggie Pasta", 350, Arrays.asList("pasta", "tomato", "basil", "cheese"), 600);
        FoodItem chickenCurry = new FoodItem("F102", "Chicken Curry", 450, Arrays.asList("chicken", "spices", "cream"), 700);
        BeverageItem cola = new BeverageItem("B201", "Cola", 120, Arrays.asList("water", "sugar", "flavor"), "Medium", false);
        BeverageItem whiskey = new BeverageItem("B202", "Whiskey", 600, Arrays.asList("barley", "yeast", "water"), "Small", true);
        DessertItem cheesecake = new DessertItem("D301", "Cheesecake", 300, Arrays.asList("cream cheese", "sugar", "eggs"), 35);

        // Display info
        pasta.displayInfo();
        chickenCurry.displayInfo();
        cola.displayInfo();
        whiskey.displayInfo();
        cheesecake.displayInfo();

        // Create order and add items
        Order order1 = new Order();
        order1.addItem(pasta);
        order1.addItem(cola);
        order1.addItem(cheesecake);

        // Show order details
        order1.displayOrderDetails();

        // Add more items and pay
        order1.addItem(whiskey);
        order1.displayOrderDetails();

        order1.payOrder();

        // Attempt to pay again
        order1.payOrder();

        // Remove item and show order updates
        order1.removeItem("B201");
        order1.displayOrderDetails();
    }
}

package Day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 20. Online Store System
Description: An online store system that allows users to browse products, 
add them to a cart, and checkout.
 */
//Interface for Store Operations
interface StoreOperations {
 void addProduct(String productName, double price);
 void addToCart(String productName);
 void checkout();
}

//Class representing an Online Store
class OnlineStore implements StoreOperations {
 private Map<String, Double> products = new HashMap<>();
 private List<String> cart = new ArrayList<>();

 @Override
 public void addProduct(String productName, double price) {
     products.put(productName, price);
     System.out.println("Added product: " + productName + " for $" + price);
 }

 @Override
 public void addToCart(String productName) {
     if (products.containsKey(productName)) {
         cart.add(productName);
         System.out.println("Added to cart: " + productName);
     } else {
         System.out.println("Product not found.");
     }
 }

 @Override
 public void checkout() {
     double total = 0;
     System.out.println("Checkout:");
     for (String product : cart) {
         total += products.get(product);
         System.out.println("- " + product + ": $" + products.get(product));
     }
     System.out.println("Total: $" + total);
 }
}

//Main class to test the Online Store System
public class p4 {
 public static void main(String[] args) {
     OnlineStore store = new OnlineStore();
     store.addProduct("Laptop", 999.99);
     store.addProduct("Mouse", 49.99);
     store.addToCart("Laptop");
     store.addToCart("Mouse");
     store.checkout();
 }
}

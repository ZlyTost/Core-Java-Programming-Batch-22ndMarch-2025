package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 4. E-commerce System
Description: An e-commerce system that allows adding products 
and calculating the total price.
 */
//Interface for Product Operations
interface ProductOperations {
 void addProduct(String name, double price);
 double calculateTotalPrice();
}

//Class representing a Shopping Cart
class ShoppingCart implements ProductOperations {
 private List<Product> products = new ArrayList<>();

 private class Product {
     String name;
     double price;

     Product(String name, double price) {
         this.name = name;
         this.price = price;
     }
 }

 @Override
 public void addProduct(String name, double price) {
     products.add(new Product(name, price));
     System.out.println("Added product: " + name);
 }

 @Override
 public double calculateTotalPrice() {
     double total = 0;
     for (Product product : products) {
         total += product.price;
     }
     return total;
 }
}

//Main class to test the E-commerce System
public class p12 {
 public static void main(String[] args) {
     ShoppingCart cart = new ShoppingCart();
     cart.addProduct("Laptop", 1000);
     cart.addProduct("Mouse", 50);
     System.out.println("Total Price: " + cart.calculateTotalPrice());
 }
}

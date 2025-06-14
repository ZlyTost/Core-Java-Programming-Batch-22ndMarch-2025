package Day10;

import java.util.ArrayList;
import java.util.List;

/*
E-commerce Shopping Cart: 
Implement classes for Product, Cart, and User. 
Allow users to add/remove products and calculate total price with discounts.
*/

// Class representing a Product
class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

// Class representing a Cart
class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println(product.getName() + " removed from cart.");
        } else {
            System.out.println(product.getName() + " not found in cart.");
        }
    }

    public double calculateTotalPrice(Discount discount) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return discount.applyDiscount(total);
    }

    public void displayCart() {
        System.out.println("Products in Cart:");
        for (Product product : products) {
            System.out.println(" - " + product.getName() + ": $" + product.getPrice());
        }
    }
}

// Class representing a User
class User {
    private String username;
    private Cart cart;

    public User(String username) {
        this.username = username;
        this.cart = new Cart();
    }

    public String getUsername() {
        return username;
    }

    public Cart getCart() {
        return cart;
    }
}

// Class representing a Discount
class Discount {
    private double percentage;

    public Discount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double total) {
        return total - (total * (percentage / 100));
    }
}

// Class representing the Shopping Cart System
class ShoppingCartSystem {
    public static void main(String[] args) {
        // Create a user
        User user = new User("JohnDoe");

        // Create products
        Product product1 = new Product("Laptop", 1200.00, "Electronics");
        Product product2 = new Product("Headphones", 150.00, "Electronics");
        Product product3 = new Product("Coffee Maker", 80.00, "Home Appliances");

        // Add products to the user's cart
        user.getCart().addProduct(product1);
        user.getCart().addProduct(product2);
        user.getCart().addProduct(product3);

        // Display cart contents
        user.getCart().displayCart();

        // Create a discount
        Discount discount = new Discount(10); // 10% discount

        // Calculate total price with discount
        double totalPrice = user.getCart().calculateTotalPrice(discount);
        System.out.println("Total Price after discount: $" + totalPrice);

        // Remove a product from the cart
        user.getCart().removeProduct(product2);

        // Display cart contents again
        user.getCart().displayCart();
    }
}

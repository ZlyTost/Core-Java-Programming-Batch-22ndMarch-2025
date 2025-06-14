package Day10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Credit Card System:
Design classes CreditCard, Transaction3, User13, Billing, and specific card types 
(StandardCard, PremiumCard) showing inheritance and polymorphism.
*/

// Class representing a User13 (cardholder)
class User13 {
    private String name;
    private String User13Id;

    public User13(String name, String User13Id) {
        this.name = name;
        this.User13Id = User13Id;
    }

    public String getName() {
        return name;
    }

    public String getUser13Id() {
        return User13Id;
    }
}

// Class representing a Transaction3
class Transaction3 {
    private double amount;
    private Date date;
    private String description;

    public Transaction3(double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.date = new Date(); // Transaction3 date is current date
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Transaction3[Amount: $%.2f, Date: %s, Description: %s]", 
                             amount, date.toString(), description);
    }
}

// Abstract base class representing a Credit Card
abstract class CreditCard {
    protected String cardNumber;
    protected User13 User13;
    protected double creditLimit;
    protected double balance; // Amount currently owed
    protected List<Transaction3> Transaction3History;

    public CreditCard(String cardNumber, User13 User13, double creditLimit) {
        this.cardNumber = cardNumber;
        this.User13 = User13;
        this.creditLimit = creditLimit;
        this.balance = 0;
        this.Transaction3History = new ArrayList<>();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public User13 getUser13() {
        return User13;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    // Method to charge this card with a purchase amount
    public boolean makePurchase(double amount, String description) {
        if (amount <= 0) {
            System.out.println("Purchase amount must be positive");
            return false;
        }
        double potentialBalance = balance + amount + calculateFees(amount);
        if (potentialBalance > creditLimit) {
            System.out.println("Transaction3 declined: exceeds credit limit");
            return false;
        }
        Transaction3 Transaction3 = new Transaction3(amount, description);
        Transaction3History.add(Transaction3);
        balance += amount + calculateFees(amount);
        System.out.println("Purchase approved: " + Transaction3);
        System.out.println("Fees applied: $" + String.format("%.2f", calculateFees(amount)));
        return true;
    }

    // Method to make a payment reducing the balance
    public void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Payment amount must be positive");
            return;
        }
        balance -= amount;
        if (balance < 0) balance = 0;
        System.out.println("Payment of $" + amount + " received. New balance: $" + balance);
    }

    // Abstract method to calculate fees for a Transaction3 (overridden in subclasses)
    protected abstract double calculateFees(double amount);

    public void showStatement() {
        System.out.println("Statement for Card: " + cardNumber);
        System.out.println("Cardholder: " + User13.getName());
        System.out.println("Credit Limit: $" + creditLimit);
        System.out.println("Balance: $" + balance);
        System.out.println("Transaction3s:");
        for (Transaction3 t : Transaction3History) {
            System.out.println(t);
        }
        System.out.println(); // blank line for readability
    }
}

// Class representing a Standard Credit Card with basic fee structure
class StandardCard extends CreditCard {
    private static final double Transaction3_FEE_RATE = 0.02; // 2% fee per Transaction3

    public StandardCard(String cardNumber, User13 User13, double creditLimit) {
        super(cardNumber, User13, creditLimit);
    }

    @Override
    protected double calculateFees(double amount) {
        return amount * Transaction3_FEE_RATE;
    }
}

// Class representing a Premium Credit Card with waived fees
class PremiumCard extends CreditCard {
    public PremiumCard(String cardNumber, User13 User13, double creditLimit) {
        super(cardNumber, User13, creditLimit);
    }

    @Override
    protected double calculateFees(double amount) {
        // Premium cards have no Transaction3 fees
        return 0;
    }
}

// Class representing Billing operations
class Billing {
    private CreditCard card;

    public Billing(CreditCard card) {
        this.card = card;
    }

    public void generateStatement() {
        System.out.println("---- Billing Statement ----");
        card.showStatement();
    }
}

// Main class to run the Credit Card system
public class p9 {
    public static void main(String[] args) {
        User13 User131 = new User13("John Doe", "U123");
        User13 User132 = new User13("Jane Smith", "U456");

        CreditCard standardCard = new StandardCard("1111-2222-3333-4444", User131, 5000);
        CreditCard premiumCard = new PremiumCard("5555-6666-7777-8888", User132, 10000);

        standardCard.makePurchase(1000, "Laptop");
        standardCard.makePurchase(200, "Groceries");
        standardCard.makePayment(500);

        premiumCard.makePurchase(3000, "Smartphone");
        premiumCard.makePurchase(1500, "Vacation");
        premiumCard.makePayment(1000);

        Billing billingStandard = new Billing(standardCard);
        Billing billingPremium = new Billing(premiumCard);

        billingStandard.generateStatement();
        billingPremium.generateStatement();
    }
}

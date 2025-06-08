package Day9;

// Base Class - GrandFather5
class GrandFather5 {
    String name;
    int noOfPlots;
    int bankBalance;
    String location;
    int plotValue;

    GrandFather5(String name, int noOfPlots, int bankBalance, String location, int plotValue) {
        this.name = name;
        this.noOfPlots = noOfPlots;
        this.bankBalance = bankBalance;
        this.location = location;
        this.plotValue = plotValue;
    }

    void displayProperty() {
        System.out.println("\n[GrandFather5's Property]");
        System.out.println("Name         : " + name);
        System.out.println("Location     : " + location);
        System.out.println("Plots        : " + noOfPlots);
        System.out.println("Bank Balance : ₹" + bankBalance);
        System.out.println("Total Wealth : ₹" + getTotalWealth());
    }

    int getTotalWealth() {
        return bankBalance + (noOfPlots * plotValue);
    }
}

// Intermediate Class - Father5 inherits GrandFather5
class Father5 extends GrandFather5 {
    String Father5Name;
    int ownPlots;
    int ownBalance;
    int inheritedPlotsFromG;
    int inheritedBalanceFromG;

    Father5(String gName, int gPlots, int gBalance, String gLocation, int plotValue,
            String fName, int ownPlots, int ownBalance) {

        super(gName, gPlots, gBalance, gLocation, plotValue);
        this.Father5Name = fName;
        this.ownPlots = ownPlots;
        this.ownBalance = ownBalance;

        // Inheritance: Father5 receives 50% of GrandFather5's properties
        this.inheritedPlotsFromG = super.noOfPlots / 2;
        this.inheritedBalanceFromG = super.bankBalance / 2;

        // Bonus for metro city location
        if (gLocation.equalsIgnoreCase("Delhi") || gLocation.equalsIgnoreCase("Mumbai")) {
            this.inheritedBalanceFromG += 1000000;
        }
    }

    void displayProperty() {
        System.out.println("\n[Father5's Property]");
        System.out.println("Name              : " + Father5Name);
        System.out.println("Own Plots         : " + ownPlots);
        System.out.println("Own Balance       : ₹" + ownBalance);
        System.out.println("Inherited Plots   : " + inheritedPlotsFromG);
        System.out.println("Inherited Balance : ₹" + inheritedBalanceFromG);
        System.out.println("Total Wealth      : ₹" + getTotalWealth());
    }

    @Override
    int getTotalWealth() {
        int totalPlots = ownPlots + inheritedPlotsFromG;
        int totalMoney = ownBalance + inheritedBalanceFromG;
        return totalMoney + (totalPlots * plotValue);
    }

    // Method to get GrandFather5's total wealth
    int getGrandFatherWealth() {
        return super.getTotalWealth();
    }
}

// Derived Class - Son5 inherits Father5
class Son5 extends Father5 {
    String Son5Name;
    int ownPlots;
    int ownBalance;
    int inheritedPlotsFromF;
    int inheritedBalanceFromF;

    Son5(String gName, int gPlots, int gBalance, String gLocation, int plotValue,
         String fName, int fOwnPlots, int fOwnBalance,
         String sName, int sOwnPlots, int sOwnBalance) {

        super(gName, gPlots, gBalance, gLocation, plotValue, fName, fOwnPlots, fOwnBalance);
        this.Son5Name = sName;
        this.ownPlots = sOwnPlots;
        this.ownBalance = sOwnBalance;

        // Son5 inherits 40% of Father5’s total wealth
        this.inheritedPlotsFromF = super.ownPlots / 2 + super.inheritedPlotsFromG / 3;
        this.inheritedBalanceFromF = super.ownBalance / 2 + super.inheritedBalanceFromG / 3;
    }

    void displayProperty() {
        System.out.println("\n[Son5's Property]");
        System.out.println("Name              : " + Son5Name);
        System.out.println("Own Plots         : " + ownPlots);
        System.out.println("Own Balance       : ₹" + ownBalance);
        System.out.println("Inherited Plots   : " + inheritedPlotsFromF);
        System.out.println("Inherited Balance : ₹" + inheritedBalanceFromF);
        System.out.println("Total Wealth      : ₹" + getTotalWealth());
    }

    @Override
    int getTotalWealth() {
        int totalPlots = ownPlots + inheritedPlotsFromF;
        int totalMoney = ownBalance + inheritedBalanceFromF;
        return totalMoney + (totalPlots * plotValue);
    }

    void compareWealth() {
        int gWealth = getGrandFatherWealth(); // From GrandFather5
        int fWealth = super.getTotalWealth(); // From Father5
        int sWealth = this.getTotalWealth();   // From Son5

        System.out.println("\n[Wealth Comparison]");
        System.out.println("GrandFather5 Wealth : ₹" + gWealth);
        System.out.println("Father5 Wealth      : ₹" + fWealth);
        System.out.println("Son5 Wealth         : ₹" + sWealth);

        if (sWealth > fWealth && sWealth > gWealth) {
            System.out.println("✅ " + Son5Name + " is the richest among 3 generations.");
        } else if (fWealth > gWealth && fWealth > sWealth) {
            System.out.println("✅ " + Father5Name + " is the richest among 3 generations.");
        } else {
            System.out.println("✅ " + name + " (GrandFather5) is the richest among 3 generations.");
        }
    }
}

// Main Class
public class p11 {
    public static void main(String[] args) {
        System.out.println("\n========= Multilevel Inheritance Example =========");

        Son5 son1 = new Son5(
            "Mr. Ram Nihoda Mishra", 8, 10000000, "Lucknow", 1000000,
            "Mr. Ramod Mishra", 6, 9000000,
            "Mr. Shyam Mishra", 3, 7000000
        );

        son1.displayProperty();         // Son5
        son1.displayProperty();         // Father5
        son1.getGrandFatherWealth();   // GrandFather5
        son1.compareWealth();

        Son5 son2 = new Son5(
            "Mr. Kondiram Sawant", 6, 12000000, "Mumbai", 1200000,
            "Mr. Vijay Sawant", 5, 8000000,
            "Mr. Akshay Sawant", 4, 6000000
        );

        son2.displayProperty();         // Son5
        son2.displayProperty();         // Father5
        son2.getGrandFatherWealth();   // GrandFather5
        son2.compareWealth();
    }
}

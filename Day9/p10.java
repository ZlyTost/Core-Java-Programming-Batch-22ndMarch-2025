package Day9;

// 👴 Base Class - GrandFather4
class GrandFather4 {
	String name;
	int noOfPlots;
	int bankBalance;
	String location;
	int plotValue;  // Per plot value in ₹

	GrandFather4(String name, int noOfPlots, int bankBalance, String location, int plotValue) {
		this.name = name;
		this.noOfPlots = noOfPlots;
		this.bankBalance = bankBalance;
		this.location = location;
		this.plotValue = plotValue;
	}

	void displayGProperty() {
		System.out.println("\n--- GrandFather4's Property ---");
		System.out.println("Name         : " + name);
		System.out.println("Location     : " + location);
		System.out.println("Plots Owned  : " + noOfPlots + " (₹" + plotValue + " each)");
		System.out.println("Bank Balance : ₹" + bankBalance);
		System.out.println("Total Wealth : ₹" + getTotalWealth());
	}

	int getTotalWealth() {
		return bankBalance + (noOfPlots * plotValue);
	}

	void reduceAfterInheritance(int inheritedPlots, int inheritedBalance) {
		this.noOfPlots -= inheritedPlots;
		this.bankBalance -= inheritedBalance;
	}
}

// 👨 Father4 inherits GrandFather4 (Single Inheritance)
class Father4 extends GrandFather4 {
	String Father4Name;
	int ownPlots;
	int ownBalance;
	int inheritedPlots;
	int inheritedBalance;
	int totalWealth;

	Father4(String gName, int gPlots, int gBalance, String gLocation, int gPlotValue,
	       String fName, int ownPlots, int ownBalance) {

		super(gName, gPlots, gBalance, gLocation, gPlotValue);
		this.Father4Name = fName;
		this.ownPlots = ownPlots;
		this.ownBalance = ownBalance;

		// Inheritance logic - Father4 gets 50%
		this.inheritedPlots = super.noOfPlots / 2;
		this.inheritedBalance = super.bankBalance / 2;

		// Apply location bonus if in Metro city
		if (gLocation.equalsIgnoreCase("Mumbai") || gLocation.equalsIgnoreCase("Delhi")) {
			this.inheritedBalance += 1000000; // Metro bonus
			this.ownBalance += 1000000;       // Father4 also earns better
		}

		// Update GrandFather4's values
		super.reduceAfterInheritance(this.inheritedPlots, this.inheritedBalance);

		// Calculate final wealth
		totalWealth = getTotalNetWorth();
	}

	void displayFProperty() {
		System.out.println("\n--- Father4's Property ---");
		System.out.println("Name               : " + Father4Name);
		System.out.println("Own Plots          : " + ownPlots);
		System.out.println("Own Balance        : ₹" + ownBalance);
		System.out.println("Inherited Plots    : " + inheritedPlots);
		System.out.println("Inherited Balance  : ₹" + inheritedBalance);
		System.out.println("Total Net Worth    : ₹" + totalWealth);
	}

	int getTotalNetWorth() {
		int totalPlots = ownPlots + inheritedPlots;
		int totalMoney = ownBalance + inheritedBalance;
		return totalMoney + (totalPlots * plotValue);
	}

	void compareWealthWithGrandFather4() {
		int gWealth = super.getTotalWealth();
		int fWealth = this.getTotalNetWorth();

		System.out.println("\n[Wealth Comparison]");
		System.out.println("GrandFather4 (" + super.name + ") Net Worth : ₹" + gWealth);
		System.out.println("Father4 (" + Father4Name + ") Net Worth     : ₹" + fWealth);

		if (fWealth > gWealth) {
			System.out.println("✅ " + Father4Name + " is richer than " + super.name +
					" by ₹" + (fWealth - gWealth));
		} else if (fWealth < gWealth) {
			System.out.println("❌ " + super.name + " was richer than " + Father4Name +
					" by ₹" + (gWealth - fWealth));
		} else {
			System.out.println("🔁 Both have equal net worth.");
		}
	}
}

//Main Class
public class p10{
	public static void main(String[] args) {

		System.out.println("\n======= Single Inheritance with Advanced Logic =======");

		Father4 f1 = new Father4(
			"Mr. Ram Nihoda Mishra", 6, 6000000, "Lucknow", 1000000,
			"Mr. Ramod Mishra", 4, 8000000
		);
		f1.displayGProperty();
		f1.displayFProperty();
		f1.compareWealthWithGrandFather4();

		Father4 f2 = new Father4(
			"Mr. Kondiram Sawant", 4, 10000000, "Mumbai", 1500000,
			"Mr. Vijay Sawant", 3, 9000000
		);
		f2.displayGProperty();
		f2.displayFProperty();
		f2.compareWealthWithGrandFather4();
	}
}

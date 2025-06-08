package Day9;

//Base Class - GrandFather6
class GrandFather6 {
	String name;
	int noOfPlots;
	int bankBalance;
	String location;
	int plotValue;

	GrandFather6(String name, int noOfPlots, int bankBalance, String location, int plotValue) {
		this.name = name;
		this.noOfPlots = noOfPlots;
		this.bankBalance = bankBalance;
		this.location = location;
		this.plotValue = plotValue;
	}

	void displayProperty() {
		System.out.println("\n[GrandFather6's Property]");
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

//First Child - Father6
class Father6 extends GrandFather6 {
	String Father6Name;
	int ownPlots;
	int ownBalance;
	int inheritedPlots;
	int inheritedBalance;

	Father6(String gName, int gPlots, int gBalance, String gLocation, int plotValue,
	       String Father6Name, int ownPlots, int ownBalance) {

		super(gName, gPlots, gBalance, gLocation, plotValue);
		this.Father6Name = Father6Name;
		this.ownPlots = ownPlots;
		this.ownBalance = ownBalance;

		this.inheritedPlots = super.noOfPlots / 2;
		this.inheritedBalance = super.bankBalance / 2;

		if (gLocation.equalsIgnoreCase("Delhi") || gLocation.equalsIgnoreCase("Mumbai")) {
			this.inheritedBalance += 1000000;
		}
	}

	void displayProperty() {
		System.out.println("\n[Father6's Property]");
		System.out.println("Name              : " + Father6Name);
		System.out.println("Own Plots         : " + ownPlots);
		System.out.println("Own Balance       : ₹" + ownBalance);
		System.out.println("Inherited Plots   : " + inheritedPlots);
		System.out.println("Inherited Balance : ₹" + inheritedBalance);
		System.out.println("Total Wealth      : ₹" + getTotalWealth());
	}

	int getTotalWealth() {
		int totalPlots = ownPlots + inheritedPlots;
		int totalMoney = ownBalance + inheritedBalance;
		return totalMoney + (totalPlots * plotValue);
	}
}

//Second Child - Uncle
class Uncle extends GrandFather6 {
	String uncleName;
	int ownPlots;
	int ownBalance;
	int inheritedPlots;
	int inheritedBalance;

	Uncle(String gName, int gPlots, int gBalance, String gLocation, int plotValue,
	      String uncleName, int ownPlots, int ownBalance) {

		super(gName, gPlots, gBalance, gLocation, plotValue);
		this.uncleName = uncleName;
		this.ownPlots = ownPlots;
		this.ownBalance = ownBalance;

		this.inheritedPlots = super.noOfPlots / 2;
		this.inheritedBalance = super.bankBalance / 2;

		if (gLocation.equalsIgnoreCase("Delhi") || gLocation.equalsIgnoreCase("Mumbai")) {
			this.inheritedBalance += 1000000;
		}
	}

	void displayProperty() {
		System.out.println("\n[Uncle's Property]");
		System.out.println("Name              : " + uncleName);
		System.out.println("Own Plots         : " + ownPlots);
		System.out.println("Own Balance       : ₹" + ownBalance);
		System.out.println("Inherited Plots   : " + inheritedPlots);
		System.out.println("Inherited Balance : ₹" + inheritedBalance);
		System.out.println("Total Wealth      : ₹" + getTotalWealth());
	}

	int getTotalWealth() {
		int totalPlots = ownPlots + inheritedPlots;
		int totalMoney = ownBalance + inheritedBalance;
		return totalMoney + (totalPlots * plotValue);
	}
}

// Main Class
public class p12 {
	public static void main(String[] args) {

		System.out.println("\n======= Hierarchical Inheritance Example =======");

		Father6 Father6 = new Father6(
			"Mr. Ram Nihoda Mishra", 6, 6000000, "Lucknow", 1000000,
			"Mr. Ramod Mishra", 4, 8000000
		);

		Uncle uncle = new Uncle(
			"Mr. Ram Nihoda Mishra", 6, 6000000, "Lucknow", 1000000,
			"Mr. Raghu Mishra", 3, 9000000
		);

		Father6.displayProperty();
		uncle.displayProperty();

		compareWealth(Father6, uncle);
	}

	static void compareWealth(Father6 f, Uncle u) {
		System.out.println("\n[Wealth Comparison Between Siblings]");
		if (f.getTotalWealth() > u.getTotalWealth()) {
			System.out.println("✅ " + f.Father6Name + " is wealthier than " + u.uncleName);
		} else if (f.getTotalWealth() < u.getTotalWealth()) {
			System.out.println("✅ " + u.uncleName + " is wealthier than " + f.Father6Name);
		} else {
			System.out.println("✅ Both have equal wealth.");
		}
	}
}

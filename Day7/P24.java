package Day7;
//Program 17: Voting Eligibility
class Voter {
    void checkEligibility(int age) {
        if (age >= 18)
            System.out.println("Eligible to vote");
        else
            System.out.println("Not eligible to vote");
    }
}

public class P24 {
    public static void main(String[] args) {
        Voter v = new Voter();
        v.checkEligibility(21);
    }
}

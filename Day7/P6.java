package Day7;
//Program 22: Palindrome Number
class Palindrome {
    void isPalindrome(int num) {
        int temp = num, rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        if (temp == rev)
            System.out.println(temp + " is a palindrome");
        else
            System.out.println(temp + " is not a palindrome");
    }
}

public class P6{
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.isPalindrome(121);
    }
}

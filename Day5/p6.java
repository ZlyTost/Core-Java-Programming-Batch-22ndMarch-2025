package Day5;

import java.util.Scanner;

public class p6 {
//19.Calculate the Area of a Rectangle
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter length of the rectangle: ");
	        double length = scanner.nextDouble();
	        System.out.print("Enter width of the rectangle: ");
	        double width = scanner.nextDouble();
	        double area = length * width;
	        System.out.println("Area of the rectangle: " + area);
	        scanner.close();
	    }
	}
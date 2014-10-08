package oop_class;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		boolean success = false;

		while (!success) {
			System.out.println ("\nPlease enter simple equation: ");
			try {
				int first = in.nextInt();
				String operator = in.next();
				int second = in.nextInt();

				switch (operator) {
				case "+":
					System.out.println(first + second);
					
					break;
				case "-":
					System.out.println(first - second);
					
					break;
				case "*":
					System.out.println(first * second);
					
					break;
				case "/":
					System.out.println(first / second);
				
					break;
				case "%":
					System.out.println(first % second);
					break;
				default:
					System.out.println("This system does not support \"" + operator + "\" ");

				}

			} catch (Exception e) {
				System.out.println("Your input is incorrect! Please enter a valid equation");
				System.out.println("Ex. 1 + 1");
				in.nextLine();
				continue;
			}
		}
	}

}

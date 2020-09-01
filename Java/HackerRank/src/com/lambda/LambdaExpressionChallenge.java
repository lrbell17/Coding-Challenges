package com.lambda;

import java.util.Scanner;

// functional interface
interface FuncInt {
	boolean check(int num);
}

public class LambdaExpressionChallenge {

	private static Scanner input = new Scanner(System.in);
	
	public static int getUserInput() {
		int userInt;
		while (true) {
			try {
				input = new Scanner(System.in);
				System.out.println("Enter a positive number: ");
				userInt = input.nextInt();

				if (userInt > 0) {
					return userInt;
				}
				else {
					System.out.println("\nInvalid Expression, must be positive!\n");
				}
			} catch (Exception e) {
				System.out.println("\nInvalid Expression!\n");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		while (true) {
			int userInt = getUserInput();

			// Even/Odd Checker
			FuncInt isOdd = (int num) -> {
				if (num % 2 == 0) {
					return false;
				} else {
					return true;
				}
			};

			// Prime Checker
			FuncInt isPrime = (int num) -> {
				if (num == 1 || num == 2) { // 1 and 2 are prime
					return true;
				}
				if (isOdd.check(num) == false) { // even numbers are not prime
					return false;
				}
				for (int i = 3; i < num / 2; i += 2) {
					if (num % i == 0) { // check if it's divisible
						return false;
					}
				}
				return true;
			};

			// Palindrome Checker
			FuncInt isPalindrome = (int num) -> {
				String numStr = Integer.toString(num);

				for (int i = 0; i * 2 < numStr.length(); i++) {
					if (numStr.charAt(i) != numStr.charAt(numStr.length() - i - 1)) {
						return false;
					}
				}
				return true;

			};

			// display message to user
			System.out.println(isOdd.check(userInt) ? "\nODD" : "\nEVEN");
			System.out.println(isPrime.check(userInt) ? "PRIME" : "COMPOSITE");
			System.out.println(isPalindrome.check(userInt) ? "PALINDROME\n" : "NOT A PALINDROME\n");

			
		}
	}

}

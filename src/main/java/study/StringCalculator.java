package study;

import java.util.Scanner;

public class StringCalculator {

	public int arithmeticOperation(int left, int right, Character operator) {
		switch (operator) {
			case '+':
				return left + right;
			case '-':
				return left - right;
			case '*':
				return left * right;
			default:
				return left / right;
		}
	}

	// public int calculate(String expr) {
	// 	String[] values = expr.split(" ");
		
	// }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		StringCalculator test = new StringCalculator();

		// int result = test.calculate(line);

		// System.out.println(result);

	}
}

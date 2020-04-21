package com.main;

public class PascalsBruteForce {

	public static void printPascal(int n) {
		for (int row = 1; row <= n; row++) {

			int value = 1;// used to represent C(line, i)
			for (int elem = 1; elem <= row; elem++) {
				// The first value in a line is always 1
				System.out.print(value + " ");
				value = value * (row - elem) / elem;
			}
			System.out.println();
		}
	}

	// Driver code
	public static void main(String[] args) {
		int n = 5;
		printPascal(n);
	}

}

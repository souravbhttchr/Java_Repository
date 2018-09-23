package com.main;

import java.util.HashMap;
import java.util.Map;

public class BinomialCoefficient {

	private static Map<Integer, Integer> factorialMap;
	
	public static void main(String[] args) {

		BinomialCoefficient bc = new BinomialCoefficient();
		
		int val = bc.findBinomialCoefficient(6, 5);
		
		System.out.println(val);
		
	}

	private int findBinomialCoefficient(int row, int element) {
		
		factorialMap = new HashMap<>();
		factorialMap.put(0, 1);
		factorialMap.put(1, 1);
		
		int val1 = findFactorial(row);
		int val2 = findFactorial(element);
		int val3 = findFactorial(row-element);
		
		return (findFactorial(row)/(findFactorial(element)*findFactorial(row-element)));
	}

	private int findFactorial(int i) {
		
		if (i >= 0) {
			if (!factorialMap.containsKey(i)) {
				factorialMap.put(i, i * (findFactorial(i - 1)));
			}
		}
		
		return factorialMap.get(i);
	}
	
	

}

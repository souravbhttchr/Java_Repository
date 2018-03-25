package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCoins {
	private static int[] denom = {1,2,5,10,20};
	private static int[] quant = {3,2,2,3,2};
	private static int sum = 58;
	private static Map<Integer, Integer> denomQuant = new HashMap<>();
	private static List<Integer> addedElem = new ArrayList<>();
	private static int numOfCoins = 0;
	
	public static void main(String[] args) {
		for(int i=0; i<denom.length; i++){
			denomQuant.put(denom[i], quant[i]);
		}
		
		int currentSum = 0;
		Map<Integer, Integer> copyOfDenomQuant = denomQuant;
		int targetSum = sum;
		
		findCombinations(currentSum, copyOfDenomQuant, targetSum);
	}

	private static void findCombinations(int currentSum, Map<Integer, Integer> copyOfDenomQuant, int targetSum) {

		if(targetSum == currentSum){
			for(int i=0; i<addedElem.size(); i++){
				System.out.print(addedElem.get(i) + " ");
			}
		
			numOfCoins = addedElem.size();
			System.out.println("\nNumber of Coins : "+numOfCoins);
			addedElem.removeAll(addedElem);
			
			return;
		}
		else if(currentSum < targetSum){
			List<Integer> availableDenom = new ArrayList<>();
			
			for (Integer integer : denom) {
				if(copyOfDenomQuant.get(integer) != 0){
					availableDenom.add(integer);
				}
			}
			
			if(availableDenom.size() != 0){
				for (int i=availableDenom.size()- 1; i >= 0; i--) {
					if (targetSum - currentSum >= availableDenom.get(i)) {
						int elemToAdd = availableDenom.get(i);
						addedElem.add(elemToAdd);

						copyOfDenomQuant.put(elemToAdd, copyOfDenomQuant.get(elemToAdd) - 1);
						currentSum += elemToAdd;
						findCombinations(currentSum, copyOfDenomQuant, targetSum);
						break;
					}
				}
			}
		}
	}
}

package com.main;

import java.util.HashMap;
import java.util.Map;

class Knapsack {

	
	private int val[] = { 100, 60, 120, 300 };
	private int wt[] = { 60, 20, 30, 20 };
	private int W = 50;
	private int n = val.length;
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int knapSack(int C, int i) {
	
		Map<Integer, Wrapper> table = new HashMap<>();   //Tabulation to handle Overlapping subproblems
		
		//Base case 1 : When i starts after the end of the array of value and weight
		if(i > n-1){
			table.put(C, new Wrapper(i, 0));
			return 0;
		}
		
		//Base case 2 : when Weight of first element is more than the total permissible weight
		if(wt[i] > C){
			if(null != table.get(C) && i+1 == table.get(C).getKey()){
				return table.get(C).getValue();
			} else{
				table.put(C, new Wrapper(i+1, knapSack(C, i+1)));
				return table.get(C).getValue();
			}
		} else{
			int valueWhenElementIsDenied = 0;
			int valueWhenElementIsConsidered = 0;
			
			if(null != table.get(C) && i+1 == table.get(C).getKey()){
				valueWhenElementIsDenied = table.get(C).getValue();
			} else{
				table.put(C, new Wrapper(i+1, knapSack(C, i+1)));
				valueWhenElementIsDenied = table.get(C).getValue();
			}
			
			if(null != table.get(C-wt[i]) && i+1 == table.get(C-wt[i]).getKey()){
				valueWhenElementIsConsidered = table.get(C-wt[i]).getValue();
			} else{
				table.put(C-wt[i], new Wrapper(i+1, knapSack(C-wt[i], i+1)));
				valueWhenElementIsConsidered = table.get(C-wt[i]).getValue();
			}
			
			return max(valueWhenElementIsDenied, val[i]+valueWhenElementIsConsidered);
		}
		
	}

	public static void main(String args[]) {
		int i = 0;
		Knapsack ks = new Knapsack();
		System.out.println(ks.knapSack(ks.W, i));
	}
}

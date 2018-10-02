package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BSTCounter {

	private static Map<Integer, Integer> table = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter the number of Nodes :");
		
		int numOfNodes = sc.nextInt();
		
		List<Integer> nodes = new ArrayList<>();
		
		int count = 0;
		
		if (numOfNodes == 0) {
			count = 0;
		} else if (numOfNodes == 1) {
			count = 1;
		} else if (numOfNodes == 2) {
			count = 2;
		} else if (numOfNodes == 3) {
			count = 5;
		} else {
			BSTCounter bstc = new BSTCounter();
			count = bstc.counter(nodes, numOfNodes);
		}
		
		System.out.println("No of BSTs : " +count);
	}

	private int counter(List<Integer> nodes, int numOfNodes) {
		int count = 0;
		if(numOfNodes == 0){
			if(!table.containsKey(0)){ //Overlapping Subproblems
				table.put(0, 1);
			}
			return table.get(0);
		} else if(numOfNodes == 1){
			if(!table.containsKey(1)){ //Overlapping Subproblems
				table.put(1, 1);
			}
			return table.get(1);
		} else if(numOfNodes == 2){
			if(!table.containsKey(2)){ //Overlapping Subproblems
				table.put(2, 2);
			}
			return table.get(2);
		} else if(numOfNodes == 3){
			if(!table.containsKey(3)){ //Overlapping Subproblems
				table.put(3, 5);
			}
			return table.get(3);
		} else{
			for(int i=0; i<numOfNodes; i++){
				if(!table.containsKey(i-0)){ //Overlapping Subproblems
					table.put(i-0, counter(nodes, i-0));
				}
				if(!table.containsKey(numOfNodes-1-i)){ //Overlapping Subproblems
					table.put(numOfNodes-1-i, counter(nodes, numOfNodes-1-i));
				}
				int countLeft = table.get(i-0);
				int countRight = table.get(numOfNodes-1-i);
				count += (countLeft*countRight);
			}
			return count;
		}
	}
}

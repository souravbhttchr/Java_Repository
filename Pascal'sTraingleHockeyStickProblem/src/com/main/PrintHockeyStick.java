package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintHockeyStick {

	private static int pascalsRow;
	private static Map<PascalTriangleNode, Integer> table = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Row : ");
		
		int targetRow = sc.nextInt();
		
		int targetIndex = targetRow;
		
		System.out.println("Enter length of HockeyStick : ");
		
		int length = sc.nextInt();
		
		pascalsRow = targetRow+length;
		
		PrintHockeyStick phs = new PrintHockeyStick();
		
		phs.createPascalsTriangle(1, 1);
		
		for(int i=0; i<length; i++){
			System.out.print(table.get(new PascalTriangleNode(targetRow, targetIndex)));
			targetRow++;
			
			if(i < length-1){
				System.out.print(" + ");
			}
		}
		
		System.out.print(" = "+table.get(new PascalTriangleNode(targetRow, targetIndex+1)));
	}

	private void createPascalsTriangle(int row, int index) {
		if (row <= pascalsRow) {
			if (row > 0) {
				if (index == 1 || index == row) {
					table.put(new PascalTriangleNode(row, index), 1);
				} else {
					table.put(new PascalTriangleNode(row, index), table.get(new PascalTriangleNode(row - 1, index - 1))
							+ table.get(new PascalTriangleNode(row - 1, index)));
				}
			}

			if (index < row) {
				createPascalsTriangle(row, index + 1);
			} else {
				createPascalsTriangle(row + 1, 1);
			}
		}
	}
}

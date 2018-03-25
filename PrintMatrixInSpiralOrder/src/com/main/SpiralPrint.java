package com.main;

public class SpiralPrint {

	private static int startRow = 0;
	private static int startCol = 0;
	private static int endRow = 0;
	private static int endCol = 0;
	
	public static void main(String[] args) {
			int[][] matrix = {{1,2,3,4},
							  {6,7,8,9},
							  {11,12,13,14},
							  {16,17,18,19},
							  {21,22,23,24}};
			
			endRow = matrix.length-1;
			endCol = matrix[0].length-1;
			
			SpiralPrint sp = new SpiralPrint();
			
			sp.printSpiral(matrix, 0, 0);
	}

	private void printSpiral(int[][] matrix, int currRow, int currCol) {
		
		if(currRow >= startRow && currCol <= endCol){
			for (int i = currCol; i<=endCol; i++){
				System.out.print(" "+matrix[currRow][i]);
			}
			
			startRow++;
			currRow++;
			currCol = endCol;
		}
		
		if(currRow <= endRow && currCol <=endCol){
			for (int i = currRow; i<=endRow; i++) {
				System.out.print(" "+matrix[i][currCol]);
			}
			
			endCol--;
			currCol--;
			currRow = endRow;
		}
		
		if(currRow <= endRow && currCol >= startCol){
			for(int i = currCol; i >= startCol; i--){
				System.out.print(" "+matrix[currRow][i]);
			}
			
			endRow--;
			currRow--;
			currCol=startCol;
		}
		
		if(currRow >= startRow && currCol >=startCol){
			for(int i = currRow; i >= startRow; i--){
				System.out.print(" "+matrix[i][currCol]);
			}
			
			startCol++;
			currCol++;
			currRow=startRow;
		}
		
		if(startRow < endRow && startCol < endCol){
			printSpiral(matrix, currRow, currCol);
		} else if(startRow == endRow && startCol == endCol){
			System.out.println(" "+matrix[startRow][startCol]);
		}
		
	}

}

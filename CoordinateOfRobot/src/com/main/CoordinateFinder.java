package com.main;

public class CoordinateFinder {

	public static void main(String[] args) {
		String command = "LULDDRURDURRDDLLR";
		
		int countU = 0;
		int countD = 0;
		int countL = 0;
		int countR = 0;
		
		int x = 0;
		int y = 0;
		
		for(int i=0; i<command.length(); i++){
			if(command.charAt(i) == 'U'){
				countU++;
			} else if(command.charAt(i) == 'D'){
				countD++;
			} else if(command.charAt(i) == 'L'){
				countL++;
			} else if(command.charAt(i) == 'R'){
				countR++;
			}
		}
		
		x += countR;
		x -= countL;
		y += countU;
		y -= countD;
		
		System.out.println("Final coordinate is : (" + x + "," + y + ")");
	}

}

package com.main;

import java.math.BigInteger;

public class NextPrime {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger(String.valueOf(45));
		
		System.out.println(bi.nextProbablePrime());
	}

}

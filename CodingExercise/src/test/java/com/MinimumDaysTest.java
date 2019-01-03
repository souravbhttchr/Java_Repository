package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinimumDaysTest {

	private MinimumDays minDays = null;
	

	@Before
	public void setUpBeforeClass() throws Exception {
		minDays = new MinimumDays();
	}

	@Test
	public void findMinDays_Test_valid1() {
		
		int A = 3;
		int K = 5;
		int P = 1;
		
		int asha = P;
		int kelly = 0;
		
		Assert.assertEquals(1, minDays.findMinDays(asha, kelly, A, K));
	}
	
	@Test
	public void findMinDays_Test_valid2() {
		
		int A = 4;
		int K = 5;
		int P = 1;
		
		int asha = P;
		int kelly = 0;
		
		Assert.assertEquals(2, minDays.findMinDays(asha, kelly, A, K));
	}
	
	@Test
	public void findMinDays_Test_valid3() {
		
		int A = 3;
		int K = 6;
		int P = 6;
		
		int asha = P;
		int kelly = 0;
		
		Assert.assertEquals(3, minDays.findMinDays(asha, kelly, A, K));
	}
	
	@Test
	public void findMinDays_Test_valid4() {
		
		int A = 2;
		int K = 5;
		int P = 2;
		
		int asha = P;
		int kelly = 0;
		
		Assert.assertEquals(1, minDays.findMinDays(asha, kelly, A, K));
	}
	
	@Test
	public void findMinDays_Test_Cant_Surpass() {
		
		int A = 10;
		int K = 3;
		int P = 3;
		
		int asha = P;
		int kelly = 0;
		
		Assert.assertEquals(-1, minDays.findMinDays(asha, kelly, A, K));
	}
	
	@Test
	public void findMinDays_Test_Invalid1() {
		
		int A = 0;
		int K = 0;
		int P = 0;
		
		int asha = P;
		int kelly = 0;
		
		Assert.assertEquals(-1, minDays.findMinDays(asha, kelly, A, K));
	}
	

}

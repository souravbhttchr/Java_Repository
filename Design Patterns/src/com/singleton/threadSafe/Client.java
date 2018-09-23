package com.singleton.threadSafe;

public class Client {

	public static void main(String[] args) {
		
		ThreadSafeLazyInitialization instance1 = ThreadSafeLazyInitialization.getInstance1();
		ThreadSafeLazyInitialization instance2 = ThreadSafeLazyInitialization.getInstance1();
		
		ThreadSafeLazyInitialization instance3 = ThreadSafeLazyInitialization.getInstance2();
		ThreadSafeLazyInitialization instance4 = ThreadSafeLazyInitialization.getInstance2();
		
		if(instance1 == instance2 && instance3 == instance4){
			System.out.println("Single instance created...");
		} else{
			System.out.println("Not single instance...");
		}
	}
}

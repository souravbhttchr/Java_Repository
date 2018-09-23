package com.singleton.lazyInitialization;

public class Client {

	public static void main(String[] args) {
		
		LazyInitialization instance1 = LazyInitialization.getInstance();
		
		LazyInitialization instance2 = LazyInitialization.getInstance();
		
		if(instance1 == instance2){
			System.out.println("Single instance created...");
		} else{
			System.out.println("Not single instance...");
		}
	}
}

package com.singleton.eagerInitialization;

public class Client {

	public static void main(String[] args) {
		
		EagerInitialization instance1 = EagerInitialization.getInstance();
		
		EagerInitialization instance2 = EagerInitialization.getInstance();
		
		if(instance1 == instance2){
			System.out.println("Single instance created...");
		} else{
			System.out.println("Not single instance...");
		}
	}
}

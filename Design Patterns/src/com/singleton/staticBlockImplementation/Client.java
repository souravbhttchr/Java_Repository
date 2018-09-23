package com.singleton.staticBlockImplementation;

public class Client {

	public static void main(String[] args) {
		
		StaticBlockEagerInitialization instance1 = StaticBlockEagerInitialization.getInstance();
		
		StaticBlockEagerInitialization instance2 = StaticBlockEagerInitialization.getInstance();
		
		if(instance1 == instance2){
			System.out.println("Single instance created...");
		} else{
			System.out.println("Not single instance...");
		}
	}
}

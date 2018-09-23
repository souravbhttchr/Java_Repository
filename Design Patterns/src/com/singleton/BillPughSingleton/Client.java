package com.singleton.BillPughSingleton;

public class Client {

	public static void main(String[] args) {
		
		BillPughSingleton instance1 = BillPughSingleton.getInstance();
		
		BillPughSingleton instance2 = BillPughSingleton.getInstance();
		
		if(instance1 == instance2){
			System.out.println("Single instance created...");
		} else{
			System.out.println("Not single instance...");
		}
	}
}

package com.singleton.staticBlockImplementation;

import javax.management.RuntimeErrorException;

public class StaticBlockEagerInitialization {

	private static StaticBlockEagerInitialization instance;

	private StaticBlockEagerInitialization() {
	}
	
	static{
		try{
			instance = new StaticBlockEagerInitialization();
		}catch(Exception e){
			throw new RuntimeErrorException(null, "Exception Occured in Creating Instance...");
		}
	}
	
	public static StaticBlockEagerInitialization getInstance(){
		return instance;
	}
}

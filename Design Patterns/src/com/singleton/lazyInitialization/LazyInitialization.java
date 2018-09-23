package com.singleton.lazyInitialization;

public class LazyInitialization {

	private static LazyInitialization instance = null;

	private LazyInitialization() {
	}
	
	public static LazyInitialization getInstance(){
		if(instance == null){
			instance = new LazyInitialization();
		}
		return instance;
	}
}

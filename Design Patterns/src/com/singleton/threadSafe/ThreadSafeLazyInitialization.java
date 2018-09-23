package com.singleton.threadSafe;

public class ThreadSafeLazyInitialization {

	private static ThreadSafeLazyInitialization instance;

	private ThreadSafeLazyInitialization() {
	}
	
	public static synchronized ThreadSafeLazyInitialization getInstance1(){
		if(instance == null){
			instance = new ThreadSafeLazyInitialization();
		}
		return instance;
	}
	
	public static ThreadSafeLazyInitialization getInstance2(){
		synchronized (ThreadSafeLazyInitialization.class) {
			if(instance == null){
				instance = new ThreadSafeLazyInitialization();
			}
			return instance;
		}
	}
}

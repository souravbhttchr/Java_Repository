package com.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		
		ThreadOperation to = new ThreadOperation();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				to.locker1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				to.locker2();
			}
		});
		
		executor.submit(t1);
		executor.submit(t2);
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

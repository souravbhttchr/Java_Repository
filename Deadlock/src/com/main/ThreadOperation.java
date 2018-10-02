package com.main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadOperation {

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	
	public void threadOperation1(){
		
		while(true){
			System.out.println("Looping in threadOperation1.....");
			continue;
		}
	}
	
	public void threadOperation2(){
		
		while(true){
			System.out.println("Looping in threadOperation2.....");
			continue;
		}
	}
	
	public void locker1(){
		lock1.lock();
		System.out.println("Lock1 acquired by thread1.");
		lock2.lock();
		System.out.println("Lock2 acquired by thread2.");
		try{
			threadOperation1();
		}
		catch(Exception e){
			e.getMessage();
		}
			lock1.unlock();
			lock2.unlock();
	}
	
	public void locker2(){
		lock2.lock();
		System.out.println("Lock2 acquired by thread2.");
		lock1.lock();
		System.out.println("Lock1 acquired by thread1.");
		try{
			threadOperation2();
		}
		catch(Exception e){
			e.getMessage();
		}
			lock2.unlock();
			lock1.unlock();
		
	}
}

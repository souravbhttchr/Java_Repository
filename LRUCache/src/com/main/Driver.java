package com.main;

public class Driver {

	public static void main(String[] args) {

		LRU lru = new LRU(3);
		
		System.out.println(lru.put(1));
		System.out.println(lru.put(1));
		System.out.println(lru.put(1));
		System.out.println(lru.put(1));
		System.out.println(lru.put(1));
		System.out.println(lru.put(1));
		System.out.println(lru.put(1));
		
		lru.printCache();
	}

}

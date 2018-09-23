package com.factory.SingletonFactory;

public class PC implements Computer {

	private static Computer instance = null;
	
	private int RAM;
	private int HDD;
	private String processor;
	
	private PC(int RAM, int HDD, String processor) {
		this.RAM = RAM;
		this.HDD = HDD;
		this.processor = processor;
	}
	
	public static Computer getPCInstance(int ram, int hdd, String processor){
		try{
			if(instance == null){
				instance = new PC(ram, hdd, processor);
			}
		} catch(Exception e){
			System.out.println("Error creating PC Instance...");
		}
		
		return instance;
	}

	@Override
	public int getRAM() {
		return this.RAM;
	}

	@Override
	public int getHDD() {
		return this.HDD;
	}

	@Override
	public String getProcessor() {
		return this.processor;
	}

}

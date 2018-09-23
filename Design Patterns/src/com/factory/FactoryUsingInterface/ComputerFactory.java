package com.factory.FactoryUsingInterface;

public class ComputerFactory {
	
	private ComputerFactory(){
		
	}
	
	public static Computer getComputer(String type, int ram, int hdd, String processor){
		Computer comp = null;
		if("PC".equalsIgnoreCase(type)){
			comp = new PC(ram, hdd, processor);
		} else if("Server".equalsIgnoreCase(type)){
			comp = new Server(ram, hdd, processor);
		}
		
		return comp;
	}
	
}

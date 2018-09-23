package com.factory.SingletonFactory;

public class ComputerFactory {
	
	public static Computer getComputer(String type, int ram, int hdd, String processor){
		Computer comp = null;
		if("PC".equalsIgnoreCase(type)){
			comp = PC.getPCInstance(ram, hdd, processor);
		} else if("Server".equalsIgnoreCase(type)){
			comp = Server.getServerInstance(ram, hdd, processor);
		}
		
		return comp;
	}
	
}

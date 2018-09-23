package com.factory.FactoryUsingInterface;

public class Client {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", 512, 5, "Intel i3");
		
		System.out.println(pc.getRAM());
		System.out.println(pc.getHDD());
		System.out.println(pc.getProcessor());
		
		Computer server = ComputerFactory.getComputer("Server", 5000, 1000, "Intel i7");
		
		System.out.println(server.getRAM());
		System.out.println(server.getHDD());
		System.out.println(server.getProcessor());
	}

}

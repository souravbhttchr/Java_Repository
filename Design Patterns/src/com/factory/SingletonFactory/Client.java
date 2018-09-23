package com.factory.SingletonFactory;

public class Client {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", 1024, 5, "Intel i3");
		Computer pc2 = ComputerFactory.getComputer("PC", 2048, 5, "Intel i3");
		
		System.out.println(pc.getRAM());
		System.out.println(pc.getHDD());
		System.out.println(pc.getProcessor());
		
		System.out.println(pc2.getRAM());
		System.out.println(pc2.getHDD());
		System.out.println(pc2.getProcessor());
		
		Computer server = ComputerFactory.getComputer("Server", 5000, 1000, "Intel i7");
		
		System.out.println(server.getRAM());
		System.out.println(server.getHDD());
		System.out.println(server.getProcessor());
	}

}

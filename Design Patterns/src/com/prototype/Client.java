package com.prototype;

public class Client {

	public static void main(String[] args) {
		EmployeesDeepCopy emps = new EmployeesDeepCopy();
		emps.loadData();
		
		try{
			EmployeesDeepCopy emps2 = (EmployeesDeepCopy) emps.clone();
			EmployeesDeepCopy emps3 = (EmployeesDeepCopy) emps.clone();
			
			emps2.getEmpNames().remove("Paulami");
			emps3.getEmpNames().add("Mrinal");
			
			System.out.println(emps2.getEmpNames());
			System.out.println(emps3.getEmpNames());
			System.out.println(emps.getEmpNames());
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

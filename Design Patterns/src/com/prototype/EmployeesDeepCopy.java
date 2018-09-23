package com.prototype;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDeepCopy implements Cloneable{

	private List<String> empNames;

	public EmployeesDeepCopy() {
		empNames = new ArrayList<>();
	}

	public EmployeesDeepCopy(List<String> empNames) {
		this.empNames = empNames;
	}

	public void loadData(){
		empNames.add("Sourav");
		empNames.add("Paulami");
		empNames.add("Soumik");
		empNames.add("Gita");
	}

	public List<String> getEmpNames() {
		return empNames;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		List<String> temp = new ArrayList<>();
		
		for (String string : this.getEmpNames()) {
			temp.add(string);
		}
		
		return new EmployeesDeepCopy(temp);
	}
	
}

package com.main;

public class PascalTriangleNode {
	
	private int row;
	private int index;
	
	public PascalTriangleNode(int row, int index) {
		this.row = row;
		this.index = index;
	}
	
	@Override
	public int hashCode(){
		return Integer.parseInt(row + "" + index);
	}

	@Override
	public boolean equals(Object o){
		if(o != null && o instanceof PascalTriangleNode){
			PascalTriangleNode ptn = (PascalTriangleNode) o;
			return (ptn.getRow() == this.getRow() && ptn.getIndex() == this.getIndex() ? true : false);
		}
		
		return false;
	}
	
	public int getRow() {
		return row;
	}

	public int getIndex() {
		return index;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

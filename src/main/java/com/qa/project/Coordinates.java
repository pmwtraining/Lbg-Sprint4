package com.qa.project;

public class Coordinates {
	
	// x and y coordinates
	private int x = 0, y = 0;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinates() {
		
	}
	
	// method to find distance from coordinates
	public double getDistance() {
		return Math.hypot(x, y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}

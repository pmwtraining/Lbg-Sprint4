package com.qa.project.entities;

import com.qa.project.Coordinates;

public abstract class GameEntity {
	
	// location of entity
	private final Coordinates location;
	
	// if the entity ends game
	private final boolean gameOver;
	
	// entity message when found
	private final String message;
	
	// constructor
	public GameEntity(Coordinates location, boolean gameOver, String message) {
		this.location = location;
		this.gameOver = gameOver;
		this.message = message;
	}
	
	public GameEntity() {
		this.location = new Coordinates();
		this.gameOver = false;
		this.message = "Abstract class";
	}
	
	// update location
	public void updateCoords(int x, int y) {
		this.location.setX(this.location.getX() + x);
		this.location.setY(this.location.getY() + y);
	}
	
	// get distance to our entity
	public double getDistance() {
		return this.location.getDistance();
	}
	
	// check gameOver
	public boolean isGameOver() {
		return gameOver;
	}
	
	// getter for message
	public String getMessage() {
		return message;
	}
}

package com.qa.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.qa.project.entities.GameEntity;
import com.qa.project.entities.Monster;
import com.qa.project.entities.Treasure;

public class Game {
	
	// list of game entities
	private List<GameEntity> entities;

	//scanner
	private UserInput input;
	
	// grid size
	private int size;
	
	private Treasure treasure;
	
	// grab random
	private Random rand = new Random();
	
	// constructor
	public Game(UserInput input, int size) {
		this.input = input;
		this.size = size;
		
		this.entities = new ArrayList<>();
	}
	
	// method to generate a GameEntity coordinates
	public Coordinates generateCoordinates() {
		Coordinates newCoords = new Coordinates();
		do {
			newCoords.setX(rand.nextInt(size) - (size/2));
			newCoords.setY(rand.nextInt(size) - (size/2));
		} while(newCoords.getDistance() == 0); // if goal is at start, generate new coordinates
		
		return newCoords;
	}
	
	// setup methods
	public void setup() {
		this.treasure = new Treasure(this.generateCoordinates());
		this.entities.add(treasure);
		this.entities.add(new Monster(this.generateCoordinates()));
	}
	
	// method to run the game
	public void start() {
		do {
			System.out.println("Game Started");
			System.out.println("try 'north', 'south', 'east' or 'west'");
			
			this.setup();
			
			do {
				System.out.println("you are '" + this.treasure.getDistance() + "' from the goal");
				this.move();
			} while( !gameOver() ); // I HAVE CHANGED THIS LINE

		} while(this.restart());
		System.out.println("thanks for playing");
	}
	
	// method to check if game is over
	private boolean gameOver() {
		for(GameEntity entity : entities) {
			// System.out.println(entity.getDistance()); // comment me out later
			if (entity.getDistance() == 0) {
				System.out.println(entity.getMessage());
				if (entity.isGameOver() == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	// method to update location of GameEntities
	private void updateCoords(int x, int y) {
		for(GameEntity entity : entities) {
			entity.updateCoords(x, y);
		}
	}
	
	// method to restart game
	public boolean restart() {
		System.out.println("do you want to restart? y/n");
		return this.input.read().equalsIgnoreCase("y");
	}
	
	// switch case to move
	private void move() {
		boolean validInput = true;
		
		do {
			String direction = this.input.read().toLowerCase();
			
			switch(direction) {
				case("north"):
					System.out.println("you move north");
					this.updateCoords(0, -1);
					validInput = true;
					break;
				case("south"):
					System.out.println("you move south");
					this.updateCoords(0, +1);
					validInput = true;
					break;
				case("east"):
					System.out.println("you move east");
					this.updateCoords(-1, 0);
					validInput = true;
					break;
				case("west"):
					System.out.println("you move west");
					this.updateCoords(+1, 0);
					validInput = true;
					break;
				default:
					System.out.println("please enter 'north', 'south', 'east' or 'west'");
					validInput = false;
			}
			
		} while(!validInput);
	}
	
}

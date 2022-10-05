package com.qa.project;

import java.util.Random;

public class Game {

	//scanner
	private UserInput input;
	
	// grid size
	private int size;
	
	// coordinates
	private Coordinates goal;
	
	// grab random
	private Random rand = new Random();
	
	// constructor
	public Game(UserInput input, int size) {
		this.input = input;
		this.size = size;
	}
	
	// method to generate a goal
	public Coordinates generateGoal() {
		Coordinates goal = new Coordinates();
		do {
			goal.setX(rand.nextInt(size) - (size/2));
			goal.setY(rand.nextInt(size) - (size/2));
		} while(goal.getDistance() == 0); // if goal is at start, generate new coordinates
		
		return goal;
	}
	
	// method to run the game
	public void start() {
		do {
			System.out.println("Game Started");
			System.out.println("try 'north', 'south', 'east' or 'west'");
			this.goal = this.generateGoal();
			do {
				System.out.println("you are '" + this.goal.getDistance() + "' from the goal");
				this.move();
			} while( this.goal.getDistance() > 0);// check our distance
			System.out.println("YOU WON!");
		} while(this.restart());
		System.out.println("thanks for playing");
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
					this.goal.setY(this.goal.getY() - 1);
					validInput = true;
					break;
				case("south"):
					System.out.println("you move south");
					this.goal.setY(this.goal.getY() + 1);
					validInput = true;
					break;
				case("east"):
					System.out.println("you move east");
					this.goal.setX(this.goal.getX() - 1);
					validInput = true;
					break;
				case("west"):
					System.out.println("you move west");
					this.goal.setX(this.goal.getX() + 1);
					validInput = true;
					break;
				default:
					System.out.println("please enter 'north', 'south', 'east' or 'west'");
					validInput = false;
			}
			
		} while(!validInput);
	}
	
}

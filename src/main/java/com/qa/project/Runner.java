package com.qa.project;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		try (UserInput input = new UserInput(new Scanner(System.in))) {
			// This is where we will start our game
			Game game = new Game(input, 5);
			game.start();
		}
	}

}

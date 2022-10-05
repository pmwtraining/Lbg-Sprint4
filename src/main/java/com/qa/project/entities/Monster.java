package com.qa.project.entities;

import com.qa.project.Coordinates;

public class Monster extends GameEntity {
	
	public Monster(Coordinates location) {
		super(location, true, "You have been eaten by a grue!");
	}
	
	public Monster() {
		this(new Coordinates());
	}
	
}

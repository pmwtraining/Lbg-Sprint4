package com.qa.project.entities;

import com.qa.project.Coordinates;

public class Treasure extends GameEntity {

	public Treasure(Coordinates location) {
		super(location, true, "You found the treasure!");
	}
	
	public Treasure() {
		this(new Coordinates());
	}

}

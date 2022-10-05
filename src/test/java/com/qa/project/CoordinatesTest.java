package com.qa.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinatesTest {
	
	private Coordinates coords = new Coordinates(3,4);
	
	@Test
	public void defaultConstructorTest() {
		assertTrue(new Coordinates() instanceof Coordinates);
	}
	
	@Test
	public void getDistanceTest() {
		assertEquals(5.0, this.coords.getDistance(), 0.1);
	}
	
	@Test
	public void getXTest() {
		assertEquals(3.0, this.coords.getX(), 0.1);
	}
	
	@Test
	public void getYTest() {
		assertEquals(4.0, this.coords.getY(), 0.1);
	}
	
	@Test
	public void setXTest() {
		Coordinates testCoords = new Coordinates(3,4);
		testCoords.setX(9);
		assertEquals(9, testCoords.getX());
	}
	
	@Test
	public void setYTest() {
		Coordinates testCoords = new Coordinates(3,4);
		testCoords.setY(16);
		assertEquals(16, testCoords.getY());
	}
	
}

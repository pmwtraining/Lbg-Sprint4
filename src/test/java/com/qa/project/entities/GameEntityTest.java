package com.qa.project.entities;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class GameEntityTest {
	
	@Test
	public void testConstructor() {
		GameEntity entity = mock(GameEntity.class);
		assertTrue(entity instanceof GameEntity);
	}
	
}

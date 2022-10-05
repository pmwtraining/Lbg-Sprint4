package com.qa.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@InjectMocks
	private Game game;
	
	//@Mock
	private UserInput input = mock(UserInput.class);
	
	@Test
	public void testRestart() {
		Mockito.when(this.input.read()).thenReturn("y");
		assertTrue(this.game.restart());
		Mockito.verify(this.input, Mockito.times(1)).read();
	}
	
	@Test
	public void testEnd() {
		Mockito.when(this.input.read()).thenReturn("n");
		assertFalse(this.game.restart());
		Mockito.verify(this.input, Mockito.times(1)).read();
	}
}

package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeGUITest {
	private TicTacToeView view;
	
    @Before
    public void setup() {
		view = new TicTacToeView("X");
    }
    
    @Test
	public void testSomething() {
		assertTrue(true);
	}
	
    @Test
    public void testInitialBoardIsEmpty() {
        for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				assertEquals("", view.getButtonFace(i, j));
			}
		}
    }
}

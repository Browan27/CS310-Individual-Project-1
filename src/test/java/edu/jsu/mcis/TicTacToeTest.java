package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToeModel model;
	
    @Before
    public void setup() {
		model = new TicTacToeModel("X");
    }
    
    @Test
	public void testInitialBoardIsEmpty() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				assertEquals("", model.getMark(i, j));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.makeMark(0, 2);
		assertEquals("X", model.getMark(0, 2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
        model.reset("O");
		model.makeMark(2, 0);
		assertEquals("O", model.getMark(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.makeMark(1, 1);
		assertEquals("X", model.getMark(1, 1));
		model.makeMark(1, 1);
		assertEquals("X", model.getMark(1, 1));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.makeMark(1, 1);
        assertTrue(!(model.gameOver()));
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.makeMark(0, 0);
        model.makeMark(1, 0);
        model.makeMark(0, 1);
        model.makeMark(1, 1);
        model.makeMark(0, 2);
        assertTrue(model.gameOver());
        assertEquals("X", model.getWinner());
	}
    
    @Test
	public void testGameIsWonByOAcrossBottomRow() {
		model.makeMark(1, 1);
        model.makeMark(2, 0);
        model.makeMark(0, 0);
        model.makeMark(2, 2);
        model.makeMark(0, 2);
        model.makeMark(2, 1);
        assertTrue(model.gameOver());
        assertEquals("O", model.getWinner());
	}
    
    @Test
	public void testGameIsWonByOVerticallyAcrossMiddleCollum() {
		model.makeMark(0, 0);
        model.makeMark(0, 1);
        model.makeMark(1, 0);
        model.makeMark(1, 1);
        model.makeMark(0, 2);
        model.makeMark(2, 1);
        assertTrue(model.gameOver());
        assertEquals("O", model.getWinner());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.makeMark(0,0);
        model.makeMark(0,1);
        model.makeMark(1,0);
        model.makeMark(2,0);
        model.makeMark(1,1);
        model.makeMark(2,2);
        model.makeMark(1,2);
        model.makeMark(2,1);
        model.makeMark(0,2);
        assertTrue(model.gameOver());
        assertEquals("TIE", model.getWinner());
	}	
}

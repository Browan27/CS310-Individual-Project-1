package edu.jsu.mcis;

public class TicTacToeModel {
	private int[][] grid;
    private boolean xTurn;
    private String winner;
    private int movesMade;
	
	public TicTacToeModel() {
		this("X");
	}
    
    public TicTacToeModel(String start) {
		grid = new int[3][3];
        winner = "";
        movesMade = 0;
        if(start.equals("X")) { xTurn = true; }
        else if(start.equals("O")) { xTurn = false; }
        else { xTurn = true; }
	}
	
	public String getMark(int row, int col) {
		if(grid[row][col] == 0) return "";
		else if(grid[row][col] == 1) return "X";
		else return "O";
	}
	
	public void makeMark(int row, int col) {
		if(grid[row][col] == 0) {
			if(xTurn) grid[row][col] = 1;
			else if(!xTurn) grid[row][col] = 2;
			else grid[row][col] = 0;
		}
        xTurn = !xTurn;
        update();
	}
    
    private void update() {
        movesMade++;
        if((grid[0][0] == grid[0][1]) && (grid[0][0] == grid[0][2])) { winner = getMark(0, 0); }
        else if((grid[1][0] == grid[1][1]) && (grid[1][0] == grid[1][2])) { winner = getMark(1, 0); }
        else if((grid[2][0] == grid[2][1]) && (grid[2][0] == grid[2][2])) { winner = getMark(2, 0); }
        else if((grid[0][0] == grid[1][0]) && (grid[0][0] == grid[2][0])) { winner = getMark(0, 0); }
        else if((grid[0][1] == grid[1][1]) && (grid[0][1] == grid[2][1])) { winner = getMark(0, 1); }
        else if((grid[0][2] == grid[1][2]) && (grid[0][2] == grid[2][2])) { winner = getMark(0, 2); }
        else if((grid[0][0] == grid[1][1]) && (grid[2][2] == grid[2][2])) { winner = getMark(0, 0); }
        else if((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0])) { winner = getMark(0, 2); }
        
        if(movesMade == 9) { winner = "TIE"; }
    }
    
    public void reset(String start) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = 0;
            }
        }
        if(start.equals("X")) { xTurn = true; }
        else if(start.equals("O")) { xTurn = false; }
        else { xTurn = true; }
        winner = "";
    }
    
    public boolean gameOver() {
        if(winner.equals("")) { return false; }
        else { return true; }
    }
    
    public String getWinner() {
        return winner;
    }
}














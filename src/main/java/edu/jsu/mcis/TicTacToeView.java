package edu.jsu.mcis;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class TicTacToeView extends JPanel implements ActionListener {
    private TicTacToeModel model;
    private JButton[][] grid;
    private JDialog gameOver;
    private boolean gameRunning;
	
    public TicTacToeView() { this("X"); }
    
    public TicTacToeView(String s) {
        gameRunning = true;
		model = new TicTacToeModel(s);
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3,3));
        grid = new JButton[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = new JButton();
                grid[i][j].addActionListener(this);
                grid[i][j].setName("Location" + i + j);
                board.add(grid[i][j]);
            }
        }
        setLayout(new BorderLayout());
        add(board, BorderLayout.CENTER);
	}
    
    public String getButtonFace(int r, int c) {
        return grid[r][c].getText();
    }
    
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton)event.getSource();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == button) {
                    model.makeMark(i, j);
                    grid[i][j].removeActionListener(this);
                    grid[i][j].setText(model.getMark(i, j));
                }
            }
        }
        if(gameRunning) { update(); }
    }
    
    private void update() {
        if(model.gameOver()) {
            gameRunning = false;
            gameOver = new JDialog();
            gameOver.setModal(false);
            gameOver.setName("Game Over");
            gameOver.setTitle("The Winner is: ");
            JLabel winner = new JLabel(model.getWinner());
            winner.setName("Winner");
            gameOver.add(winner);
            gameOver.setVisible(true);
        }
    }
}














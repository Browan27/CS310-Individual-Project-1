package edu.jsu.mcis;

import javax.swing.*;

public class Main {
    
	public static void main(String[] args) {
        JFrame TicTacToe = new JFrame();
        TicTacToe.setTitle("Tic Tac Toe");
        
        TicTacToeView view = new TicTacToeView("X");
        
        TicTacToe.add(view);
        TicTacToe.pack();
        TicTacToe.setVisible(true);
    }
}
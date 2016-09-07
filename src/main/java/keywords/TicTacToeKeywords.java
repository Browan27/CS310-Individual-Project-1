package keywords;

import edu.jsu.mcis.*;

public class TicTacToeKeywords {
    private TicTacToeModel model;
    private boolean turn;
    
    public void startNewGame() {
        model = new TicTacToeModel();
    }
    
    public void markLocation(int r, int c) {
        model.makeMark(r, c);
    }
    
    public String getMark(int r, int c) {
        return model.getMark(r, c);
    }
    
    public String getWinner() {
        return model.getWinner();
    }
}




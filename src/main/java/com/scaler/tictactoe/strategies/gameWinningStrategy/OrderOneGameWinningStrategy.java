package main.java.com.scaler.tictactoe.strategies.gameWinningStrategy;

import main.java.com.scaler.tictactoe.models.Board;
import main.java.com.scaler.tictactoe.models.Cell;
import main.java.com.scaler.tictactoe.models.Player;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    public boolean checkWinner(Board board, Player lastMovePlayer, Cell moveCell) {
        return true;
    }
}

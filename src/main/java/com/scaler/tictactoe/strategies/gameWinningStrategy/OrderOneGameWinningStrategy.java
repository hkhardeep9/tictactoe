package main.java.com.scaler.tictactoe.strategies.gameWinningStrategy;

import main.java.com.scaler.tictactoe.models.Board;
import main.java.com.scaler.tictactoe.models.Cell;
import main.java.com.scaler.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    private List<HashMap<Character,Integer>> rowSymbolCounts = new ArrayList<>();
    private List<HashMap<Character,Integer>> colSymbolCounts = new ArrayList<>();
    private HashMap<Character,Integer> topLeftDiagonalCounts = new HashMap<>();
    private HashMap<Character,Integer> topRightDiagonalCounts = new HashMap<>();

    public OrderOneGameWinningStrategy(int dimension) {
        for(int i = 0 ; i < dimension ; ++i){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }
    public boolean isCellOnTopLeftDiag(int row, int col){
        return row == col;
    }
    public boolean isCellOnTopRightDiag(int row, int col,int dimension){
        return row + col == dimension-1;
    }
    public boolean checkWinner(Board board, Player lastMovePlayer, Cell moveCell) {
        char symbol = moveCell.getPlayer().getSymbol();
        int row = moveCell.getRow();
        int col = moveCell.getCol();
        int dimension = board.getBoard().size();
        if(!rowSymbolCounts.get(row).containsKey(symbol)){
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).get(symbol) + 1);

        if(!colSymbolCounts.get(col).containsKey(symbol)){
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts.get(col).put(symbol, colSymbolCounts.get(col).get(symbol) + 1);
        if(isCellOnTopLeftDiag(row,col)){
            if(!topLeftDiagonalCounts.containsKey(symbol)){
                topLeftDiagonalCounts.put(symbol, 0);
            }
            topLeftDiagonalCounts.put(symbol, topLeftDiagonalCounts.get(symbol) + 1);
        }
        if(isCellOnTopRightDiag(row,col,board.getBoard().size())){
            if(!topRightDiagonalCounts.containsKey(symbol)){
                topRightDiagonalCounts.put(symbol, 0);
            }
            topRightDiagonalCounts.put(symbol, topRightDiagonalCounts.get(symbol) + 1);
        }
        if((rowSymbolCounts.get(row).get(symbol) == dimension) || (colSymbolCounts.get(row).get(symbol) == dimension)
                ){
            return true;
        }
        if ((isCellOnTopLeftDiag(row,col)) && (topLeftDiagonalCounts.get(symbol) == dimension)) return true;
        if((isCellOnTopRightDiag(row,col,dimension)) && (topRightDiagonalCounts.get(symbol) == dimension)) return true;

        return false;
    }
}

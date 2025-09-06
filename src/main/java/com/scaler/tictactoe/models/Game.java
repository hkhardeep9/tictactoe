package main.java.com.scaler.tictactoe.models;

import main.java.com.scaler.tictactoe.exceptions.InvalidGameConstrutorParameterException;
import main.java.com.scaler.tictactoe.strategies.gameWinningStrategy.GameWinningStrategy;
import main.java.com.scaler.tictactoe.strategies.gameWinningStrategy.OrderOneGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;
    int dimension;

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    private Game(){
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void undo(){}
    public void displayBoard(){
        this.board.display();
    }
    public void makeNextMove(){
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It is " + currentPlayer.getSymbol() + "'s turn");
        Move move = currentPlayer.decideMove(this.board);
        //Validate move
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        System.out.println("Move happend at row : " + row + ", column" + col);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(currentPlayer);
        Move finalMove = new Move(currentPlayer,board.getBoard().get(row).get(col));
        move.getCell().setCellState(CellState.FILLED);

        this.moves.add(finalMove);
        if(!gameWinningStrategy.checkWinner(board,currentPlayer,finalMove.getCell())){
            gameStatus = GameStatus.ENDED;
            winner = currentPlayer;
        }

        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();
    }


    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;

        private boolean valid() throws InvalidGameConstrutorParameterException {
            if(this.dimension < 3){
                throw new InvalidGameConstrutorParameterException("Dimensions cannot be < 3");
            }
            if(this.players.size() != this.dimension-1){
                throw new InvalidGameConstrutorParameterException("Players must be dimension-1");
            }
            //Validate no 2 people with same char
            //validate only 1 bot
            return true;
        }

        public Builder setDimenesion(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Game build() throws InvalidGameConstrutorParameterException {
            try{
                valid();
            }catch (Exception e){
                throw new InvalidGameConstrutorParameterException(e.getMessage());
            }
            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimension));
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));

            return game;
        }
    }

}

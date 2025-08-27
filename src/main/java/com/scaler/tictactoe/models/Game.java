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
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy());

            return game;
        }
    }

}

package main.java.com.scaler.tictactoe.controllers;

import main.java.com.scaler.tictactoe.exceptions.InvalidGameConstrutorParameterException;
import main.java.com.scaler.tictactoe.models.Game;
import main.java.com.scaler.tictactoe.models.GameStatus;
import main.java.com.scaler.tictactoe.models.Player;

import java.util.List;

//this class allows all actions on the game
public class GameController {
    public void undo(Game game){
        game.undo();
    }

    public Game createGame(int dimensions, List<Player> players) throws InvalidGameConstrutorParameterException {
        try {
            return Game.getBuilder().setDimenesion(dimensions).setPlayers(players).build();
        }catch (InvalidGameConstrutorParameterException e){
            return null;
        }
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void executeNewMove(Game game){
        game.makeNextMove();
    }
}

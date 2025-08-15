package main.java.com.scaler.tictactoe.models;

public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    public Player(char symbol, String name, PlayerType type){
        this.symbol = symbol;
        this.name = name;
        this.type = type;
    }
}

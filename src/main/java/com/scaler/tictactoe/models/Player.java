package main.java.com.scaler.tictactoe.models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    public Player(String name,char symbol, PlayerType type){
        this.symbol = symbol;
        this.name = name;
        this.type = type;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move decideMove(Board  board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please tell row starting from 0");
        int row = sc.nextInt();
        System.out.println("Please tell col starting from 0");
        int col = sc.nextInt();
        return new Move(this,new Cell(row,col));
    }
}

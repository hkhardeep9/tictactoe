package main.java.com.scaler.tictactoe.models;

import main.java.com.scaler.tictactoe.factories.BotPlayingStrategyFactory;
import main.java.com.scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;

import java.util.Scanner;

public class Bot extends Player {

    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot( String name, char aSymbol) {
        super(name,aSymbol,PlayerType.BOT);
        this.difficultyLevel = BotDifficultyLevel.EASY;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategyForDifficultyLevel(difficultyLevel);
    }

    public Move decideMove(Board board){
        return botPlayingStrategy.decideMove(this,board);
    }
}

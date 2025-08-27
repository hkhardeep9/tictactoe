package main.java.com.scaler.tictactoe.models;

import main.java.com.scaler.tictactoe.factories.BotPlayingStrategyFactory;
import main.java.com.scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {

    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot( char aSymbol,String name, BotDifficultyLevel difficultyLevel) {
        super(aSymbol,name,PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategyForDifficultyLevel(difficultyLevel);
    }
}

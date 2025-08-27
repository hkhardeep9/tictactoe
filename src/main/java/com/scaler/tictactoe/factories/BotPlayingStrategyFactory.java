package main.java.com.scaler.tictactoe.factories;

import main.java.com.scaler.tictactoe.models.Board;
import main.java.com.scaler.tictactoe.models.BotDifficultyLevel;
import main.java.com.scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;
import main.java.com.scaler.tictactoe.strategies.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        return new RandomBotPlayingStrategy();
    }
}

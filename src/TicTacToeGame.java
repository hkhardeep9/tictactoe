import main.java.com.scaler.tictactoe.controllers.GameController;
import main.java.com.scaler.tictactoe.exceptions.InvalidGameConstrutorParameterException;
import main.java.com.scaler.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) throws InvalidGameConstrutorParameterException {
        Scanner scanner = new Scanner(System.in);
        //It will take inupts:dimensions and players
        GameController gameController = new GameController();
        System.out.println("what should be dimensions of the game");
        int dimension = scanner.nextInt();
        System.out.println("will there be any bot?(y/n)");
        String isBot = scanner.next();
        List<Player> players = new ArrayList<>();
        int toIterate = dimension-1;
        if(isBot.equals("y")) {
            toIterate = dimension - 2;
        }
        for(int i = 0 ; i < toIterate; i++){
            System.out.println("What is the name of player " + i);
            String playerName = scanner.next();

            System.out.println("What is the symbol of player " + i);
            String playerSymbol = scanner.next();
            players.add(new Player(playerName,playerSymbol.charAt(0), PlayerType.HUMAN));
        }
        if(isBot.equals("y")){
            System.out.println("what is the name of bot");
            String botName = scanner.next();

            System.out.println("What is the char of bot");
            String botSymbol = scanner.next();
            players.add(new Bot(botName,botSymbol.charAt(0)));
        }

        Game game = gameController.createGame(dimension,players);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is the current board");
            gameController.displayBoard(game);
            System.out.println("Does anyone want to undo y/n");

            String input = scanner.next();
            if(input.equals("y")){
                gameController.undo(game);
            }
            else{
                gameController.executeNewMove(game);
            }
        }
        System.out.println("Game has ended. Result was : ");
        if(!game.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("The winner is : " + gameController.getWinner(game).getName());
        }
    }
}
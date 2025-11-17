package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tictactoe.controllers.GameController;
import tictactoe.models.*;

public class TicTacToeMain {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        System.out.println("===========Welcome to Tic Tac Toe Game!=============");
        // Initialize game components and start the game
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Board Size:");
        int boardSize = scanner.nextInt();
        System.out.println("Enter if Bot Playing Game(Y/N)");
        char isBotPlaying = scanner.next().charAt(0);

        List<Player> players = new ArrayList<>();

        int totaPlayers = boardSize - 1;
        if(isBotPlaying == 'Y' || isBotPlaying == 'y') {
            totaPlayers = boardSize - 2;
        }

        for(int i=1; i<=totaPlayers; i++) {
            System.out.println("Enter Player " + (i) + " Name:");
            String playerName = scanner.next();
            System.out.println("Enter Player " + (i) + " Symbol:");
            char playerSymbol = scanner.next().charAt(0);
            // Add player to the game
            players.add(new Player(playerName, playerSymbol, PlayerType.HUMAN));
        }

        if(isBotPlaying == 'Y' || isBotPlaying == 'y') {
            // Add bot player to the game
            players.add(new Bot("Bot", 'B', GameDiffculty.EASY));
        }

        Game game = gameController.createGame(boardSize, players);

        // we need to check game status constantly
        // once game status is not IN_PROGRESS get our of loop

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            System.out.println("This is current board!");
            gameController.getCurrentGame(game);
            gameController.executeMove(game);



        }

    }
}

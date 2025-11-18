package tictactoe.controllers;

import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;

import java.util.List;

public class GameController {
    // GameController implementation
   public Game createGame(int size, List<Player> players, String winningStratergy) {
       Game game = Game.startGame()
               .setSize(size)
               .setPlayers(players)
               .setGameWinningStratergies(winningStratergy)
               .build();
       return game;
   }

   public GameState getGameState(Game game) {
       return game.getGameState();
   }

   public void getCurrentGame(Game game) {
       game.displayBoard();
   }

    public void executeMove(Game game) {
       game.makeNextMove();
    }
    // get winner from game
    public Player getWinner(Game game) {
       return game.getWinner();
    }
    // displayBoard from game
    public void displayBoard(Game game) {
        game.displayBoard();
    }
}

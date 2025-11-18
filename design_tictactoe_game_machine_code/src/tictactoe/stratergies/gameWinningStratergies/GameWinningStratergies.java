package tictactoe.stratergies.gameWinningStratergies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Player;

public interface GameWinningStratergies {

    public boolean checkWinner(Board board, Player player, Cell movedCell);
}

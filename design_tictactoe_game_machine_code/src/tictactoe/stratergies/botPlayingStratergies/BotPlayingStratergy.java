package tictactoe.stratergies.botPlayingStratergies;

import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface BotPlayingStratergy {

    public Move decideMove(Player player, Board board);
}

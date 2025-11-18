package tictactoe.stratergies.botPlayingStratergies;

import tictactoe.models.Board;
import tictactoe.models.CellState;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class RandomBotPlayingStratergy implements BotPlayingStratergy {
    @Override
    public Move decideMove(Player player, Board board) {
        for(int i=0; i<board.getSize(); i++) {
            for(int j=0; j<board.getSize(); j++) {
                if(board.getCells().get(i).get(j).getState().equals(CellState.EMPTY))
                {
                    return new Move(player, board.getCells().get(i).get(j));
                }
            }
        }
        return null;
    }
}
